package oblig;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="deltagere" ,schema = "oblig4")
public class Deltagere {
	

	@Id
	private String mobilNr; 
	private String fornavn; 
	private String etternavn; 
	private Passord passord; 
	private String kjonn;
	
	
	
	public Deltagere() {
		
	}


	public Deltagere(String fornavn, String etternavn, String mobilNr, Passord passord, String kjonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilNr = mobilNr;
		this.passord = passord;
		this.kjonn = kjonn;
	}


	public String getFornavn() {
		return fornavn;
	}


	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}


	public String getEtternavn() {
		return etternavn;
	}


	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}


	public String getMobilNr() {
		return mobilNr;
	}


	public void setMobilNr(String mobilNr) {
		this.mobilNr = mobilNr;
	}


	public Passord getPassord() {
		return passord;
	}


	public void setPassord(Passord passord) {
		this.passord = passord;
	}


	public String getKjonn() {
		return kjonn;
	}


	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}


	@Override
	public String toString() {
		return "Deltagere [mobilNr=" + mobilNr + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", passord="
				+ passord + ", kjonn=" + kjonn + "]";
	} 
	
	
	
	

}
