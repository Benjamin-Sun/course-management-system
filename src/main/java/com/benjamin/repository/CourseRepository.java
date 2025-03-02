package com.benjamin.repository;

import com.benjamin.dto.CourseTimeDto;
import com.benjamin.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.courseStatus = :courseStatus WHERE c.courseId = :courseId")
    int updateCourseStatusById(@Param("courseId") int courseId, @Param("courseStatus") int courseStatus);

    @Modifying
    @Transactional
    @Query(value = "UPDATE course c " +
            "SET c.course_fee = :fee " +
            "WHERE c.course_id IN (" +
            "    SELECT s.course_id " +
            "    FROM schedule s " +
            "    WHERE s.student_id = (" +
            "        SELECT st.student_id " +
            "        FROM student st " +
            "        WHERE st.student_name = :name" +
            "    )" +
            ")", nativeQuery = true)
    int updateCourseFeeByStudentName(@Param("name") String studentName, @Param("fee") int courseFee);

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.courseNote = :courseNote WHERE c.courseId = :courseId")
    int updateCourseNoteById(@Param("courseNote") String courseNote, @Param("courseId") int courseId);

    @Query("SELECT c FROM Course c JOIN Schedule s ON c.courseId = s.courseId WHERE s.scheduleTime = :scheduleTime")
    List<Course> getCourseByTime(@Param("scheduleTime") LocalDateTime scheduleTime);

    @Query(value = "SELECT c.*, sc.schedule_time from course c join schedule sc on c.course_id = sc.course_id", nativeQuery = true)
    List<CourseTimeDto> getAllCourseWithTime();

    @Query("UPDATE Schedule s SET s.scheduleTime = :newTime WHERE s.courseId = :courseId")
    int updateCourseTimeById(@Param("newTime") LocalDateTime newTime, @Param("courseId") int courseId);

//    @Query("SELECT SUM(c.courseFee) FROM Course c JOIN Schedule s ON c.courseId = s.courseId WHERE FUNCTION('DATE', s.scheduleTime) = :today")
    @Query(value = "SELECT sum(c.course_fee) FROM course c JOIN schedule s on c.course_id = s.course_id WHERE DATE(s.schedule_time) = :today", nativeQuery = true)
    int getTotalFeeForToday(@Param("today") LocalDate today);
}
