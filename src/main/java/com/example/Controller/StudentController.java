package com.example.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.StudentModel;
import com.example.Repository.StudentRepo;

@Controller
public class StudentController {
	
 @Autowired
 private StudentRepo studentRepo;
 
	
	@GetMapping("/list")
	public ModelAndView list() {
		Map <String,Object> map = new HashMap<String,Object>();
		List<StudentModel> stuList =(List<StudentModel>) studentRepo.findAll();
		map.put("stuList", stuList);
		
		return new ModelAndView("studentList","data", map);
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		Map <String,Object> map = new HashMap<String,Object>();
		
		
		return new ModelAndView("createStudent","data", map);
	
}
	
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute StudentModel studentModel, HttpServletRequest req) {
		Map <String,Object> map = new HashMap<String,Object>();
		try {
			studentModel = studentRepo.save(studentModel);
			map.put("student", studentModel);
			map.put("status","Success");
			map.put("message", "Add a student successfull");
		}catch(Exception e) {
			map.put("status","Failed");
			map.put("message", "Student add failed");
		}
		
		return new ModelAndView("createStudent","data", map);
	
}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable (value = "id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		StudentModel student =  studentRepo.findById(id).get();
		map.put("student", student);
		return new ModelAndView("editStudent", "data", map);
	}
		
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute StudentModel studentModel, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			studentModel = studentRepo.save(studentModel);
			map.put("student", studentModel);
			map.put("status", "Success");
			map.put("message", "Data updated successfully");
		} catch (Exception e) {
			map.put("status", "Failed");
			map.put("message", "Data updated failed");
		}
		return new ModelAndView("editStudent", "data", map);
	
}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable (value = "id") int id) {
		Map <String,Object> map = new HashMap<String,Object>();
		try {
			StudentModel student = studentRepo.findById(id).get();
			studentRepo.delete(student);
			map.put("student", student);
		}catch(Exception e) {
			
		}
		
		return new ModelAndView("studentList","data",map);
	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam(value = "searchText", required = false) String searchText) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(searchText == null || searchText.equals("")) {
			map.put("studentList", new ArrayList<>());
			
			return new ModelAndView("studentList", "data", map);
			
		}
		List<StudentModel> studentModel = studentRepo.serachStudent(searchText);
		map.put("studentModel", studentModel);
		return new ModelAndView("studentList", "data", map);
	}
	
}
