package tech.logicforge.transaction.service.isolation;

import tech.logicforge.transaction.service.CourseEnrollmentService;
import tech.logicforge.transaction.service.StudentService;
import org.springframework.stereotype.Component;

@Component
public class ReadUncommitted {

    private final StudentService studentService;
    private final CourseEnrollmentService courseEnrollmentService;

    public ReadUncommitted(StudentService studentService,
                           CourseEnrollmentService courseEnrollmentService) {
        this.studentService = studentService;
        this.courseEnrollmentService = courseEnrollmentService;
    }

    public void readUncommitted(Long id) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                studentService.updateWalletBalance(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000); // ensure T1 updates first
                studentService.readWalletBalance(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
