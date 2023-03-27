package com.example.omnipay.data.transaction;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "omni_transactions")
public class TransactionData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "omniID")
	private Integer omniID;
	
	@Expose
	@Column(name = "client_Id")
	private String clientId;
	
	@Expose
	@Column(name = "ref_no")
	private String refNo;
	
	@Expose
	@Column(name = "actual_Amount")
	private String actualAmount;
	
	@Expose
	@Column(name = "payout_Amount")
	private String payoutAmount;
	
	@Expose
	@Column(name = "currency")
	private String currency;
	
	@Expose
	@Column(name = "transaction_Date" , insertable = false, updatable = false)
	private Timestamp transactionDate;
	
	@Expose
	@Column(name = "transaction_ID")
	private String transactionID;
	
	@Expose
	@Column(name = "tax")
	private String tax;
	
	@Expose
	@Column(name = "service_tax")
	private String serviceTax;
	
	@Expose
	@Column(name = "transaction_status")
	private String transaction_status;	
	

	public Integer getOmniID() {
		return omniID;
	}

	public void setOmniID(Integer omniID) {
		this.omniID = omniID;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getPayoutAmount() {
		return payoutAmount;
	}

	public void setPayoutAmount(String payoutAmount) {
		this.payoutAmount = payoutAmount;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getServiceTax() {
		return serviceTax;
	}

	public void setService_tax(String serviceTax) {
		this.serviceTax = serviceTax;
	}

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}
}
