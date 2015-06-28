package com.pfe.localisation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.localisation.dao.UtilisateurDao;
import com.pfe.localisation.object.Utilisateur;
@Service("utilisateurService")
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurDao utilisateurDao;

	@Override
	@Transactional
	public void persistUtilisateur(Utilisateur user) {
			utilisateurDao.persistUtilisateur(user);
	}

	@Override
	@Transactional
	public Utilisateur findUtilisateurById(long id) {
		return utilisateurDao.findUtilisateurById(id);
		
	}

	@Override
	@Transactional
	public List<Utilisateur> findAll() {
		
		return utilisateurDao.findAll();
	}

	@Override
	@Transactional
	public void updateUtilisateur(Utilisateur user) {
		utilisateurDao.updateUtilisateur(user);
		
	}

	@Override
	@Transactional
	public void deleteUtilisateur(Utilisateur user) {
		utilisateurDao.deleteUtilisateur(user);
		
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateurByEmail(String email) {
		return utilisateurDao.getUtilisateurByEmail(email);
	}

	
}
