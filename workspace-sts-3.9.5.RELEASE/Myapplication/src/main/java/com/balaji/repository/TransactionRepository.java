package com.balaji.repository;

import org.springframework.data.repository.CrudRepository;

import com.balaji.modal.Transaction;;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
