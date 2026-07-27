package tech.logicforge.transaction.repository;

import tech.logicforge.transaction.entity.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
}
