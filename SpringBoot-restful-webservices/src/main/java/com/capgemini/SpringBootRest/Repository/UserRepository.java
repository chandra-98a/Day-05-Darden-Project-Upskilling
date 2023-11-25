package com.capgemini.SpringBootRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.SpringBootRest.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

