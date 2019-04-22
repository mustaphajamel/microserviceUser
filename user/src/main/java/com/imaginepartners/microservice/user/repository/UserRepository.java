package com.imaginepartners.microservice.user.repository;

import com.imaginepartners.microservice.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
