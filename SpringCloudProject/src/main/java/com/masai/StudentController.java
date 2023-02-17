package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	private StudentRepo sRepo;

	@Autowired
	public StudentController(StudentRepo sRepo) {
		this.sRepo = sRepo;
	}

	@PostMapping("/post1")
	public String postReq() {
		return "from post";
	}

	@PutMapping("/put1")
	public String putReq() {
		return "from put";
	}

	@GetMapping("/get1")
	public String getReq() {
		return "from get";
	}

	@DeleteMapping("/delete1")
	public String deleteReq() {
		return "from delete";
	}

	@GetMapping({ "/", "/home" })
	public String getHome() {
		return "Home screen  Get request";
	}

	@PostMapping("/post/data")
	public String postHome() {
		return "Post successfull";
	}

	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student) {
		Student saveStudent = sRepo.save(student);
		
		return new ResponseEntity<Student>(saveStudent, HttpStatus.OK);
	}

	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable Integer roll) {
		return new ResponseEntity<Student>(sRepo.findById(roll).get(), HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return sRepo.findAll();
	}
}
