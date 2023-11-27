package com.colegio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.colegio.Entity.Report;

public interface IReportRepository extends JpaRepository<Report, Long> {

    @Query("FROM Report p WHERE p.report_name LIKE :name")
    public List<Report> findByNameContaining(@Param("name") String name);
    
}
