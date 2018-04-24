package com.rbi.nouveau.view;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.rbi.nouveau.dao.AgentDao;
import com.rbi.nouveau.dao.AgentDetailDao;
import com.rbi.nouveau.entity.Agent;
import com.rbi.nouveau.entity.Agentdetail;



@ManagedBean(name = "agents")
@ViewScoped
public class AgentView {
	@EJB
	private AgentDao agentdao;
	@EJB
	private AgentDetailDao agentDetailDao;
	
	private List<Agent> tousAgent ;
	private Agent selectedAgent = new Agent();
	private String prenom;
	private String nom;
	private String email;
	private String password;
	private Agentdetail agentdetail = new Agentdetail();
	
	private String adress;
	private String ville;
	private String tel;
	private String info;
	
	@PostConstruct
	void inti(){
		tousAgent = agentdao.getAllAgent();
		
		//System.out.print("TestTable");
	}

	public void AjoutAgent() throws IOException{
		Agent agent = new Agent();
		Agentdetail agentde = new Agentdetail();
		agent.setPrenom(prenom);
		agent.setNom(nom);
		agent.setEmail(email);
		agent.setPassword(password);
		agentde.setAdress(adress);
		agentde.setInfo(info);
		agentde.setTel(tel);
		agentde.setVille(ville);
		agent.setAgentdetail(agentde);
		agentdao.add(agent);
		
		

		
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("Agent ajouter avec succés");
		context.getExternalContext().redirect("login.xhtml");
		
	}
		public void deleteAgent( Agent agent) throws IOException{
			
				System.out.println("start deletsed");
				System.out.println(agent.getAgentdetail().getId());
				
				agentdao.delete(agent);
				agentDetailDao.delete(agent.getAgentdetail());
				
				System.out.println("deleteed");
				/*FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().redirect("datatableEvent.xhtml");*/
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().redirect("datatable.xhtml");
				
				
			}

		public void updateAgent() throws IOException{
			
			agentDetailDao.update(selectedAgent.getAgentdetail());
			agentdao.update(selectedAgent);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().redirect("datatable.xhtml");
			FacesMessage msg = new FacesMessage("utilisateur updated");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
			
		    
			
		}
		
	// Setter and Getter 
	
	
	public AgentDao getAgentdao() {
		return agentdao;
	}

	public void setAgentdao(AgentDao agentdao) {
		this.agentdao = agentdao;
	}

	public List<Agent> getTousAgent() {
		return tousAgent;
	}

	public void setTousAgent(List<Agent> tousAgent) {
		this.tousAgent = tousAgent;
	}

	public Agent getSelectedAgent() {
		return selectedAgent;
	}

	public void setSelectedAgent(Agent selectedAgent) {
		this.selectedAgent = selectedAgent;
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

	public AgentDetailDao getAgentDetailDao() {
		return agentDetailDao;
	}

	public void setAgentDetailDao(AgentDetailDao agentDetailDao) {
		this.agentDetailDao = agentDetailDao;
	}
	
	
	

}
