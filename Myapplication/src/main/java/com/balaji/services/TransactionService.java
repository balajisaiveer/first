package com.balaji.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.modal.Transaction;
import com.balaji.modal.User;
import com.balaji.repository.TransactionRepository;
import com.balaji.repository.UserRepository;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	UserRepository userRepository;
		
	private final TransactionRepository transactionRepository; 
	
	public TransactionService(TransactionRepository transactionRepository) 
	{
		this.transactionRepository=transactionRepository; 
	}
//---------------------------------------------------------------------------
	
//---------------------------------------------------------------------------
	//below is to save transaction but can be written directly in controller seperate service not needed.
	/*public void saveMyTransaction(Transaction transaction) {
		
	 	System.out.println(transaction.getRusername()+" "+transaction.getSendername()+" "+transaction.getAmount());
		if(userRepository.findByUsername(transaction.getRusername()).isEmpty())
		{
			
		}
		else {
			
	 	transactionRepository.save(transaction);
		}
	}*/
//---------------------------------------------------------------------------
	//Below is used to show all transactions 
	public List<Transaction> showAllTransactions(){
		List<Transaction> transactions = new ArrayList<Transaction>(); 
		for(Transaction transaction:transactionRepository.findAlls()) {
			
			transactions.add(transaction);
		}
			
		return transactions;
		}	
//---------------------------------------------------------------------------
	
	//Below is used to show transactions specific to prinicpal username(Logged in username)
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
//---------------------------------------------------------------------------

}






