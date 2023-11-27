package com.colegio.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.colegio.Entity.Student;
import com.colegio.Entity.Report;
import com.colegio.Repository.IStudentRepository;
import com.colegio.Service.ReportService;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private IStudentRepository studentRepository;

    private List<Student> studentsList = new ArrayList<>();
    
    public ReportController(ReportService reportService, IStudentRepository studentRepository) {
        this.reportService = reportService;
        this.studentRepository = studentRepository;

        this.studentsList= this.studentRepository.findAllSortByName();
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("reports", reportService.getAllReport());
        return "reports";
    }

    @GetMapping("/reports")
    public String listReports(Model model) {
        model.addAttribute("reports", reportService.getAllReport());
        return "reports";
    }
        
    @GetMapping("/reports/new")
    public String createReportForm(Model model) {

        Report report = new Report();

        model.addAttribute("report", report);
        model.addAttribute("studentsList", studentsList);

        return "create_report";
    }

    @PostMapping("/reports")
    public String saveReport(@ModelAttribute("report") Report report) {
        reportService.saveReport(report);
        return "redirect:/reports";
    }
  
    @GetMapping("/reports/edit/{id}")
    public String editReportForm(@PathVariable Long id, Model model) {
        Report pr = reportService.getReportById(id);

        model.addAttribute("studentsList", studentsList);
        if(pr.getId() !=0){model.addAttribute("report", pr);
        return "edit_report";
    } else {
        return "redirect:/reports";}   

    }

    @PostMapping("/reports/edit/{id}")
    public String updateReport(@PathVariable Long id,
            @ModelAttribute("report") Report report,
            Model model) {
        // sacar el estudiante de la b.d. por el id
        Report existentReport = reportService.getReportById(id);
        // cargarlo
        existentReport.setId(id);
        existentReport.setReport_name(report.getReport_name());
        existentReport.setDescription(report.getDescription());
        existentReport.setNote(report.getNote());

        existentReport.setStudents(report.getStudents());

        // guardar el estudiante actualizado
        reportService.updateReport(existentReport);

        return "redirect:/reports";
    }

    @GetMapping("/reports/{id}")
    public String deleteReport(@PathVariable Long id) {
        reportService.deleteReportById(id);
        return "redirect:/reports";
    }
}
