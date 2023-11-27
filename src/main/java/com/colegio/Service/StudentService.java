package com.colegio.Service;

import java.util.List;

import com.colegio.Entity.Student;
import com.colegio.Repository.IStudentRepository;

public class StudentService implements IStudentService{

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByName(String name) {

        return studentRepository.findByNameContaining(name);
    }

    @Override
    public List<Student> getStudentByCelular(Integer celular) {
        return studentRepository.findByCelular(celular);
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        
    }
    
}


