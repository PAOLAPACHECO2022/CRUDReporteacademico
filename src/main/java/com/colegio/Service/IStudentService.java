package com.colegio.Service;

import java.util.List;

import com.colegio.Entity.Student;

public interface IStudentService {

    List<Student> getAllStudent();

    List<Student> getStudentByName(String name);

    List<Student> getStudentByCelular(Integer celular);

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    
    
}
