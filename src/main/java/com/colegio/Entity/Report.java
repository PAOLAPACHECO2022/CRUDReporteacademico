package com.colegio.Entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="reports")
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="report_name", nullable = false )
    private String report_name;

    @Column(name="description")
    private String description;

    @Column(name = "note")
    private int note;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "reports_students", joinColumns = {
            @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false, updatable = false)
}, inverseJoinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, updatable = false)
})
private Set<Student> students = new HashSet<>();

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Report [description=" + description + ", note=" + note + ", report_name=" + report_name + "]";
    }

}



