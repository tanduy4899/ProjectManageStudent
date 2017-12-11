package com.assia.controller;

import com.assia.domain.Student;
import com.assia.exception.NotFoundException;
import com.assia.model.student.StudentForm;
import com.assia.model.student.StudentModel;
import com.assia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
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
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public StudentModel getById(@PathVariable("id") BigInteger id){
        return this.studentService.getById(id).map(Student::toStudentModel).orElseThrow(NotFoundException::new);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") BigInteger id){
        this.studentService.delete(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentModel update(@PathVariable("id") BigInteger id,@Valid @RequestBody StudentForm studentForm){
        return this.studentService.update(id,studentForm).map(Student::toStudentModel).orElseThrow(NotFoundException::new);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentModel crete(@Valid @RequestBody StudentForm studentForm){
        return this.studentService.create(studentForm).toStudentModel();
    }

}
