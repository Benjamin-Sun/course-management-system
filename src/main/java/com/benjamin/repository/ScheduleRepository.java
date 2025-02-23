package com.benjamin.repository;

import com.benjamin.dto.ScheduleCourseDto;
import com.benjamin.dto.StudentCourseScheduleDto;
import com.benjamin.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("SELECT new com.benjamin.dto.ScheduleCourseDto(" +
            "s.scheduleId, s.courseId, s.scheduleTime, c.courseNote) " +
            "FROM Schedule s " +
            "JOIN Course c ON s.courseId = c.courseId " +
            "JOIN Student st ON s.studentId = st.studentId " +
            "WHERE st.studentName = :name")
    List<ScheduleCourseDto> getScheduleCourseByStudentName(@Param("name") String studentName);

//    @Query(value = "SELECT st.student_name, c.course_id, c.course_note, sc.schedule_time " +
//            "from schedule sc " +
//            "join course c on sc.course_id = c.course_id " +
//            "join student st on sc.student_id = st.student_id " +
//            "where sc.schedule_time >= :monthBegin " +
//            "and sc.schedule_time <= :monthEnd", nativeQuery = true)
//    List<StudentCourseScheduleDto> getAllStudentCourseScheduleDto(@Param("monthBegin") String monthBegin, @Param("monthEnd") String monthEnd);

    @Query("SELECT new com.benjamin.dto.StudentCourseScheduleDto(" +
            "s.studentName, c.courseId, c.courseStatus, sch.scheduleTime) " +
            "FROM Schedule sch, Student s, Course c " +
            "WHERE sch.studentId = s.studentId " +
            "  AND sch.courseId = c.courseId " +
            "  AND YEAR(sch.scheduleTime) = :year " +
            "  AND MONTH(sch.scheduleTime) = :month")
    List<StudentCourseScheduleDto> getAllStudentCourseScheduleDto(
            @Param("year") int year,
            @Param("month") int month
    );

}
