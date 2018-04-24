package com.rbi.nouveau.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.rbi.nouveau.dao.AgentDao;
import com.rbi.nouveau.entity.Agent;


@Stateless
public class AgentJpa implements AgentDao {
	@PersistenceContext(name = "projectPU")
	private EntityManager entityManager;

	
	@Override
	public void add(Agent ev) {
		
			entityManager.persist(ev);
			
		
	}

	@Override
	public void delete(Agent ev) {
		entityManager
		.createQuery("DELETE FROM Agent as u WHERE id=:id")
		.setParameter("id", ev.getId()).executeUpdate();
		
	}

	@Override
	public void update(Agent ev) {
		entityManager.merge(ev);
		
	}

	@Override
	public List<Agent> getAllAgent() {
		List<Agent> tousC = new ArrayList<Agent>(); 
		tousC= entityManager.createQuery("SELECT m FROM Agent m" ).getResultList();		
		return tousC;
		
	}

	@Override
	public Agent getByIdAgent(int id) {
		return  entityManager.find(Agent.class, id);
	
	}
	@Override
	public Agent getByEmail(String email, String motDePasse) {
		Agent utilisateur = new Agent();
		try {
			utilisateur = (Agent) entityManager.createQuery("SELECT u FROM Agent as u WHERE email=:email and password=:motDePasse").setParameter("email", email).setParameter("motDePasse", motDePasse).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

		return utilisateur;
	}
	
	

	
}

