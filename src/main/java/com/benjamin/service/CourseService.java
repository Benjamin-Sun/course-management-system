package com.benjamin.service;

import com.benjamin.dto.CourseTimeDto;
import com.benjamin.repository.CourseRepository;
import com.benjamin.entity.Course;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    @Autowired
    CourseRepository courseRepository;

    public int updateCourseStatusById(int courseId, int courseStatus) {
        return courseRepository.updateCourseStatusById(courseId, courseStatus);
    }

    public int updateCourseFeeByStudentName(int courseFee, String studentName) {
        return courseRepository.updateCourseFeeByStudentName(studentName, courseFee);
    }

    @Transactional
    public List<Integer> addCourse(List<Course> courseList) {

        List<Course> results = courseRepository.saveAll(courseList);
        return results.stream()
                .map(Course::getCourseId)
                .collect(Collectors.toList());
    }

    public void removeCourse(List<Integer> courseId) {
        courseRepository.deleteAllById(courseId);
    }

    public int addCourseNote(String courseNote, int courseId) {
        return courseRepository.updateCourseNoteById(courseNote, courseId);
    }

    public List<Course> getCourseByTime(LocalDateTime scheduleTime) {
        return courseRepository.getCourseByTime(scheduleTime);
    }

    public List<CourseTimeDto> getAllCourseWithTime() {
        return courseRepository.getAllCourseWithTime();
    }

    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
    }

    public int updateCourseTimeById(LocalDateTime newTime, int courseId) {
        return courseRepository.updateCourseTimeById(newTime, courseId);
    }

    public int getTotalFeeForToday() {
        LocalDate today = LocalDate.now();
        log.info("today date is: " + today);
        return courseRepository.getTotalFeeForToday(today);
    }
}
