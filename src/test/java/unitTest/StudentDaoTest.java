package unitTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import studentEntity.StudentEntity;
import studentDao.StudentDao;

import java.util.List;
import java.util.Optional;

public class StudentDaoTest {

    private StudentDao studentDao;

    @BeforeEach
    public void setUp() {
        studentDao = new StudentDao();
    }

    @Test
    public void testCreateStudent() {
        StudentEntity student = new StudentEntity("1", "John", "Doe", "john@example.com", "1234567890", "21", "Male");
        StudentEntity result = studentDao.createStudent(student);

        assertNotNull(result);
        assertEquals(student, result);
    }

    @Test
    public void testGetAllStudents() {
        StudentEntity student1 = new StudentEntity("1", "John", "Doe", "john@example.com", "1234567890", "21", "Male");
        StudentEntity student2 = new StudentEntity("2", "Jane", "Doe", "jane@example.com", "0987654321", "22", "Female");
        studentDao.createStudent(student1);
        studentDao.createStudent(student2);

        List<StudentEntity> result = studentDao.getAllStudents();

        assertEquals(2, result.size());
        assertTrue(result.contains(student1));
        assertTrue(result.contains(student2));
    }

    @Test
    public void testGetStudentById() {
        StudentEntity student = new StudentEntity("1", "John", "Doe", "john@example.com", "1234567890", "21", "Male");
        studentDao.createStudent(student);

        Optional<StudentEntity> result = studentDao.getStudentById("1");

        assertTrue(result.isPresent());
        assertEquals(student, result.get());
    }

    @Test
    public void testUpdateStudent() {
        StudentEntity student = new StudentEntity("1", "John", "Doe", "john@example.com", "1234567890", "21", "Male");
        studentDao.createStudent(student);

        StudentEntity updatedStudent = new StudentEntity("1", "Johnny", "Doe", "john@example.com", "1234567890", "21", "Male");
        StudentEntity result = studentDao.updateStudent("1", updatedStudent);

        assertNotNull(result);
        assertEquals("Johnny", result.getName());
    }

    @Test
    public void testDeleteStudent() {
        StudentEntity student = new StudentEntity("1", "John", "Doe", "john@example.com", "1234567890", "21", "Male");
        studentDao.createStudent(student);

        studentDao.deleteStudent("1");

        Optional<StudentEntity> result = studentDao.getStudentById("1");

        assertFalse(result.isPresent());
    }
}
