package io.github.yesminmarie.mslearningattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("attendance")
public class Attendance {

    @Id
    @Indexed
    private UUID attendanceId;
    @Indexed
    private UUID studentId;
    private UUID courseId;
    private LocalDate classDate;
    private Boolean attendanceStatus;
}
