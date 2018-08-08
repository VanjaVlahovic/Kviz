package sistemskeoperacije;

import java.util.LinkedList;

import baza.Baza;
import baza.Pitanje;

public class SOPrikazListe {
	public static String izvrsi(Baza lista) {
		LinkedList<Pitanje> pom = lista.vratiListu();
		int i = 0;
		String tekst = "";
		while (!pom.getLast().equals(pom.get(i))) {
			tekst = tekst + pom.get(0).toString() + "\n";
			i++;
		}
		return tekst + "\n" + pom.getLast().toString();
	}
}
