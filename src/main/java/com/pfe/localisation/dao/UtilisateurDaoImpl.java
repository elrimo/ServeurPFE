package com.pfe.localisation.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pfe.localisation.object.Utilisateur;
@Repository("utilisateurDao")
public class UtilisateurDaoImpl implements UtilisateurDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void persistUtilisateur(Utilisateur user) {
		
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public Utilisateur findUtilisateurById(long id) {
		return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Utilisateur").list();
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		Query q=sessionFactory.getCurrentSession().createQuery("from com.pfe.localisation.object.Utilisateur u where u.email= :email").setString("email", email);
		Utilisateur u = (Utilisateur)q.uniqueResult();
		return u;
	}

	
	

}
