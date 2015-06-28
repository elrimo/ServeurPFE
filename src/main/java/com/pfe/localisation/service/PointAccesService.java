package com.pfe.localisation.service;

import java.util.List;

import com.pfe.localisation.object.Pointacces;

public interface PointAccesService {
	void ajoutAP(Pointacces pa);
	Pointacces findAPById(int id);
	List<Pointacces> findAllAP();
	void updateAP(Pointacces etage);
	void deleteAP(Pointacces etage);
	Pointacces findByAdresseMac(String adressemac);

}
