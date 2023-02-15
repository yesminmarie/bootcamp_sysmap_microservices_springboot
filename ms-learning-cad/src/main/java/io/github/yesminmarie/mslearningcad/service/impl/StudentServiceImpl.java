package io.github.yesminmarie.mslearningcad.service.impl;

import feign.FeignException;
import io.github.yesminmarie.mslearningcad.clients.CourseControllerClient;
import io.github.yesminmarie.mslearningcad.clients.dto.CourseResult;
import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.data.StudentRepository;
import io.github.yesminmarie.mslearningcad.domain.Student;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.EventService;
import io.github.yesminmarie.mslearningcad.service.StudentService;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;
import io.github.yesminmarie.mslearningcad.service.result.GetStudentResult;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final EventService eventService;
    private final CourseControllerClient courseControllerClient;
    private final ModelMapper modelMapper;
    @Override
    public CreateStudentResult createStudent(CreateStudentInput createStudentInput) throws CourseNotFoundException, MicroservicesComunicationException {

        try{
            courseControllerClient.getCourseId(createStudentInput.getCourseId());

            Student student = new Student();
            student.setStudentId(UUID.randomUUID());
            student.setStatus(true);
            student.setCreatedOn(LocalDate.now());
            student.setCourseId(createStudentInput.getCourseId());
            student.setDocument(createStudentInput.getDocument());
            student.setFirstName(createStudentInput.getFirstName());
            student.setLastName(createStudentInput.getLastName());
            student.setBirthDate(createStudentInput.getBirthDate());
            studentRepository.insert(student);
            eventService.sendEventToKafka(student);
            return modelMapper.map(student, CreateStudentResult.class);

        }catch (FeignException.FeignClientException ex){
            int status = ex.status();
            if(HttpStatus.NOT_FOUND.value() ==  status){
                throw new CourseNotFoundException();
            }
            throw new MicroservicesComunicationException(ex.getMessage(), status);
        }
    }

    @Override
    public GetStudentResult getStudentById(UUID studentId) {
        Student student = studentRepository
                .findByStudentId(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found!"));
        ResponseEntity<CourseResult> course = courseControllerClient.getCourseId(student.getCourseId());
        GetStudentResult studentResult = modelMapper.map(student, GetStudentResult.class);
        studentResult.setFullName(student.getFirstName().concat(" " + student.getLastName()));
        studentResult.setCourseName(course.getBody().getCourseName());
        return studentResult;
    }
}
