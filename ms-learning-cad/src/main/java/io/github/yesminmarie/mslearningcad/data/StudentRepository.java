package io.github.yesminmarie.mslearningcad.data;

import io.github.yesminmarie.mslearningcad.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentRepository extends MongoRepository<Student, UUID> {
}
