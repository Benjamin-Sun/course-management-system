package com.benjamin.controller;

import com.benjamin.dto.ScheduleCourseDto;
import com.benjamin.dto.StudentCourseScheduleDto;
import com.benjamin.entity.Course;
import com.benjamin.po.ScheduleRequestPo;
import com.benjamin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/getAllCoursesByStudentName")
    @ResponseBody
    public List<ScheduleCourseDto> getScheduleCourseByStudentName(String studentName) {
        return scheduleService.getScheduleCourseByStudentName(studentName);
    }

    @PostMapping("/addSchedule")
    @ResponseBody
    public void addSchedule(@RequestBody ScheduleRequestPo scheduleRequestPo) {
        String studentName = scheduleRequestPo.getStudentName();
        List<Course> courseList = scheduleRequestPo.getCourseList();
        List<LocalDateTime> scheduleTimeList = scheduleRequestPo.getScheduleTimeList();
        scheduleService.addSchedule(studentName,scheduleTimeList,courseList);
    }

    @GetMapping("/getAllStudentCourseAndTimeByMonth")
    @ResponseBody
    public List<StudentCourseScheduleDto> getAllStudentCourseScheduleByMonth(String date) {
        return scheduleService.getAllStudentCourseScheduleDto(date);
    }
}
