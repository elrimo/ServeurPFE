package com.pfe.localisation.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.localisation.object.Utilisateur;

public class UtilisateurServiceTest {
	private static ClassPathXmlApplicationContext context;
	private static UtilisateurService utilisateurService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		utilisateurService=(UtilisateurService) context.getBean("utilisateurService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testPersistUtilisateur() {
		Utilisateur user= new Utilisateur();
		user.setNom("Saif");
		user.setPrenom("Saif");
		user.setEmail("Elaire");
		user.setPassword("saifoo");
		user.setRole("user");
		utilisateurService.persistUtilisateur(user);
		
		
	}

	@Test
	public void testFindUtilisateurById() {
		Utilisateur user=new Utilisateur();
		user=utilisateurService.findUtilisateurById(1);
		assertNotNull(user);
	}

	@Test
	public void testFindAll() {
		List<Utilisateur> lst=utilisateurService.findAll();
		assertNotNull(lst);
	}

	@Test
	public void testUpdateUtilisateur() {
		Utilisateur user = utilisateurService.findUtilisateurById(1);
		user.setPassword("ramouch");
		utilisateurService.updateUtilisateur(user);
	}

	@Test
	public void testDeleteUtilisateur() {
		utilisateurService.deleteUtilisateur(utilisateurService.findUtilisateurById(2));
	}

}
