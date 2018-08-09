package baza;

import java.io.Serializable;

public class Odgovor implements Serializable{
	
	private boolean tacno;
	private String tekst;
	
	public boolean isTacno() {
		return tacno;
	}

	public void setTacno(boolean tacno) {
		this.tacno = tacno;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return tekst + " ---> "+ tacno;
	}
	
	
}
