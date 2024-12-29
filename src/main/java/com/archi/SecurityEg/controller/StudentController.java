package com.archi.SecurityEg.controller;

import com.archi.SecurityEg.entity.Students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Students> students = new ArrayList<>(List.of(
            new Students(1,"archi",50),
            new Students(2,"rohan",40)
    ));

    @GetMapping("/students")
    public List<Students> getStudents(){
        return students;
     }

     @GetMapping("/csrf-token")
     public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
     }

     @PostMapping("/students")
     public Students postStudent(@RequestBody Students student){
        students.add(student);
        return student;
     }

}
