package com.pfe.localisation.service;

import java.util.List;

import com.pfe.localisation.object.Utilisateur;

public interface UtilisateurService {
	void persistUtilisateur(Utilisateur user);
	Utilisateur findUtilisateurById(long id);
	List<Utilisateur> findAll();
	void updateUtilisateur(Utilisateur user);
	void deleteUtilisateur(Utilisateur user);
	Utilisateur getUtilisateurByEmail(String email);
	


}
