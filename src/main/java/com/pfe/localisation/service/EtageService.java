package com.pfe.localisation.service;

import java.util.List;

import com.pfe.localisation.object.Etage;

public interface EtageService {
	
	     void persistEtage(Etage etage);
	     Etage findEtageById(int i);
	     List<Etage> findAll();
	     void updateEtage(Etage etage);
	     void deleteEtage(Etage etage);


}
