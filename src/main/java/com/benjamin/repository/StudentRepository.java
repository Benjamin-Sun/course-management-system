package com.benjamin.repository;

import com.benjamin.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select s from Student s where s.studentName = :studentName")
    Student getStudentByName(@Param("studentName") String studentName);

    @Query(value = "select s.studentId from Student s where s.studentName = :studentName")
    int getIdByName(@Param("studentName") String studentName);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.studentStatus = 0 WHERE s.studentName = :name")
    int updateStudentStatusByName(@Param("name") String studentName);
}
