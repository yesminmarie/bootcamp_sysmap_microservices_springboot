package io.github.yesminmarie.mslearningcad.clients;

import io.github.yesminmarie.mslearningcad.clients.dto.CourseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value = "ms-learning-course", url="http://localhost:8081/api/v1/courses")
public interface CourseControllerClient {

    @GetMapping(params = "courseId")
    ResponseEntity<CourseResult> getCourseId(@RequestParam("courseId") UUID courseId);
}
