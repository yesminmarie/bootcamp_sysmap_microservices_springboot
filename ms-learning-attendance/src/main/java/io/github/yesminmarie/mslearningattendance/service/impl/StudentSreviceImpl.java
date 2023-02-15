package io.github.yesminmarie.mslearningattendance.service.impl;

import io.github.yesminmarie.mslearningattendance.data.StudentRepository;
import io.github.yesminmarie.mslearningattendance.domain.Student;
import io.github.yesminmarie.mslearningattendance.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StudentSreviceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    @KafkaListener(topics = "student-topic", groupId = "create-student-group", containerFactory = "jsonContainerFactory")
    public void createStudent(@Payload Student student) {
        log.info("Student received {}", student.toString());
        studentRepository.save(student);
    }
}
