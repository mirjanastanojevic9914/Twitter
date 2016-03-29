package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * Klasa Twitter sa implementiranim metodama vratiSvePoruke, unesi i vrtaiPoruke.
 * @author Mirjana Stanojevic
 * @version 2.0
 *
 */
public class Twitter {
   
	/**
	 * Lista twitter poruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
    
	/**
	 * Metoda vraca listu svih poruka.
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
    
	/**
	 * Metoda koja pravi novu poruku, puni je podacima i ubacuje na kraj liste.
	 * @param korisnik ime korisnika koji salje twitter poruku
	 * @param poruka twitter poruka koja se salje
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
    
	/**
	 * Metoda koja vraca niz poruka koje sadrze tag prosledjen kao ulazni parametar.
	 * @param maxBroj max broj poruka koje metoda moze vratiti
	 * @param tag tag koji se trazi u twitter porukama
	 * @return niz poruka koje sadrze tag.
	 * @throws java.lang.RuntimeException ako je prosledjeni tag
	 * <ul>
	 * <li>null</li> 
	 * <li>prazan string.</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
