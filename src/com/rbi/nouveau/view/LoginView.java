package com.rbi.nouveau.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.rbi.nouveau.dao.AgentDao;
import com.rbi.nouveau.entity.Agent;




@ManagedBean(name = "userLoginView")
@SessionScoped
public class LoginView {
	
	private Agent agent  = new Agent();
	private Agent utilisateurLog ;
	boolean loggedIn;
	
	
    @EJB
	private AgentDao utilisateurDao;
	
	
	public String login() throws IOException {
		System.out.println("start");
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;		
		HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);	
		
		utilisateurLog = utilisateurDao.getByEmail(agent.getEmail().trim(),agent.getPassword().trim());
		
		if ((utilisateurLog != null)) {	
			
			session.setAttribute("idUtilisateur", utilisateurLog.getId() + "");
			session.setAttribute("nom", utilisateurLog.getNom());                       
			session.setAttribute("prenom", utilisateurLog.getPrenom());
			session.setAttribute("mail", utilisateurLog.getEmail() );
			
			System.out.println("user connected");
			
			return "datatable.xhtml?faces-redirect=true";	
		}else {
			System.out.println("ERROR");
			FacesMessage messages = new FacesMessage(FacesMessage.SEVERITY_WARN, "error","error");
			FacesContext.getCurrentInstance().addMessage(null, messages);
			loggedIn = false;
		}
		
		
		return null;
	}

	public String logout() throws IOException {
		System.out.println("by by !!");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();	
		System.out.println("folder closed");
		System.out.println("Store closed");
		return "/login.xhtml?faces-redirect=true";	
	}

	

	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Agent getUtilisateurLog() {
		return utilisateurLog;
	}

	public void setUtilisateurLog(Agent utilisateurLog) {
		this.utilisateurLog = utilisateurLog;
	}

	public AgentDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(AgentDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}


	
	
	
	
}
