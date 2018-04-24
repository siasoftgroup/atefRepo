package com.rbi.nouveau.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agentdetail")
public class Agentdetail implements Serializable{
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int  id;
    
	
	@Column(name="adress")
    private String adress;
	@Column(name="ville")
    private String ville;
	@Column(name="tel")
    private String tel;
	@Column(name="info")
    private String info;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id" , nullable=false)
	private Agent agent ;



	
	//Setter and Getter
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	/*public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}
*/
	
	

}
