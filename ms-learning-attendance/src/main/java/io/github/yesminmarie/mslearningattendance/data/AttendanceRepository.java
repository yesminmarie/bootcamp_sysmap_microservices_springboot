package io.github.yesminmarie.mslearningattendance.data;

import io.github.yesminmarie.mslearningattendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AttendanceRepository extends CrudRepository<Attendance, UUID> {
}
