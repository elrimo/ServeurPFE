package com.pfe.localisation.dao;

import java.util.List;

import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Pointacces;
import com.pfe.localisation.object.Rssi;
import com.pfe.localisation.object.RssiId;

public interface RSSIDao {
	void persistRSSI(Rssi rssi);
	void updateRSSI(Rssi rssi);
	void deleteRSSI(Rssi rssi);
	Rssi getRssi(RssiId rssid);
	Rssi getRssiAP(Fingerprints fgr, Pointacces ap );
	List<Rssi> getRssiFingerprints(Fingerprints fgr);
	

}
