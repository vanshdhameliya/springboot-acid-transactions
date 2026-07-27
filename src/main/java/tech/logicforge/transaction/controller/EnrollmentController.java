package tech.logicforge.transaction.controller;

import tech.logicforge.transaction.dto.EnrollCourseDTO;
import tech.logicforge.transaction.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {

    private final StudentService studentService;

    public EnrollmentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/enroll")
    public String enrollCourse(@RequestBody EnrollCourseDTO enrollCourseDTO) {
        return studentService.enrollCourse(enrollCourseDTO.getStudentId(), enrollCourseDTO.getCourseName(), enrollCourseDTO.getFee());
    }
}
