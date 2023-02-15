package io.github.yesminmarie.mslearningattendance.data;

import io.github.yesminmarie.mslearningattendance.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
    Optional<Student> findByStudentIdAndCourseId(UUID studentId, UUID courseId);
}
