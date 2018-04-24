package com.rbi.nouveau.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rbi.nouveau.dao.AgentDetailDao;
import com.rbi.nouveau.entity.Agent;
import com.rbi.nouveau.entity.Agentdetail;



@Stateless
public class AgentdetailJpa implements AgentDetailDao{
	
	@PersistenceContext(name = "projectPU")
	private EntityManager entityManager;

	@Override
	public void add(Agentdetail ev) {
		entityManager.persist(ev);
		
	}

	@Override
	public void delete(Agentdetail ev) {
		entityManager
		.createQuery("DELETE FROM Agentdetail as u WHERE id=:id")
		.setParameter("id", ev.getId()).executeUpdate();
		
	}

	@Override
	public void update(Agentdetail ev) {
		entityManager.merge(ev);
		
	}

	@Override
	public List<Agentdetail> getAllAgentdetail() {
		List<Agentdetail> tousC = new ArrayList<Agentdetail>(); 
		tousC= entityManager.createQuery("SELECT m FROM Agentdetail m" ).getResultList();		
		return tousC;
	}

	@Override
	public Agentdetail getByIdAgentdetail(int id) {
		return  entityManager.find(Agentdetail.class, id);
	}

	
}
