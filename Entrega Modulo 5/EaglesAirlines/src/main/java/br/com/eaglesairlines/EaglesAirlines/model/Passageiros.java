package br.com.eaglesairlines.EaglesAirlines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "passageiro")
public class Passageiros {
	
	//atributos
	
	@Id
	private String CPF;
	private String nome_passageiro;
	private String passaporte;
	private String email;
	private String telefone;
	
	
	
	public Passageiros(String cPF, String nome_passageiro, String passaporte, String email, String telefone) {
		super();
		CPF = cPF;
		this.nome_passageiro = nome_passageiro;
		this.passaporte = passaporte;
		this.email = email;
		this.telefone = telefone;
	}


	public Passageiros() {
		// TODO Auto-generated constructor stub
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getNome_passageiro() {
		return nome_passageiro;
	}


	public void setNome_passageiro(String nome_passageiro) {
		this.nome_passageiro = nome_passageiro;
	}


	public String getPassaporte() {
		return passaporte;
	}


	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	//tostring
	
	@Override
	public String toString() {
		return "Passageiros [nome_passageiro=" + nome_passageiro + ", CPF=" + CPF + ", passaporte=" + passaporte + ", email=" + email + ", telefone=" + telefone
				+ "]";
	}
	
	

}
