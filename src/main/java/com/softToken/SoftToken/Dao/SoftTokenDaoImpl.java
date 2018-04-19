
package com.softToken.SoftToken.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.softToken.SoftToken.dto.CategoriesDo;





@Repository
@EnableTransactionManagement
public class SoftTokenDaoImpl implements SoftTokenDao {
	
	private static final Logger LOG = LogManager.getLogger(SoftTokenDaoImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;	
	

	@Override
	public CategoriesDo getById(int id) {
		LOG.debug("Inside Dao Method --");
		
		CategoriesDo categoriesDo = new CategoriesDo();			
		categoriesDo=entityManager.find(CategoriesDo.class, id);
			
		
		
		return categoriesDo;
	}

}
