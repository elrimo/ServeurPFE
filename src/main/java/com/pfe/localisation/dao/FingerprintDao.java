package com.pfe.localisation.dao;

import java.util.List;

import com.pfe.localisation.json.WifiItem;
import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Indoorspace;

public interface FingerprintDao {
	void persistFingerprints(Fingerprints fgr);
	Fingerprints findFingerprintsById(int id);
	//Fingerprints findFingerprintComp(int val);
	List<Fingerprints> findAllFingerprints();
	List<Fingerprints> findFingerprintsEspace(Indoorspace space);
	void updateFingerprints(Fingerprints fgr);
	void deleteFingerprints(Fingerprints fgr);
	
}
