package sistemskeoperacije;

import baza.Baza;
import baza.Pitanje;

public class SODodajPitanje {
	
	public static void izvrsi(Pitanje pitanje, Baza lista) {
		lista.setBrojPitanja(lista.getBrojPitanja()+1);
		lista.vratiListu().add(pitanje);
	}
}
