package com.rbi.nouveau.dao;

import java.util.List;

import com.rbi.nouveau.entity.Agent;
import com.rbi.nouveau.entity.Agentdetail;

public interface AgentDetailDao {
	
		void add(Agentdetail ev);
		void delete(Agentdetail ev);
		void update(Agentdetail ev);
		List<Agentdetail> getAllAgentdetail ();
		Agentdetail getByIdAgentdetail(int id);
	

}
