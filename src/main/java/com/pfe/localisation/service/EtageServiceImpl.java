package com.pfe.localisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.EtageDao;
import com.pfe.localisation.object.Etage;

@Service("etageService")
public class EtageServiceImpl implements EtageService {

	@Autowired
	EtageDao etageDAO;

	@Override
	@Transactional
	public void persistEtage(Etage etage) {
		etageDAO.persistEtage(etage);
		
	}
	
	@Override
	@Transactional
	public List<Etage> findAll(){
		return etageDAO.findAll() ;
		
	}

	@Override
	@Transactional
	public Etage findEtageById(int id) {
		
		return etageDAO.findEtageById(id);
	}

	@Override
	@Transactional
	public void updateEtage(Etage etage) {
		etageDAO.updateEtage(etage);
	}

	@Override
	@Transactional
	public void deleteEtage(Etage etage) {
		etageDAO.deleteEtage(etage);
	}
	

}
