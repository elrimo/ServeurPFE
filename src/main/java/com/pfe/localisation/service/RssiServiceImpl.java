package com.pfe.localisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.RSSIDao;
import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Pointacces;
import com.pfe.localisation.object.Rssi;
import com.pfe.localisation.object.RssiId;

@Service("rssiService")
public class RssiServiceImpl implements RssiService {
	
	@Autowired
	private RSSIDao rssiDao;

	
	@Override
	@Transactional
	public void persistRSSI(Rssi rssi) {
		rssiDao.persistRSSI(rssi);
		
	}

	@Override
	@Transactional
	public void updateRSSI(Rssi rssi) {
		rssiDao.updateRSSI(rssi);
	}

	@Override
	@Transactional
	public void deleteRSSI(Rssi rssi) {
		rssiDao.deleteRSSI(rssi);
	}

	@Override
	@Transactional
	public Rssi getRssi(RssiId rssid) {
		
		return rssiDao.getRssi(rssid);
	}

	@Override
	@Transactional
	public Rssi getRssiAP(Fingerprints fgr, Pointacces ap) {
		return rssiDao.getRssiAP(fgr, ap);
	}

	@Override
	@Transactional
	public List<Rssi> getRssiFingerprints(Fingerprints fgr) {
		return rssiDao.getRssiFingerprints(fgr);
	}
	

}
