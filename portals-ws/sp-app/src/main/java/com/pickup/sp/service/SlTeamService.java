package com.pickup.sp.service;
import java.util.List;

import com.pickup.sp.entity.SlTeam;
public interface SlTeamService {
		public List<SlTeam> findBySpId(Integer spId);
		public SlTeam findById(Integer id);
		public SlTeam create(SlTeam entity);
		public SlTeam update(SlTeam entity,Integer id);
		public String delete(Integer id);	
}
