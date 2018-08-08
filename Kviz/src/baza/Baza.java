package baza;

import java.io.Serializable;
import java.util.LinkedList;

public class Baza implements Serializable{
	
	private static final long serialVersionUID = 345435L;
	
	private LinkedList<Pitanje> listaPitanja = new LinkedList<Pitanje>();
	
	public LinkedList<Pitanje> vratiListu(){
		return listaPitanja;
	}
		
}
