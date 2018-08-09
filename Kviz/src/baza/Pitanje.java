package baza;

import java.io.Serializable;

public class Pitanje implements Serializable {
	
	private static final long serialVersionUID = 6756762953346763169L;

	private int redniBroj;
	
	private String pitanje;
	private Odgovor odgovor1;
	private Odgovor odgovor2;
	private Odgovor odgovor3;
	private Odgovor odgovor4;
	
	
	public Odgovor getOdgovor1() {
		return odgovor1;
	}

	public void setOdgovor1(Odgovor odgovor1) {
		this.odgovor1 = odgovor1;
	}

	public Odgovor getOdgovor2() {
		return odgovor2;
	}

	public void setOdgovor2(Odgovor odgovor2) {
		this.odgovor2 = odgovor2;
	}

	public Odgovor getOdgovor3() {
		return odgovor3;
	}

	public void setOdgovor3(Odgovor odgovor3) {
		this.odgovor3 = odgovor3;
	}

	public Odgovor getOdgovor4() {
		return odgovor4;
	}

	public void setOdgovor4(Odgovor odgovor4) {
		this.odgovor4 = odgovor4;
	}

	public int getRedniBroj() {
		return redniBroj;
	}
	
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	
	
	public String getPitanje() {
		return pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	@Override
	public String toString() {
		return redniBroj + ". " + pitanje + "\n a) " + odgovor1 + "\n b) "
				+ odgovor2 + "\n c) " + odgovor3 + "\n d) " + odgovor4+"\n";
	}

	
	
	
}
