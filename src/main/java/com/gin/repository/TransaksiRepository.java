package com.gin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gin.model.Siskeudes;
import com.gin.model.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
	@Query(value = "SELECT * FROM transaksi WHERE id= :id", nativeQuery = true)
	Siskeudes findByid(String id);

}
