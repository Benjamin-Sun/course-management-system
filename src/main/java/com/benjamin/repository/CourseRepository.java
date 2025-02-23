package com.benjamin.dao;

import com.benjamin.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.courseStatus = 1 WHERE c.courseId = :courseId")
    int updateCourseStatusById(@Param("courseId") int courseId);

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
}
