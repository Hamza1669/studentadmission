package studentDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import studentEntity.StudentEntity;

public class StudentDao {

    private List<StudentEntity> students = new ArrayList<>();

    // Get all students
    public List<StudentEntity> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Get student by ID
    public Optional<StudentEntity> getStudentById(String id) {
        return students.stream()
                       .filter(student -> student.getId().equals(id))
                       .findFirst();
    }

    // Create a new student
    public StudentEntity createStudent(StudentEntity student) {
        students.add(student);
        return student;
    }

    // Update an existing student
    public StudentEntity updateStudent(String id, StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudentOpt = getStudentById(id);
        if (existingStudentOpt.isPresent()) {
            StudentEntity existingStudent = existingStudentOpt.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setSurname(updatedStudent.getSurname());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setMobile_no(updatedStudent.getMobile_no());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setGender(updatedStudent.getGender());
            return existingStudent;
        } else {
            // Handle student not found scenario
            // For simplicity, let's return null (though throwing an exception might be better in a real application)
            return null;
        }
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
