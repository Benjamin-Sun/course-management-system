package com.benjamin.entity;

import jakarta.persistence.*;

@Table(name = "course")
@Entity
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_note")
    private String courseNote;

    @Column(name = "course_fee")
    private int courseFee;

    @Column(name = "course_status")
    private int courseStatus;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }

    public int getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(int courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Course() {
    }

    public Course(int courseId, String courseNote, int courseFee, int courseStatus) {
        this.courseId = courseId;
        this.courseNote = courseNote;
        this.courseFee = courseFee;
        this.courseStatus = courseStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseNote='" + courseNote + '\'' +
                ", courseFee=" + courseFee +
                ", courseStatus=" + courseStatus +
                '}';
    }
}
