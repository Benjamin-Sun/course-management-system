package com.benjamin.service;

import com.benjamin.dao.StudentDao;
import com.benjamin.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public Student getStudentByName(String studentName) {
        Student student = new Student();
        try {
            student = studentDao.getStudentByName(studentName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public void addStudent(Student student) {
        studentDao.save(student);
    }

    public int removeStudent(String studentName) {
        return studentDao.updateStudentStatusByName(studentName);
    }
}
