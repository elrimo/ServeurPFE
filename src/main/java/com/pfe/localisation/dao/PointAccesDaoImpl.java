package com.pfe.localisation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.object.Pointacces;

@Repository("pointAccesDao")
public class PointAccesDaoImpl implements PointAccesDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void ajoutAP(Pointacces pa) {
		sessionFactory.getCurrentSession().persist(pa);
		
	}

	@Override
	public Pointacces findAPById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pointacces> findAllAP() {
		return sessionFactory.getCurrentSession().createQuery("from Pointacces").list();
	}

	@Override
	public void updateAP(Pointacces pa) {
		sessionFactory.getCurrentSession().update(pa);
		
	}

	@Override
	public void deleteAP(Pointacces pa) {
		sessionFactory.getCurrentSession().delete(pa);
		
	}

	@Override
	public Pointacces findByAdresseMac(String adressemac) {
		
		Query q=sessionFactory.getCurrentSession().createQuery("from com.pfe.localisation.object.Pointacces u where u.adressemac= :adressemac").setString("adressemac", adressemac);
		Pointacces u = (Pointacces)q.uniqueResult();
		return u;
	}

}
