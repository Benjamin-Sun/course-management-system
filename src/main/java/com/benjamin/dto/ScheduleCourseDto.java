package com.benjamin.dto;

import java.time.LocalDateTime;

public class ScheduleCourseDto {

    private int scheduleId;

    private int courseId;

    private LocalDateTime courseTime;

    private String courseNote;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(LocalDateTime courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }

    public ScheduleCourseDto(int scheduleId, int courseId, LocalDateTime courseTime, String courseNote) {
        this.scheduleId = scheduleId;
        this.courseId = courseId;
        this.courseTime = courseTime;
        this.courseNote = courseNote;
    }

    public ScheduleCourseDto() {
    }

    @Override
    public String toString() {
        return "ScheduleCourseDto{" +
                "scheduleId=" + scheduleId +
                ", courseId=" + courseId +
                ", courseTime=" + courseTime +
                ", courseNote='" + courseNote + '\'' +
                '}';
    }
}
