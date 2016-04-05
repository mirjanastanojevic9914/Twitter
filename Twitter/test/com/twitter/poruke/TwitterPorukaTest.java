package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tPoruka;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		tPoruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tPoruka = null;
	}

	@Test
	public void testSetKorisnik() {
		String imeIPrezime = "Mirjana Stanojevic";
		tPoruka.setKorisnik(imeIPrezime);
		assertEquals(imeIPrezime, tPoruka.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tPoruka.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tPoruka.setKorisnik("");
	}

	@Test
	public void testSetPoruka() {
		String por = "Ovo je twitter poruka";
		tPoruka.setPoruka(por);
		assertEquals(por, tPoruka.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tPoruka.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaStringKojiJeDuziOd140Karaktera() {
		String s = "PozdravvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvvvPozdravvvvvvvvvvvvvvPozdravvvvvvvvvvvvvv";

		tPoruka.setPoruka(s);
	}

	@Test
	public void testToString() {
		tPoruka.setKorisnik("Pera");
		tPoruka.setPoruka("Perina poruka");
		assertEquals("KORISNIK:" + "Pera" + " PORUKA:" + "Perina poruka",
				tPoruka.toString());
	}

}
