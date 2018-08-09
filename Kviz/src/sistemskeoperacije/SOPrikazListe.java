package sistemskeoperacije;

import java.util.LinkedList;

import baza.Baza;
import baza.Pitanje;

public class SOPrikazListe {
	public static String izvrsi(Baza lista) {
		Baza pom = lista;
		String tekst = "";
		for (int i=0; i<pom.getBrojPitanja(); i++)
			tekst = tekst + pom.vratiListu().get(i);
		return tekst;
	}
}
