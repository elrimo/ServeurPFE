package com.pfe.localisation.object;

// Generated 29 avr. 2014 13:48:35 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.vividsolutions.jts.geom.MultiPolygon;

/**
 * Indoorspace generated by hbm2java
 */
public class Indoorspace implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4460102002637859002L;
	private int espaceid;
	private Etage etage;
	private String type;
	private String nomspace;
	private MultiPolygon geom;
	private Set<Fingerprints> fingerprintses = new HashSet<Fingerprints>(0);
	private Set<NoeudNav> noeudNavs = new HashSet<NoeudNav>(0);
	private Set<Object> objects = new HashSet<Object>(0);

	public Indoorspace() {
	}

	public Indoorspace(int espaceid) {
		this.espaceid = espaceid;
	}

	public Indoorspace(int espaceid, Etage etage, String type, String nomspace,
			MultiPolygon geom, Set<Fingerprints> fingerprintses,
			Set<NoeudNav> noeudNavs, Set<Object> objects) {
		this.espaceid = espaceid;
		this.etage = etage;
		this.type = type;
		this.nomspace = nomspace;
		this.geom = geom;
		this.fingerprintses = fingerprintses;
		this.noeudNavs = noeudNavs;
		this.objects = objects;
	}

	public int getEspaceid() {
		return this.espaceid;
	}

	public void setEspaceid(int espaceid) {
		this.espaceid = espaceid;
	}
	@JsonIgnore
	public Etage getEtage() {
		return this.etage;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNomspace() {
		return this.nomspace;
	}

	public void setNomspace(String nomspace) {
		this.nomspace = nomspace;
	}

	public MultiPolygon getGeom() {
		return this.geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}

	public Set<Fingerprints> getFingerprintses() {
		return this.fingerprintses;
	}

	public void setFingerprintses(Set<Fingerprints> fingerprintses) {
		this.fingerprintses = fingerprintses;
	}

	public Set<NoeudNav> getNoeudNavs() {
		return this.noeudNavs;
	}

	public void setNoeudNavs(Set<NoeudNav> noeudNavs) {
		this.noeudNavs = noeudNavs;
	}

	public Set<Object> getObjects() {
		return this.objects;
	}

	public void setObjects(Set<Object> objects) {
		this.objects = objects;
	}

}
