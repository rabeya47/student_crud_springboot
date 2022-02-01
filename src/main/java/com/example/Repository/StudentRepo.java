package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.StudentModel;
@Repository
public interface StudentRepo extends CrudRepository<StudentModel, Integer> {

	
	@Query("SELECT s from StudentModel s where s.name like %:searchText% or s.id like %:searchText%")
	public List<StudentModel> serachStudent (String searchText);
}
