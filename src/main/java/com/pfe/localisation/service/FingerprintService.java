package com.pfe.localisation.service;

import java.util.List;

import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Indoorspace;

public interface FingerprintService {
	void persistFingerprints(Fingerprints fgr);
	Fingerprints findFingerprintsById(int id);
	//Fingerprints findFingerprintComp(int val);
	List<Fingerprints> findAllFingerprints();
	List<Fingerprints> findFingerprintsEspace(Indoorspace space);
	void updateFingerprints(Fingerprints fgr);
	void deleteFingerprints(Fingerprints fgr);

}
