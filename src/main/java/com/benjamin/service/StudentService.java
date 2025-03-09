package com.benjamin.service;

import com.benjamin.repository.StudentRepository;
import com.benjamin.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentByName(String studentName) {
        Student student = new Student();
        try {
            student = studentRepository.getStudentByName(studentName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public int removeStudent(String studentName) {
        return studentRepository.updateStudentStatusByName(studentName);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
