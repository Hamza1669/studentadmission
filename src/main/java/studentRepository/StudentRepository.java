package studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentEntity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}