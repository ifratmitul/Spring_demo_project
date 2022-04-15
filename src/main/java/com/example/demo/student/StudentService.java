package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudetn(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist) {
            throw  new IllegalStateException("Student with id doesn't exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student not found"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
    }
}
