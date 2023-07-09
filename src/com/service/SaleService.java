package com.service;

import java.util.List;

import com.model.Sale;

public interface SaleService {
	boolean saleAdd(Sale s);
	List<Sale> displaySale();
}
