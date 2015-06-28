package com.pfe.localisation.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RssiServiceTest {

	private static ClassPathXmlApplicationContext context;
	private static RssiService rssiService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		rssiService=(RssiService) context.getBean("rssiService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testPersistRSSI() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRSSI() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRSSI() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRssi() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRssiAP() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRssiFingerprints() {
		fail("Not yet implemented");
	}

}
