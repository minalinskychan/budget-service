package com.gin.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gin.model.SkdsBilling;

public interface SkdsBillingRepository extends JpaRepository<SkdsBilling, String> {
	Set<SkdsBilling> findByReceipt(String receipt);

}
