package com.benjamin.service;

import com.benjamin.dto.CourseTimeDto;
import com.benjamin.repository.CourseRepository;
import com.benjamin.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public int updateCourseStatusById(int courseId) {
        return courseRepository.updateCourseStatusById(courseId);
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
}
