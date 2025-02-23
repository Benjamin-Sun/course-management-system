package com.benjamin.dto;

import java.time.LocalDateTime;

public class StudentCourseScheduleDto {

    private String studentName;

    private int courseId;

    private int courseStatus;

    private LocalDateTime scheduleTime;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public StudentCourseScheduleDto(String studentName, int courseId, int courseStatus, LocalDateTime scheduleTime) {
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseStatus = courseStatus;
        this.scheduleTime = scheduleTime;
    }

    public StudentCourseScheduleDto() {
    }

    @Override
    public String toString() {
        return "StudentCourseScheduleDto{" +
                "studentName='" + studentName + '\'' +
                ", courseId=" + courseId +
                ", scheduleTime=" + scheduleTime +
                '}';
    }
}
