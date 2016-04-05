package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter tw;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testVratiSvePoruke() {
		tw.unesi("Mirjana", "Dobro jutro");
		tw.unesi("Bodin", "Dobar dan");
		tw.unesi("Jovana", "Dobro vece");

		assertEquals("Mirjana", tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Dobro jutro", tw.vratiSvePoruke().get(0).getPoruka());
		assertEquals("Bodin", tw.vratiSvePoruke().get(1).getKorisnik());
		assertEquals("Dobar dan", tw.vratiSvePoruke().get(1).getPoruka());
		assertEquals("Jovana", tw.vratiSvePoruke().get(2).getKorisnik());
		assertEquals("Dobro vece", tw.vratiSvePoruke().get(2).getPoruka());

	}

	@Test
	public void testUnesi() {

		tw.unesi("Aleksandra", "Laku noc");

		assertEquals("Aleksandra", tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Laku noc", tw.vratiSvePoruke().get(0).getPoruka());

	}

	@Test
	public void testVratiPoruke() {

		tw.unesi("Milan", "Prva poruka");
		tw.unesi("Milka", "Druga poruka");
		tw.unesi("Nebojsa", "Treca poruka");
		tw.unesi("Milena", "Cetvrta porukica");
		tw.unesi("Bojana", "Peta poruka");
		tw.unesi("Bojan", "Sesta poruka");
		tw.unesi("Manojle", "Sedma poruka");
		tw.unesi("Jelena", "Osma porukica");

		TwitterPoruka[] por = new TwitterPoruka[6];

		for (int i = 0; i < por.length; i++) {
			por[i] = new TwitterPoruka();
		}
		por[0].setKorisnik("Milan");
		por[0].setPoruka("Prva poruka");
		por[1].setKorisnik("Milka");
		por[1].setPoruka("Druga poruka");
		por[2].setKorisnik("Nebojsa");
		por[2].setPoruka("Treca poruka");
		por[3].setKorisnik("Bojana");
		por[3].setPoruka("Peta poruka");
		por[4].setKorisnik("Bojan");
		por[4].setPoruka("Sesta poruka");
		por[5].setKorisnik("Manojle");
		por[5].setPoruka("Sedma poruka");

		assertArrayEquals(por, tw.vratiPoruke(6, "poruka"));

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		tw.vratiPoruke(10, null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		tw.vratiPoruke(10, "");
	}
}
