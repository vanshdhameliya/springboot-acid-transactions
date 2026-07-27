package tech.logicforge.transaction.repository;

import tech.logicforge.transaction.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
