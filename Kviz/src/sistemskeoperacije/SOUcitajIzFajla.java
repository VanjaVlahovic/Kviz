package sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import baza.Baza;


public class SOUcitajIzFajla {
	public static Baza izvrsi(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			return (Baza) (in.readObject());
		} catch (Exception e) {
			return new Baza();
			}
	}
}
