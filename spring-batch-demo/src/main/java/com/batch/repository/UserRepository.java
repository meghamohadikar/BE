package com.batch.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.batch.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	void save(List<? extends User> users);
}