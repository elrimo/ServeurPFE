package com.pfe.localisation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Pointacces;
import com.pfe.localisation.object.Rssi;
import com.pfe.localisation.object.RssiId;
@Repository("rSSIDao")
public class RSSIDaoImpl implements RSSIDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void persistRSSI(Rssi rssi) {
		
		sessionFactory.getCurrentSession().persist(rssi);
	}

	@Override
	public void updateRSSI(Rssi rssi) {
	
		sessionFactory.getCurrentSession().update(rssi);
	}

	@Override
	public void deleteRSSI(Rssi rssi) {
		sessionFactory.getCurrentSession().delete(rssi);
		
	}

	

	@Override
	public Rssi getRssi(RssiId rssid) {
		
		return (Rssi) sessionFactory.getCurrentSession().get(Rssi.class, rssid);
	}

	@Override
	public Rssi getRssiAP(Fingerprints fgr, Pointacces ap) {
		
		return (Rssi) sessionFactory.getCurrentSession().createQuery("from Rssi u where u.fingerprints.idfingerprints= fgr.idfingerprints and u.pointacces=ap");
	}

	@Override
	public List<Rssi> getRssiFingerprints(Fingerprints fgr) {
		return sessionFactory.getCurrentSession().createQuery("from Rssi u where u.fingerprints.idfingerprints= fgr.idfingerprints ").list();
	}
	

}
