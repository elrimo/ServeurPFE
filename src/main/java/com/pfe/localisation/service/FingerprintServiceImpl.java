package com.pfe.localisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.FingerprintDao;
import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Indoorspace;
@Service("fingerprintService")
public class FingerprintServiceImpl implements FingerprintService{
	
	@Autowired
	private FingerprintDao fingerprintDao; 

	@Override
	@Transactional
	public void persistFingerprints(Fingerprints fgr) {
		fingerprintDao.persistFingerprints(fgr);
		
	}

	@Override
	@Transactional
	public Fingerprints findFingerprintsById(int id) {
		
		return fingerprintDao.findFingerprintsById(id);
	}

	@Override
	@Transactional
	public List<Fingerprints> findAllFingerprints() {
		
		return fingerprintDao.findAllFingerprints();
	}

	@Override
	@Transactional
	public List<Fingerprints> findFingerprintsEspace(Indoorspace space) {
		
		return fingerprintDao.findFingerprintsEspace(space);
	}

	@Override
	@Transactional
	public void updateFingerprints(Fingerprints fgr) {
		fingerprintDao.updateFingerprints(fgr);
		
	}

	@Override
	@Transactional
	public void deleteFingerprints(Fingerprints fgr) {
		fingerprintDao.deleteFingerprints(fgr);
		
	}

}
