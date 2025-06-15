package com.gin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gin.model.Siskeudes;

public interface SiskeudesRepository extends JpaRepository<Siskeudes, String> {
	@Query(value = "SELECT * FROM siskeudes WHERE id= :id", nativeQuery = true)
	Siskeudes findByid(String id);

}
