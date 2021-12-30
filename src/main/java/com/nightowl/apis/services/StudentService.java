package com.nightowl.apis.services;

import com.nightowl.apis.models.entities.Student;
import com.nightowl.apis.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
//        ArrayList<Student> stu = new ArrayList<Student>();
//        stu.add(new Student(
//                1L,
//                "shri",
//                "shri@gmail.com",
//                LocalDate.of(1999,10,29)
//
//        ));
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentByEmail =  studentRepository
               .findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent()){
           throw  new IllegalStateException("email taken");
       }
       studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
      boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("doesn't exist");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "doesn't exception"
                ));
        if(name != null && name.length() >0 && !Objects.equals(student.getName(),name) ){
            student.setName(name);
        }
        if(email != null && email.length() >0 && !Objects.equals(student.getEmail(),email) ){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);

        }

    }
}
