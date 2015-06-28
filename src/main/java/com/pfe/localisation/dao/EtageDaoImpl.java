package com.pfe.localisation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.object.Etage;

@Repository("etageDAO")
public class EtageDaoImpl implements EtageDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void persistEtage(Etage etage) {
		sessionFactory.getCurrentSession().persist(etage);
		
	}

	@Override
	public Etage findEtageById(int id) {		
		return (Etage) sessionFactory.getCurrentSession().get(Etage.class, id);
	}

	@Override
	public List<Etage> findAll() {		
		return  sessionFactory.getCurrentSession().createQuery("from Etage").list();
	}

	
	@Override
	public void updateEtage(Etage etage) {
		sessionFactory.getCurrentSession().update(etage);
		
	}

	@Override
	public void deleteEtage(Etage etage) {
		sessionFactory.getCurrentSession().delete(etage);
		
	}

	
	
}
