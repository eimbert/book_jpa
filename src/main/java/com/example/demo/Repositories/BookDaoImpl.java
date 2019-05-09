package com.example.demo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.services.entity.Book;

@Repository("clienteDaoJPA")
public class BookDaoImpl implements IBooksDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Book> findAll() {
		
		return em.createQuery("from Book").getResultList();
	}

	@Override
	@Transactional
	public void save(Book book) {
		em.persist(book);
		
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		em.remove(findOne(id));
	}

	@Override
	@Transactional(readOnly=true)
	public Book findOne(String id) {
		return em.find(Book.class, id);
	}

}
