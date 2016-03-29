package com.twitter.poruke;

/**
 * 
 * Ova klasa predstavlja twitter poruku, i ima metode set i get za atribute
 * poruka i korisnik.
 * 
 * @author Mirjana Stanojevic
 * @version 1.0
 *
 */
public class TwitterPoruka {

	/**
	 * Ime korisnika kao String.
	 */
	private String korisnik;

	/**
	 * Poruka korisnika kao String.
	 */
	private String poruka;

	/**
	 * Metoda vraca vrednost atributa 'korisnik', koji salje poruku.
	 * 
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja vrednost atributa 'korisnik' na vrednost koja je uneta
	 * kao ulazni parametar.
	 * 
	 * @param korisnik
	 *            ime korisnika
	 * @throws java.lang.RuntimeException
	 *             ako je vrednost ulaznog parametra null ili prazan String.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca vrednost atributa 'poruka', koja je poslata.
	 * 
	 * @return twitter poruka
	 */
	public String getPoruka() {
		return "poruka";
	}

	/**
	 * Metoda postavlja vrednost atributa 'poruka' na vrednost koja je uneta kao
	 * ulazni parametar.
	 * 
	 * @param poruka
	 *            tekst poruke
	 * @throws java.lang.RuntimeException
	 *             ako je vrednost unetog parametra null ili je duzina ulaznog
	 *             parametra veca od 140 karaktera.
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Redefinisana metoda toString koja vraca vrednost atributa u zadatom
	 * formatu.
	 * 
	 * @return ime korisnika i tekst njegove twitter poruke
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
