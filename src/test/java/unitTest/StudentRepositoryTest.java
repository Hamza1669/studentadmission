package unitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import studentEntity.StudentEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

 @Mock
 private JpaRepository<StudentEntity, String> studentRepository;

 @Test
 public void testFindAllStudents() {
	 
     // Arrange
     List<StudentEntity> students = Arrays.asList(new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male"), new StudentEntity("2","Ali","Sajjad","Ali@example.com","56745679", "21","Male"));
     when(studentRepository.findAll()).thenReturn(students);
     
     // Act
     List<StudentEntity> result = studentRepository.findAll();

     // Assert
     assertEquals(students, result);
 }

 @Test
 public void testFindStudentById() {
     // Arrange
     StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

     // Act
     Optional<StudentEntity> result = studentRepository.findById(student.getId());

     // Assert
     assertEquals(Optional.of(student), result);
 }

 @Test
 public void testSaveStudent() {
     // Arrange
     StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     when(studentRepository.save(student)).thenReturn(student);
     // Act
     StudentEntity result = studentRepository.save(student);
     // Assert
     assertEquals(student, result);
 }

 @Test
 public void testDeleteStudent() {
     // Arrange
     StudentEntity student = new StudentEntity("1","Hamad", "Sajjad","Hamad@example.com","456756778", "20","Male");
     
     doNothing().when(studentRepository).deleteById(student.getId());

     // Act
     studentRepository.deleteById(student.getId());

     // Assert
     verify(studentRepository, times(1)).deleteById(student.getId());
 }
}

