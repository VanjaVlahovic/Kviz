package baza;

import java.io.Serializable;

public class Pitanje implements Serializable {
	
	private static final long serialVersionUID = 6756762953346763169L;

	private int redniBroj;
	
	private String pitanje;
	private String odgovor1;
	private String odgovor2;
	private String odgovor3;
	private String odgovor4;
	
	
	public int getRedniBroj() {
		return redniBroj;
	}
	
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	
	public String getOdgovor1() {
		return odgovor1;
	}
	
	public void setOdgovor1(String odgovor1) {
		this.odgovor1 = odgovor1;
	}
	
	public String getOdgovor2() {
		return odgovor2;
	}
	
	public void setOdgovor2(String odgovor2) {
		this.odgovor2 = odgovor2;
	}
	
	public String getOdgovor3() {
		return odgovor3;
	}
	
	public void setOdgovor3(String odgovor3) {
		this.odgovor3 = odgovor3;
	}
	
	public String getOdgovor4() {
		return odgovor4;
	}
	
	public void setOdgovor4(String odgovor4) {
		this.odgovor4 = odgovor4;
	}

	public String getPitanje() {
		return pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	@Override
	public String toString() {
		return "Pitanje [redniBroj=" + redniBroj + ", pitanje=" + pitanje + ", odgovor1=" + odgovor1 + ", odgovor2="
				+ odgovor2 + ", odgovor3=" + odgovor3 + ", odgovor4=" + odgovor4 + "]";
	}
	
	
}
