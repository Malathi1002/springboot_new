package com.kgisl.JdspBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.JdspBoot.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Integer> {
    
}
