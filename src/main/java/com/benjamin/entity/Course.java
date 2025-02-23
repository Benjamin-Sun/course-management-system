package com.benjamin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "course")
@Entity
public class Course {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_note")
    private String courseNote;

    @Column(name = "course_fee")
    private int courseFee;

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

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseNote='" + courseNote + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
