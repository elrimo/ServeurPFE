package com.pfe.localisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.IndoorspaceDao;
import com.pfe.localisation.object.Etage;
import com.pfe.localisation.object.Indoorspace;

@Service("indoorspaceService")
public class IndoorspaceServiceImpl implements IndoorspaceService {

	@Autowired
	IndoorspaceDao indoorspaceDao;

	@Override
	@Transactional
	public Indoorspace findSpaceById(int id) {
		return indoorspaceDao.findSpaceById(id);
	}

	@Override
	@Transactional
	public List<Indoorspace> findSpacesByEtage(Etage etg) {
		return indoorspaceDao.findSpacesByEtage(etg);
	}

	@Override
	@Transactional
	public Indoorspace findSpaceByName(String name) {
		return indoorspaceDao.findSpaceByName(name);
	}
	
	
}
