package com.suchiit.service;

import java.util.List;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Product;

public interface ProductService {
public Product saveProduct(Product p);
public List<Product> getAllProducts();
public Product findProductById(long id) throws RecordNotFoundException;
public Product updateProduct(Product p,long id) throws RecordNotFoundException;
//public boolean deleteProuct(long id) throws RecordNotFoundException;
public boolean deleteProduct(long id) throws RecordNotFoundException;
}
