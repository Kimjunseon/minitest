package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;


// CRUD 함수를 JpaRepository가 들고있다
// @Repository라는 어노테이션이 필요없어도 IoC가 된다. 이유는 JpaRepository를 상속했기 때문이다.
public interface UserRepository extends JpaRepository<User, Integer>{
	

}
