package com.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.batch.service.StudentService;

@RestController
@RequestMapping("/csv")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping(value = "/upload" ,consumes = {"multipart/form-data"})
	public ResponseEntity<Integer> uploadStudent(@RequestPart("file") MultipartFile file){
	
		return ResponseEntity.ok(studentService.upload(file)); 
	}
	
	}
