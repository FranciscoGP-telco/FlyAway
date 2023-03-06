package com.service;

import com.dao.PurchaseDao;
import com.entity.Purchase;

public class PurchaseService {
	PurchaseDao purchaseDao = new PurchaseDao();
	
	//Function to call the savePurchase query. Checks the results and return a String
	public String savePurchase(Purchase purchase) {
		if(purchaseDao.storePurchase(purchase)) {
			return "Book reservation saved correctly";
		} else {
			return "Problem saving the purchase";
		}
	}
	
	
}
