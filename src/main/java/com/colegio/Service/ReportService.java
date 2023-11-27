package com.colegio.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colegio.Entity.Report;
import com.colegio.Repository.IReportRepository;

@Service
public class ReportService  implements IReportService{

    private IReportRepository reportRepository;

    public ReportService(IReportRepository reportRepository){
        this.reportRepository=reportRepository;
    }

    @Override
    public List<Report> getAllReport() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getReportByName(String report_name) {
        return reportRepository.findByNameContaining(report_name);
    }

    @Override
    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).get();
    }

    @Override
    public Report updateReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteReportById(Long id) {
        reportRepository.deleteById(id);
        
    }
    public void save(String report) {
    }
    
}

