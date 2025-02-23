package com.benjamin.controller;

import com.benjamin.entity.Student;
import com.benjamin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentByName")
    @ResponseBody
    public Student getStudentByName(String studentName) {
        return studentService.getStudentByName(studentName);
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/removeStudent")
    @ResponseBody
    public int removeStudent(String studentName) {
        return studentService.removeStudent(studentName);
    }
}
