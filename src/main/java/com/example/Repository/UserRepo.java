package com.example.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.UserModel;
@Repository
public interface UserRepo extends CrudRepository<UserModel, Integer> {
	public UserModel findByUsername(String username);
}
