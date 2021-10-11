package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.SysSubRequestAttachments;
import com.pickup.sysowner.repos.SysSubRequestAttachmentsRepos;
import com.pickup.sysowner.service.SysSubRequestAttachmentService;
@Service
public class SysSubRequestAttachmentServiceImpl implements SysSubRequestAttachmentService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private EntityManager em;
	private SysSubRequestAttachmentsRepos repos;
	
	@Autowired
	public SysSubRequestAttachmentServiceImpl(SysSubRequestAttachmentsRepos repos , EntityManager em) {
		this.em= em;
		this.repos = repos;
	}
	
	
	@Override
	public List<SysSubRequestAttachments> findAll() {
		// secured
		return this.repos.findAll();
	}

	@Override
	public SysSubRequestAttachments findById(Integer id) {
		Optional<SysSubRequestAttachments> result = this.repos.findById(id);
		SysSubRequestAttachments entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public List<SysSubRequestAttachments> findBySubRequestId(Integer subRrequestId) {
		Query query = this.em.createNamedQuery("findByRequestId");
		query.setParameter(1, subRrequestId);
		return query.getResultList();
	}

	@Override
	public SysSubRequestAttachments create(SysSubRequestAttachments entity) {
		// TODO Auto-generated method stub
		return this.repos.save(entity);
	}

	@Override
	public SysSubRequestAttachments update(SysSubRequestAttachments entity, Integer id) {
		entity.setId(0);
		return repos.save(entity);
	}


	@Override
	public void delet(Integer id) {
		SysSubRequestAttachments entity = findById(id);
		if(entity != null) {
			this.repos.deleteById(id);
		}
		
	}

	

}
