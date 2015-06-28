package com.pfe.localisation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.json.WifiItem;
import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Indoorspace;

@Repository("fingerprintDao")
public class FingerprintDaoImpl implements FingerprintDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistFingerprints(Fingerprints fgr) {
		sessionFactory.getCurrentSession().persist(fgr);
		
	}

	@Override
	public Fingerprints findFingerprintsById(int id) {
		return (Fingerprints) sessionFactory.getCurrentSession().get(Fingerprints.class, id);
	}

	
	@Override
	public List<Fingerprints> findAllFingerprints() {
		return sessionFactory.getCurrentSession().createQuery("from Fingerprints").list();
		
	}

	@Override
	public List<Fingerprints> findFingerprintsEspace(Indoorspace space) {
		return sessionFactory.getCurrentSession().createQuery("from Fingerprints f where f.indoorspace.id=space ").list();
			}

	@Override
	public void updateFingerprints(Fingerprints fgr) {
		sessionFactory.getCurrentSession().update(fgr);
		
	}

	@Override
	public void deleteFingerprints(Fingerprints fgr) {
		sessionFactory.getCurrentSession().delete(fgr);
		
	}

	

}
