package com.capgemini.SpringBootRestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SpringBootRestAPI.bean.Student;

@RestController
public class StudentController {
	
	/*
	 * @GetMapping("/allstudents") public Student getStudent(){ int id; Student
	 * student= new Student(1, "chandra", "kala" ); return student; }
	 */

	// http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "umesh", "Fadatare"));
        students.add(new Student(3, "Ram", "Jadhav"));
        students.add(new Student(4, "Sanjay", "Pawar"));
        return students;
    }
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String fName,
                                       @PathVariable("last-name") String lName){
        return new Student(studentId, fName, lName);
    }
    
 // Spring boot REST API with Request @param
    //  http://localhost:8080/students/query?id=1&fName=Ramesh&lName=Fadatare
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String fName,
                                          @RequestParam String lName){
        return new Student(id, fName, lName);
    }
    //@RequestBody @PostMapping
    @PostMapping("/students/create")
    public  Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getfName());
        System.out.println(student.getlName());
return student;
    }
    
    //@PutMapping
    @PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
    	System.out.println(student.getfName());
    	System.out.println(student.getlName());
    	return student;
    }
    
  //@DeleteMapping
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
  
    	return "Student deleted successfully";
    }
}
