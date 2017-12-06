package com.assia.controller;

import com.assia.domain.Student;
import com.assia.model.student.StudentModel;
import com.assia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentModel> getAll(){
        return this.studentService.getAll();
    }
}
