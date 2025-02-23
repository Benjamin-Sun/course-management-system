package com.benjamin.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "student")
@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_birth")
    private LocalDateTime studentBirth;

    @Column(name = "student_status")
    private int studentStatus;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public LocalDateTime getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(LocalDateTime studentBirth) {
        this.studentBirth = studentBirth;
    }

    public int getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(int studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Student() {
    }

    public Student(int studentId, String studentName, String studentGrade, LocalDateTime studentBirth, int studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.studentBirth = studentBirth;
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentGrade='" + studentGrade + '\'' +
                ", studentBirth=" + studentBirth +
                ", studentStatus=" + studentStatus +
                '}';
    }
}
