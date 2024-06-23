package studentService;

import java.util.List;

import org.springframework.stereotype.Service;

import studentEntity.StudentEntity;
@Service
public interface StudentService {
	
	    List<StudentEntity> getAllStudents();
	    StudentEntity getStudentById(String id);
	    StudentEntity createStudent(StudentEntity student);
	    StudentEntity updateStudent(String id, StudentEntity student);
	    void deleteStudent(String id);

	}
