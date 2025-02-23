package com.benjamin.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "schedule")
@Entity
public class Schedule {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "schedule_time")
    private LocalDateTime scheduleTime;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Schedule(int scheduleId, int studentId, int courseId, LocalDateTime scheduleTime) {
        this.scheduleId = scheduleId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.scheduleTime = scheduleTime;
    }

    public Schedule() {
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", scheduleTime=" + scheduleTime +
                '}';
    }
}
