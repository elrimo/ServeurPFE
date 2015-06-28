package com.pfe.localisation.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.localisation.object.Etage;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;


public class EtageServiceTest {
	
	private static ClassPathXmlApplicationContext context;
	private static EtageService etageService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		etageService= (EtageService) context.getBean("etageService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testPersistEtage() {
		Etage etage= new Etage();
		
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4329);
	    LinearRing shell = factory.createLinearRing(new Coordinate[] { new Coordinate(0, 0), new Coordinate(1, 0),
	            new Coordinate(1, 1), new Coordinate(0, 1), new Coordinate(0, 0), });
	    Polygon p = factory.createPolygon(shell, null);
	    MultiPolygon geom = factory.createMultiPolygon(new Polygon[] { p });
		etage.setEtageid(1);
		etage.setGeom(geom);
		etageService.persistEtage(etage);
	}

	@Test
	public void testFindAll() {
		List<Etage> lst=etageService.findAll();
		assertNotNull(lst);
	}

	@Test
	public void testFindEtageById() {
		Etage etage= etageService.findEtageById(3);
		assertNotNull(etage);
	}

	@Test
	public void testUpdateEtage() {
		Etage etage=etageService.findEtageById(2);
		assertNotNull(etage);
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4329);
	    LinearRing shell = factory.createLinearRing(new Coordinate[] { new Coordinate(0, 0), new Coordinate(2, 0),
	            new Coordinate(2, 1), new Coordinate(0, 1), new Coordinate(0, 0), });
	    Polygon p = factory.createPolygon(shell, null);
	    MultiPolygon geom = factory.createMultiPolygon(new Polygon[] { p });
	    assertNotNull(geom);
	    etage.setGeom(geom);
	    etageService.updateEtage(etage);
	
		
	}

	@Test
	public void testDeleteEtage() {
	//	etageService.deleteEtage(etageService.findEtageById(1));
	}

}
