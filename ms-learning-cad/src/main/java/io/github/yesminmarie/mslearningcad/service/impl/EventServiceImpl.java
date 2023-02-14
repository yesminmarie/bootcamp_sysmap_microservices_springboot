package io.github.yesminmarie.mslearningcad.service.impl;

import io.github.yesminmarie.mslearningcad.domain.Student;
import io.github.yesminmarie.mslearningcad.service.EventService;
import io.github.yesminmarie.mslearningcad.service.event.CreateStudentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventServiceImpl implements EventService {

    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @Override
    public void sendEventToKafka(Student student) {
        CreateStudentEvent createStudentEvent = modelMapper.map(student, CreateStudentEvent.class);
        createStudentEvent.setFullName(student.getFirstName().concat(" " + student.getLastName()));
        log.info("Sending payment to topic", createStudentEvent);
        kafkaTemplate.send("student-topic", createStudentEvent);
    }
}
