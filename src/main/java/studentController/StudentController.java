package studentController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentEntity.StudentEntity;
import studentService.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
 private final StudentService studentService;

 public StudentController(StudentService studentService) {
     this.studentService = studentService;
 }
 
 @GetMapping("/students")
 public ResponseEntity<List<StudentEntity>> getAllStudents() {
	 List<StudentEntity> students = studentService.getAllStudents();
     return new ResponseEntity<>(students, HttpStatus.OK);
 }

 @GetMapping("/students/{id}")
 public ResponseEntity<StudentEntity> getStudentById(@PathVariable String id) {
     StudentEntity student = studentService.getStudentById(id);
     if (student != null) {
         return new ResponseEntity<>(student, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping("/students")
 public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
     StudentEntity createdStudent = studentService.createStudent(student);
     return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
 }

 @PutMapping("/students/{id}")
 public ResponseEntity<StudentEntity> updateStudent(@PathVariable String id, @RequestBody StudentEntity updatedStudent) {
     StudentEntity student = studentService.updateStudent(id, updatedStudent);
     return new ResponseEntity<>(student, HttpStatus.OK);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity <Void> deleteStudent(@PathVariable String id) {
     studentService.deleteStudent(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}

