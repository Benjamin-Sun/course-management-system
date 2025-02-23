package com.benjamin.service;

import com.benjamin.dto.ScheduleCourseDto;
import com.benjamin.dto.StudentCourseScheduleDto;
import com.benjamin.entity.Course;
import com.benjamin.entity.Schedule;
import com.benjamin.entity.Student;
import com.benjamin.repository.CourseRepository;
import com.benjamin.repository.ScheduleRepository;
import com.benjamin.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    public void addSchedule(String studentName, List<LocalDateTime> scheduleTimeList, List<Course> courseList) {

        int studentId = studentRepository.getIdByName(studentName);
        int count = 0;

        for (int courseId: courseService.addCourse(courseList)) {
            Schedule newSchedule = new Schedule();
            newSchedule.setStudentId(studentId);
            newSchedule.setCourseId(courseId);
            newSchedule.setScheduleTime(scheduleTimeList.get(count));
            scheduleRepository.save(newSchedule);

            count++;
        }

    }

    public List<ScheduleCourseDto> getScheduleCourseByStudentName(String studentName) {
        return scheduleRepository.getScheduleCourseByStudentName(studentName);
    }

    public List<StudentCourseScheduleDto> getAllStudentCourseScheduleDto(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        return scheduleRepository.getAllStudentCourseScheduleDto(year, month);
    }
}
