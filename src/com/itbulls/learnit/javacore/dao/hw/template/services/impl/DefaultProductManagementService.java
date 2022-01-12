package com.itbulls.learnit.javacore.dao.hw.template.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcProductDao;
import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcUserDao;
import com.itbulls.learnit.javacore.dao.hw.template.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.ProductConverter;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.UserConverter;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultProduct;
import com.itbulls.learnit.javacore.dao.hw.template.services.ProductManagementService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.ProductStoringService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.impl.DefaultProductStoringService;


public class DefaultProductManagementService implements ProductManagementService {
	
	private static DefaultProductManagementService instance;
	
	private static List<Product> products;
	
	private static ProductStoringService productStoringService;
	private static ProductConverter productConverter;
	private static MySqlJdbcProductDao mySqlJdbcProductDao;


	static {
		productStoringService = new DefaultProductStoringService();
		mySqlJdbcProductDao = MySqlJdbcProductDao.getInstance();
		productConverter = ProductConverter.getInstance();
		loadProductsFromStorage();
	}

	public static void loadProductsFromStorage() {
		products = productStoringService.loadProducts();
	}
	

	private DefaultProductManagementService() {
		
	}

	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

	@Override
	public List<Product> getProducts() {
       List<ProductDto> productDtos = mySqlJdbcProductDao.getProducts();
       List<Product> products = productDtos.stream()
			   .map(productDto -> productConverter.productDtoToProduct(productDto)).collect(Collectors.toList());

       return products;
	}

	@Override
	public Product getProductById(int id) {
		ProductDto productDto = mySqlJdbcProductDao.getProductById(id);
		return productConverter.productDtoToProduct(productDto);

	}

}
