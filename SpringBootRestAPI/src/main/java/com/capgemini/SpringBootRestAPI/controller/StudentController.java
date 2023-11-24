package com.capgemini.SpringBootRestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SpringBootRestAPI.bean.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	 @GetMapping("/allstudents") 
	 public ResponseEntity<Student> getStudent()
	 { 
		 @SuppressWarnings("unused")
		int id; 
		 Student student= new Student
				 (
						 1,
						 "chandra", 
						 "kala"
			 );
	 //return new ResponseEntity<>(student, HttpStatus.OK);
		 return ResponseEntity.ok().
				 header("custom-header", "ramesh").body(student);
	 }
	 
	// http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "umesh", "Fadatare"));
        students.add(new Student(3, "Ram", "Jadhav"));
        students.add(new Student(4, "Sanjay", "Pawar"));
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String fName,
                                       @PathVariable("last-name") String lName){
        Student student= new Student(studentId, fName, lName);
        return ResponseEntity.ok(student);
    }
    
 // Spring boot REST API with Request @param
    //  http://localhost:8080/students/query?id=1&fName=Ramesh&lName=Fadatare
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String fName,
                                          @RequestParam String lName){
        Student student=new Student(id, fName, lName);
        return ResponseEntity.ok(student);
    }
    //@RequestBody @PostMapping
    @PostMapping("/create")
    public  ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getfName());
        System.out.println(student.getlName());
return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    
    //@PutMapping
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
    	System.out.println(student.getfName());
    	System.out.println(student.getlName());
    	return ResponseEntity.ok(student);
    }
    
  //@DeleteMapping
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
  
    	return ResponseEntity.ok("Student deleted successfully");
    }
}
