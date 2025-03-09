package com.benjamin.controller;

import com.benjamin.dto.CourseTimeDto;
import com.benjamin.entity.Course;
import com.benjamin.service.CourseService;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("course")
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    CourseService courseService;

    @GetMapping("/getCourseByTime")
    @ResponseBody
    public List<Course> getCourseByTime(LocalDateTime scheduleTime) {
        return courseService.getCourseByTime(scheduleTime);
    }

    @PostMapping("/updateCourseStatus")
    @ResponseBody
    public int updateCourseStatusById(@RequestBody String params) {
        JSONObject json = new JSONObject(params);
        int courseId = json.getInt("courseId");
        int courseStatus = json.getInt("courseStatus");
        log.info("courseId is: " + courseId);
        log.info("courseStatus is: " + courseStatus);
        return courseService.updateCourseStatusById(courseId, courseStatus);
    }

    @GetMapping("/updateCourseFee")
    @ResponseBody
    public int updateCourseFeeByStudentName(int courseFee, String studentName) {
        return courseService.updateCourseFeeByStudentName(courseFee, studentName);
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public void addCourses(@RequestBody List<Course> courseList) {
        courseService.addCourse(courseList);
    }

    @PostMapping("/removeCourse")
    @ResponseBody
    public void removeCourse(@RequestBody List<Integer> courseIdList) {
        log.info("course Id List is: " + courseIdList.toString());
        courseService.removeCourse(courseIdList);
    }

    @PostMapping("/addCourseNote")
    @ResponseBody
    public int addCourseNote(@RequestBody String params) {
        JSONObject json = new JSONObject(params);
        String courseNote = json.getString("courseNote");
        int courseId = json.getInt("courseId");
        log.info("courseId is: " + courseId);
        log.info("courseNote is: " + courseNote);
        return courseService.addCourseNote(courseNote, courseId);
    }

    @GetMapping("/getCourseById")
    @ResponseBody
    public Course getCourseById (int courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/rescheduleCourse")
    @ResponseBody
    public int reScheduleCourseTime(int courseId, String newTime) {
        log.info("newTime is: " + newTime);
//        LocalDateTime formatTime = Instant.ofEpochMilli(newTime)
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//        log.info("formatTime is: " + formatTime);
        LocalDateTime dateTime = LocalDateTime.parse(newTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return courseService.updateCourseTimeById(dateTime, courseId);
    }

    @GetMapping("/getTotalFeeForToday")
    @ResponseBody
    public int getTotalFeeForToday() {
        return courseService.getTotalFeeForToday();
    }

}
