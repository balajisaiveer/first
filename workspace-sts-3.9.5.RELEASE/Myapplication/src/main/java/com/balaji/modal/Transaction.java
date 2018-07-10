package com.balaji.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
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
		
	

	
	
	
	
	

}