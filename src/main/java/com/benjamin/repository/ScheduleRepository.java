package com.benjamin.dao;

import com.benjamin.dto.ScheduleCourseDto;
import com.benjamin.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer> {

    @Query("SELECT new ScheduleCourseDto(" +
            "s.scheduleId, s.courseId, s.scheduleTime, c.courseNote) " +
            "FROM Schedule s " +
            "JOIN Course c ON s.courseId = c.courseId " +
            "JOIN Student st ON s.studentId = st.studentId " +
            "WHERE st.studentName = :name")
    List<ScheduleCourseDto> findScheduleCourseByStudentName(@Param("name") String studentName);
}
