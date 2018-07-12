package com.balaji.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balaji.modal.Transaction;
import com.balaji.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	
	private final TransactionRepository transactionRepository; 
	
	public TransactionService(TransactionRepository transactionRepository) 
	{
		this.transactionRepository=transactionRepository; 
	}
	
	public void saveMyTransaction(Transaction transaction) {
		
		transactionRepository.save(transaction);
	}





}






