package studentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentEntity.StudentEntity;
import studentRepository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentEntity updateStudent(String id, StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            
            return studentRepository.save(updatedStudent);
        } else {
            return null; 
        }
    }
}
