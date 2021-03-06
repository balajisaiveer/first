package com.balaji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.balaji.modal.Transaction;;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	//Below query gives all the transactions from the table
	@Query("select f from Transaction f")
	List<Transaction> findAlls();
}
