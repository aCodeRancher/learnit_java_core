package com.itbulls.learnit.javacore.dao.hw.template.enteties.impl;

import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;



public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private int product_id;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && 
				!creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardNumber(){
		return this.creditCardNumber;
	}

	@Override
	public void setProduct_id ( int product_id ) {
		this.product_id = product_id;
	}

	@Override
	public int getProduct_id(){
		return this.product_id;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
					"credit card number - " + this.creditCardNumber + "\t" + 
					"product - " + this.product_id;
	}


}
