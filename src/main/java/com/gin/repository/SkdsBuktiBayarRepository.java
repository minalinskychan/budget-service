package com.gin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gin.model.SkdsBuktiBayar;

public interface SkdsBuktiBayarRepository extends JpaRepository<SkdsBuktiBayar, String> {
	List<SkdsBuktiBayar> findBySkds(String skds);

}
