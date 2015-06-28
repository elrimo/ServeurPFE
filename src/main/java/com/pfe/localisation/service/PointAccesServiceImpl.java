package com.pfe.localisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.PointAccesDao;
import com.pfe.localisation.object.Etage;
import com.pfe.localisation.object.Pointacces;

@Service("pointAccesService")
public class PointAccesServiceImpl implements PointAccesService {
	
	@Autowired
	private PointAccesDao pointAccesDao;

	@Override
	@Transactional
	public void ajoutAP(Pointacces pa) {
		pointAccesDao.ajoutAP(pa);
		
	
	}

	@Override
	@Transactional
	public Pointacces findAPById(int id) {
		return pointAccesDao.findAPById(id);
	}

	@Override
	@Transactional
	public List<Pointacces> findAllAP() {
		return pointAccesDao.findAllAP();
	}

	@Override
	@Transactional
	public void updateAP(Pointacces etage) {
		pointAccesDao.updateAP(etage);
	}

	@Override
	@Transactional
	public void deleteAP(Pointacces etage) {
		pointAccesDao.deleteAP(etage);
		
	}

	@Override
	@Transactional
	public Pointacces findByAdresseMac(String adressemac) {
		
		return pointAccesDao.findByAdresseMac(adressemac);
	}
	
	

}
