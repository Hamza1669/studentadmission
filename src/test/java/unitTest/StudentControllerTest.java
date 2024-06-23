package unitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import studentController.StudentController;
import studentEntity.StudentEntity;
import studentService.StudentService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

 @Mock
 private StudentService studentService;

 @InjectMocks
 private StudentController studentController;

 @Test
 public void testGetAllStudents() {
     // Arrange
     List<StudentEntity> students = Arrays.asList(new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male"), new StudentEntity("2","Ali","Sajjad","Ali@example.com","56745679", "21","Male"));
     when(studentService.getAllStudents()).thenReturn(students);

     // Act
     ResponseEntity<List<StudentEntity>> result = studentController.getAllStudents();

     // Assert
     assertEquals(HttpStatus.OK, result.getStatusCode());
     assertEquals(students, result.getBody());
 }

 @Test
 public void testGetStudentById() {
     // Arrange
     StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     when(studentService.getStudentById(student.getId())).thenReturn(student);

     // Act
     ResponseEntity<StudentEntity> result = studentController.getStudentById(student.getId());

     // Assert
     assertEquals(HttpStatus.OK, result.getStatusCode());
     assertEquals(student, result.getBody());
 }

 @Test
 public void testCreateStudent() {
     // Arrange
     StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     when(studentService.createStudent(student)).thenReturn(student);

     // Act
     ResponseEntity<StudentEntity> result = studentController.createStudent(student);

     // Assert
     assertEquals(HttpStatus.CREATED, result.getStatusCode());
     assertEquals(student, result.getBody());
 }

 @Test
 public void testUpdateStudent() {
     // Arrange
	 StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     StudentEntity updatedStudent = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     when(studentService.updateStudent(student.getId(), updatedStudent)).thenReturn(updatedStudent);

     // Act
     ResponseEntity<StudentEntity> result = studentController.updateStudent(student.getId(), updatedStudent);

     // Assert
     assertEquals(HttpStatus.OK, result.getStatusCode());
     assertEquals(updatedStudent, result.getBody());
 }

 @Test
 public void testDeleteStudent() {
     // Arrange
     doNothing().when(studentService).deleteStudent(toString());

     // Act
     ResponseEntity<Void> result = studentController.deleteStudent(toString());

     // Assert
     assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
 }
}

