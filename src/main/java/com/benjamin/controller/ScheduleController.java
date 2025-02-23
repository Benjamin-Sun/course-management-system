package com.benjamin.controller;

import com.benjamin.dto.ScheduleCourseDto;
import com.benjamin.dto.StudentCourseScheduleDto;
import com.benjamin.entity.Course;
import com.benjamin.po.ScheduleRequestPo;
import com.benjamin.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
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
        log.info("date: " + date);
        return scheduleService.getAllStudentCourseScheduleDto(date);
    }
}
