package com.pfe.localisation.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.localisation.object.Fingerprints;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public class FingerprintServiceTest {
	
	private static ClassPathXmlApplicationContext context;
	private static FingerprintService fingerprintService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		fingerprintService= (FingerprintService) context.getBean("fingerprintService"); 
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testPersistFingerprints() {
		/*Fingerprints fgr= new Fingerprints();
		fgr.setIndoorspace(space);
		
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4329);
	    Point p = factory.createPoint(new Coordinate(1, 1));
	    fgr.setPosition(p);
		
		fingerprintService.persistFingerprints(fgr);*/
	}

	@Test
	public void testFindFingerprintsById() {
		fingerprintService.findFingerprintsById(1);
	}

	@Test
	public void testFindAllFingerprints() {
		fingerprintService.findAllFingerprints();
	}

	@Test
	public void testFindFingerprintsEspace() {
		//fingerprintService.findFingerprintsEspace(space)
	}

	@Test
	public void testUpdateFingerprints() {
		
		Fingerprints fgr=fingerprintService.findFingerprintsById(1);
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4329);
	    Point p = factory.createPoint(new Coordinate(1, 1));
	    fgr.setPosition(p);
		fingerprintService.updateFingerprints(fgr);
		
	}

	@Test
	public void testDeleteFingerprints() {
		fingerprintService.deleteFingerprints(fingerprintService.findFingerprintsById(2));
	}




}
