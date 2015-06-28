package com.pfe.localisation.json;

import java.io.Serializable;



public class WifiItem  implements Serializable{
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 318123289315895901L;
	private String APName;
	   private String AdresseMac;
	 
	   private float ForceSignal;

	   public String getAPName() {
	       return APName;
	   }
	   public void setAPName(String aPName) {
	       APName = aPName;
	   }
	   public String getAdresseMac() {
	       return AdresseMac;
	   }
	   public void setAdresseMac(String adresseMac) {
	       AdresseMac = adresseMac;
	   }
	   public float getForceSignal() {
	       return ForceSignal;
	   }
	   public void setForceSignal(float forceSignal) {
	       ForceSignal = forceSignal;
	   }  
	   
	   

	}