package com.simplestocking.demo.repository;

import com.simplestocking.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<Users, String> {
}
