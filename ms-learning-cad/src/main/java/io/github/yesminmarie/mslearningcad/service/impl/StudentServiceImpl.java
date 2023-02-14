package io.github.yesminmarie.mslearningcad.service.impl;

import feign.FeignException;
import io.github.yesminmarie.mslearningcad.clients.CourseControllerClient;
import io.github.yesminmarie.mslearningcad.controller.input.CreateStudentInput;
import io.github.yesminmarie.mslearningcad.data.StudentRepository;
import io.github.yesminmarie.mslearningcad.domain.Student;
import io.github.yesminmarie.mslearningcad.exception.CourseNotFoundException;
import io.github.yesminmarie.mslearningcad.exception.MicroservicesComunicationException;
import io.github.yesminmarie.mslearningcad.service.StudentService;
import io.github.yesminmarie.mslearningcad.service.result.CreateStudentResult;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final CourseControllerClient courseControllerClient;
    private final ModelMapper modelMapper;
    @Override
    public CreateStudentResult createStudent(CreateStudentInput createStudentInput) throws CourseNotFoundException, MicroservicesComunicationException {

        try{
            courseControllerClient.getCourseId(createStudentInput.getCourseId());

            Student student = modelMapper.map(createStudentInput, Student.class);
            student.setStudentId(UUID.randomUUID());
            student.setStatus(true);
            student.setCreatedOn(LocalDate.now());
            studentRepository.save(student);
            return modelMapper.map(student, CreateStudentResult.class);

        }catch (FeignException.FeignClientException ex){
            int status = ex.status();
            if(HttpStatus.NOT_FOUND.value() ==  status){
                throw new CourseNotFoundException();
            }
            throw new MicroservicesComunicationException(ex.getMessage(), status);
        }
    }
}
