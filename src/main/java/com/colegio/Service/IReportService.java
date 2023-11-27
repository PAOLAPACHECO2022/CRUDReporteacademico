package com.colegio.Service;

import java.util.List;

import com.colegio.Entity.Report;

public interface IReportService {

    List<Report> getAllReport();

    List<Report> getReportByName(String report_name);

    Report saveReport(Report report);

    Report getReportById(Long id);

    Report updateReport(Report report);

    void deleteReportById(Long id);
    
}

