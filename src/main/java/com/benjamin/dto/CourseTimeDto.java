package com.benjamin.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CourseTimeDto {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_note")
    private String courseNote;

    @Column(name = "course_fee")
    private int courseFee;

    @Column(name = "course_status")
    private int courseStatus;

    @Column(name = "schedule_time")
    private LocalDateTime scheduleTime;

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

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public CourseTimeDto(int courseId, String courseNote, int courseFee, int courseStatus, LocalDateTime scheduleTime) {
        this.courseId = courseId;
        this.courseNote = courseNote;
        this.courseFee = courseFee;
        this.courseStatus = courseStatus;
        this.scheduleTime = scheduleTime;
    }

    public CourseTimeDto() {
    }

    @Override
    public String toString() {
        return "CourseTimeDto{" +
                "courseId=" + courseId +
                ", courseNote='" + courseNote + '\'' +
                ", courseFee=" + courseFee +
                ", courseStatus=" + courseStatus +
                ", scheduleTime=" + scheduleTime +
                '}';
    }
}
