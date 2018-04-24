package com.rbi.nouveau.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agent")
public class Agent  implements Serializable{
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int  id;
    
	
	@Column(name="prenom")
    private String prenom;
	@Column(name="nom")
    private String nom;
	@Column(name="email")
    private String email;
	@Column(name="password")
    private String password;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Agentdetail agentdetail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Agentdetail getAgentdetail() {
		return agentdetail;
	}
	public void setAgentdetail(Agentdetail agentdetail) {
		this.agentdetail = agentdetail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
