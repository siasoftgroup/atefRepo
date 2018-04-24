package com.rbi.nouveau.dao;

import java.util.List;

import com.rbi.nouveau.entity.Agent;




public interface AgentDao {
	void add(Agent ev);
	void delete(Agent ev);
	void update(Agent ev);
	List<Agent> getAllAgent ();
	Agent getByIdAgent(int id);
	Agent getByEmail(String email, String motDePasse);

}
