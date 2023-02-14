package io.github.yesminmarie.mslearningcad.service;

import io.github.yesminmarie.mslearningcad.domain.Student;

public interface EventService {
    void sendEventToKafka(Student student);
}
