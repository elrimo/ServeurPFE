package com.pfe.localisation.service;

import java.util.List;

import com.pfe.localisation.object.Etage;
import com.pfe.localisation.object.Indoorspace;

public interface IndoorspaceService {
	
    Indoorspace findSpaceById(int id);
    List<Indoorspace> findSpacesByEtage(Etage etg);
    Indoorspace findSpaceByName(String name);

}
