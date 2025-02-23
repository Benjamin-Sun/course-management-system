package com.benjamin.dao;

import com.benjamin.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    @Query(value = "select s from Student s where s.studentName = :studentName")
    Student getStudentByName(@Param("studentName") String username);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.studentStatus = 0 WHERE s.studentName = :name")
    int updateStudentStatusByName(@Param("name") String studentName);
}
