package com.pfe.localisation.object;

// Generated 29 avr. 2014 13:48:35 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.vividsolutions.jts.geom.MultiPolygon;



/**
 * Etage generated by hbm2java
 */
public class Etage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2583783516937064070L;
	private int etageid;
	private Batiment batiment;
	private MultiPolygon geom;
	private Set<Indoorspace> indoorspaces = new HashSet<Indoorspace>(0);

	public Etage() {
	}

	public Etage(int etageid, MultiPolygon geom) {
		this.etageid = etageid;
		this.geom = geom;
	}

	public Etage(int etageid, Batiment batiment, MultiPolygon geom,
			Set<Indoorspace> indoorspaces) {
		this.etageid = etageid;
		this.batiment = batiment;
		this.geom = geom;
		this.indoorspaces = indoorspaces;
	}

	public int getEtageid() {
		return this.etageid;
	}

	public void setEtageid(int etageid) {
		this.etageid = etageid;
	}
	@JsonIgnore  
	public Batiment getBatiment() {
		return this.batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public MultiPolygon getGeom() {
		return this.geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}

	public Set<Indoorspace> getIndoorspaces() {
		return this.indoorspaces;
	}

	public void setIndoorspaces(Set<Indoorspace> indoorspaces) {
		this.indoorspaces = indoorspaces;
	}

}
