package com.balaji.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finaltransaction")
public class Transaction{
	
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="rusername")	
	private String rusername;
	@Column(name="sendername")
	private String sendername;
	@Column(name="amount")
	private int amount;
	
	
	public Transaction() {
		
	}
	
	/*public Transaction(String sendername,int amount) {
		super();
		this.sendername = sendername;
		this.amount = amount;
	}*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRusername() {
		return rusername;
	}

	public void setRusername(String rusername) {
		this.rusername = rusername;
	}
	
	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/*@Override
	public String toString() {
		return "Transaction [sendername=" + sendername + ", rusername=" + rusername + ", amount=" + amount + "]";
	}*/

	
}


//-------------------------------------------------------------------------------
//table components for intial Transaction(Intially tried idea)
/*public class Transaction {
	
	@Id
	private int tid;
	private int tamount;
	private int idrecv;
	private int tstaus;
	private int idsend;
	
	public Transaction() {
		
	}
	
	public Transaction(int tamount, int idrecv, int tstaus, int idsend) {
		super();
		this.tamount = tamount;
		this.idrecv = idrecv;
		this.tstaus = tstaus;
		this.idsend= idsend;
	}
	public int getTamount() {
		return tamount;
	}
	public void setTamount(int tamount) {
		this.tamount = tamount;
	}
	public int getIdrecv() {
		return idrecv;
	}
	public void setIdrecv(int idrecv) {
		this.idrecv = idrecv;
	}
	public int getTstaus() {
		return tstaus;
	}
	public void setTstaus(int tstaus) {
		this.tstaus = tstaus;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getIdsend() {
		return idsend;
	}
	public void setId(int idsend) {
		this.idsend = idsend;
	}
	@Override
	public String toString() {
		return "Transaction [tamount=" + tamount + ", idrecv=" + idrecv + ", tstaus=" + tstaus + ", tid=" + tid
				+ ", idsend=" + idsend + "]";
	}
}*/
//-------------------------------------------------------------------