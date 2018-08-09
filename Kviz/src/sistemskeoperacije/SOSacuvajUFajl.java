package sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import baza.Baza;

public class SOSacuvajUFajl {
	
	public static void izvrsi(String putanja, Baza lista) {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)))) {
			out.writeObject(lista);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
