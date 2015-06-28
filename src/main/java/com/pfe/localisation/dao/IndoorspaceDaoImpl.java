package com.pfe.localisation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.object.Etage;
import com.pfe.localisation.object.Indoorspace;

@Repository("indoorspaceDao")
public class IndoorspaceDaoImpl implements IndoorspaceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Indoorspace findSpaceById(int id) {
		return (Indoorspace) sessionFactory.getCurrentSession().get(Indoorspace.class, id);
	}

	@Override
	public List<Indoorspace> findSpacesByEtage(Etage etg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Indoorspace findSpaceByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
