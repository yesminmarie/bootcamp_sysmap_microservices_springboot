package io.github.yesminmarie.mslearningattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("student")
public class Student {

    @Id
    @Indexed
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}
