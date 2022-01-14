package com.itbulls.learnit.javacore.dao.hw.template.enteties;

import java.io.Serializable;
import java.util.List;

public interface Order extends Serializable {

	boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);
	String getCreditCardNumber();

	void setProduct_id(int product_id);

	int getProduct_id();

	void setCustomerId(int customerId);
	
	int getCustomerId();

}
