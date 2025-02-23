package com.benjamin.controller;

import com.benjamin.dto.CourseTimeDto;
import com.benjamin.entity.Course;
import com.benjamin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/getCourseByTime")
    @ResponseBody
    public List<Course> getCourseByTime(LocalDateTime scheduleTime) {
        return courseService.getCourseByTime(scheduleTime);
    }

    @GetMapping("/updateCourseStatus")
    @ResponseBody
    public int updateCourseStatusById(int courseId) {
        return courseService.updateCourseStatusById(courseId);
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
    public void removeCourse(List<Integer> courseIdList) {
        courseService.removeCourse(courseIdList);
    }

    @PostMapping("/addCourseNote")
    @ResponseBody
    public int addCourseNote(@RequestBody String courseNote, int courseId) {
        return courseService.addCourseNote(courseNote, courseId);
    }

//    @GetMapping("/getAllCourse")
//    @ResponseBody
//    public List<CourseTimeDto> getAllCourses() {
//        return courseService.getAllCourseWithTime();
//    }

}
