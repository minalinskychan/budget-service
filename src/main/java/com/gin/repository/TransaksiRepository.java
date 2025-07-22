package com.gin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gin.model.Siskeudes;
import com.gin.model.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
	@Query(value = "SELECT * FROM transaksi WHERE id= :id", nativeQuery = true)
	Siskeudes findByid(String id);

	@Query(value = "SELECT SUM(t.spend_amount) FROM transaksi t ", nativeQuery = true)
	String getTotal();
	@Query(value = "SELECT SUM(t.spend_amount) FROM transaksi t where month(t.spend_date)=:month and year(t.spend_date)=:year", nativeQuery = true)
	String getTotalSpecificMonth(String month, String year);
	@Query(value = "SELECT SUM(t.spend_amount) FROM transaksi t where t.spend_date >=:start and t.spend_date <:end", nativeQuery = true)
	String getTotalSpecificDate(String start, String end);
	

}
