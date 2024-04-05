package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.entity.ProductEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Product;
import com.suchiit.repo.ProductRepo;
import com.suchiit.service.ProductService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
	private ProductRepo daoImpl;
	@Override
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		
		ProductEntity proEn=new ProductEntity();
		BeanUtils.copyProperties(p, proEn);
		proEn.setVisibility(true);
		ProductEntity proEnsave= daoImpl.save(proEn);
		Product pr=new Product();
		BeanUtils.copyProperties(proEnsave, pr);
		return pr;
	}

	/*
	 * @Override public List<Product> getAllProducts() { // TODO Auto-generated
	 * method stub List<ProductEntity> findAllProduct=daoImpl.findAll();
	 * List<Product> addProducts=new ArrayList<Product>();
	 * findAllProduct.forEach(p->
	 * 
	 * { Product pro=new Product(); BeanUtils.copyProperties(p, pro);
	 * addProducts.add(pro); } ); return addProducts; }
	 */

	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> findAllProduct=daoImpl.findAllProducts();
		List<Product> addProducts=new ArrayList<Product>();
		findAllProduct.forEach(p->
		
		{
			Product pro=new Product();
			BeanUtils.copyProperties(p, pro);
			addProducts.add(pro);
		}
				);
		return addProducts;
	}

	@Override
	public Product findProductById(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		ProductEntity productentity= daoImpl.findById(id).get();
		Product product=new Product();
		BeanUtils.copyProperties(productentity,product );
		return product;
	}

	@Override
	public Product updateProduct(Product p, long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		ProductEntity productentity= daoImpl.findById(id).get();
			if(productentity.getId()!=0)
		{
			BeanUtils.copyProperties(p, productentity);
		
		}
		else
		{
			throw new RecordNotFoundException("Given Record is Not Exists");
		}
		ProductEntity saveEntity=daoImpl.save(productentity);
		Product pro=new Product();
		BeanUtils.copyProperties(saveEntity,pro);
		return pro;
	}

	/*
	 * @Override public boolean deleteProuct(long id) throws RecordNotFoundException
	 * {
	 * 
	 * boolean flag=false; ProductEntity productentity= daoImpl.findById(id).get();
	 * if(productentity.getId()!=0) { daoImpl.deleteById(id); flag=true;
	 * 
	 * } else { throw new RecordNotFoundException("Given Record is Not Exists"); }
	 * 
	 * 
	 * return flag;
	 * 
	 * }
	 */
	
	
	  @Override public boolean deleteProduct(long id) throws RecordNotFoundException
	  {
	  
	  boolean flag=false; ProductEntity productentity= daoImpl.findById(id).get();
	  if(productentity.getId()!=0) {
		  System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjj"+id);
		  daoImpl.deleteProduct(id);
		  System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjj"+flag);
		  flag=true;
	  
	  } else { throw new RecordNotFoundException("Given Record is Not Exists"); }
	  
	  
	  return flag;
	  
	  }
	 
	

	
}
