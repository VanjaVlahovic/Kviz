package baza;

import java.io.Serializable;
import java.util.LinkedList;

public class Baza implements Serializable{
	
	private static final long serialVersionUID = 345435L;
	
	private LinkedList<Pitanje> listaPitanja = new LinkedList<Pitanje>();
	private int brojPitanja=0;
	
	
	public LinkedList<Pitanje> vratiListu(){
		return listaPitanja;
	}


	public int getBrojPitanja() {
		return brojPitanja;
	}


	public void setBrojPitanja(int brojPitanja) {
		this.brojPitanja = brojPitanja;
	}
		
}
