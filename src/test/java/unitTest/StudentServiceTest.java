package unitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import studentEntity.StudentEntity;
import studentRepository.StudentRepository;
import studentService.StudentServiceImpl;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStudent() {
        // Arrange
        StudentEntity student = new StudentEntity("1", "Hamad", "Sajjad", "Hamad@example.com", "456756778", "20", "Male");
        when(studentRepository.save(student)).thenReturn(student);

        // Act
        StudentEntity result = studentService.createStudent(student);

        // Assert
        assertNotNull(result);
        assertEquals(student, result);
    }

    @Test
    public void testDeleteStudent() {
        // Arrange
        String studentId = "1";
        doNothing().when(studentRepository).deleteById(studentId);

        // Act
        studentService.deleteStudent(studentId);

        // Assert
        verify(studentRepository, times(1)).deleteById(studentId);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<StudentEntity> students = Arrays.asList(
                new StudentEntity("1", "Hamad", "Sajjad", "Hamad@example.com", "456756778", "20", "Male"),
                new StudentEntity("2", "Ali", "Sajjad", "Ali@example.com", "56745679", "21", "Male")
        );
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<StudentEntity> result = studentService.getAllStudents();

        // Assert
        assertNotNull(result);
        assertEquals(students, result);
    }

    @Test
    public void testGetStudentById() {
        // Arrange
        String studentId = "1";
        StudentEntity student = new StudentEntity(studentId, "Hamad", "Sajjad", "Hamad@example.com", "456756778", "20", "Male");
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // Act
        StudentEntity result = studentService.getStudentById(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(student, result);
    }

    @Test
    public void testUpdateStudent() {
        // Arrange
        String studentId = "1";
        StudentEntity existingStudent = new StudentEntity(studentId, "Hamad", "Sajjad", "Hamad@example.com", "456756778", "20", "Male");
        StudentEntity updatedStudent = new StudentEntity(studentId, "Hamad", "Ali", "Hamad@example.com", "456756778", "20", "Male");
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

        // Act
        StudentEntity result = studentService.updateStudent(studentId, updatedStudent);

        // Assert
        assertNotNull(result);
        assertEquals(updatedStudent, result);
    }
}
