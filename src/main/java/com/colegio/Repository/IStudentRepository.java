package com.colegio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.colegio.Entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    
    @Query("FROM Student r WHERE r.name LIKE :title")
    public List<Student> findByNameContaining(@Param("title") String title);

    @Query("FROM Student r WHERE r.celular LIKE :celular")
    public List<Student> findByCelular(@Param("celular") Integer celular);

    @Query("FROM Student r ORDER BY name ASC")
    public List<Student> findAllSortByName();
    
}


