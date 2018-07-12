package com.balaji.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balaji.modal.Transaction;
import com.balaji.modal.User;
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
		
	 	//System.out.println(transaction.getRusername()+" "+transaction.getSendername()+" "+transaction.getAmount());
		transactionRepository.save(transaction);
	}

	public List<Transaction> showAllTransactions(){
		List<Transaction> transactions = new ArrayList<Transaction>(); 
		for(Transaction transaction:transactionRepository.findAlls()) {
			
			transactions.add(transaction);
		}
			
		return transactions;
		}	
		public List<Transaction> showAllidTransactions(Principal principal){
		String name = principal.getName();
		//System.out.println("principal:"+name);	
		List<Transaction> idtransactions = new ArrayList<Transaction>(); 
		for(Transaction idtransaction:transactionRepository.findAlls()) {
			if(idtransaction.getSendername().equalsIgnoreCase(name)) {
				idtransactions.add(idtransaction);
				//System.out.println(idtransaction.getSendername());
				}
		}
		return idtransactions;
		}
}






