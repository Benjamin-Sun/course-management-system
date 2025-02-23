package com.benjamin.po;

import com.benjamin.entity.Course;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleRequestPo {
    private String studentName;
    private List<Course> courseList;
    private List<LocalDateTime> scheduleTimeList;

    // Getters and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<LocalDateTime> getScheduleTimeList() {
        return scheduleTimeList;
    }

    public void setScheduleTimeList(List<LocalDateTime> scheduleTimeList) {
        this.scheduleTimeList = scheduleTimeList;
    }
}