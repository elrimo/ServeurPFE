package com.pfe.localisation.object;

// Generated 29 avr. 2014 13:48:35 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Utilisateur generated by hbm2java
 */
public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4574200288787474874L;
	private long userid;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String role;
	private Date dateinscrit;
	private Set<HistoriqueLocalisation> historiqueLocalisations = new HashSet<HistoriqueLocalisation>(0);
	private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
	private Set<Evaluation> evaluations = new HashSet<Evaluation>(0);

	public Utilisateur() {
	}

	public Utilisateur(long userid) {
		this.userid = userid;
	}

	public Utilisateur(long userid, String nom, String prenom, String email,
			String password, String role,
			Set<HistoriqueLocalisation> historiqueLocalisations,
			Set<Commentaire> commentaires, Set<Evaluation> evaluations) {
		this.userid = userid;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.historiqueLocalisations = historiqueLocalisations;
		this.commentaires = commentaires;
		this.evaluations = evaluations;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateinscrit() {
		return dateinscrit;
	}

	public void setDateinscrit(Date dateinscrit) {
		this.dateinscrit = dateinscrit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<HistoriqueLocalisation> getHistoriqueLocalisations() {
		return this.historiqueLocalisations;
	}

	public void setHistoriqueLocalisations(
			Set<HistoriqueLocalisation> historiqueLocalisations) {
		this.historiqueLocalisations = historiqueLocalisations;
	}

	public Set<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Set<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
