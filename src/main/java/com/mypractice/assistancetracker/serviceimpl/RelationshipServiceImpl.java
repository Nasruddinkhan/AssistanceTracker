/**
 * nasru
 * RelationshipServiceImpl.java
 * Apr 12, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.RelationshipDao;
import com.mypractice.assistancetracker.dto.RelationshipDto;
import com.mypractice.assistancetracker.model.Relationship;
import com.mypractice.assistancetracker.service.RelationshipService;

/**
 * @author nasru
 *
 */
@Transactional
@Service("relationshipService")
public class RelationshipServiceImpl implements RelationshipService {
@Autowired
private RelationshipDao relationshipDao;
	@Override
	public void saveRelationship(RelationshipDto relationshipDto) throws Exception {
		// TODO Auto-generated method stub
		Relationship  relationship = new  Relationship();
		BeanUtils.copyProperties(relationship, relationshipDto);
		System.out.println(relationship.getRelationshipId()+" "+relationship.getRelationshipName());
		relationshipDao.saveRelationship(relationship);
	}
	@Override
	public List<RelationshipDto> findAll(){
		// TODO Auto-generated method stub
		List<RelationshipDto> dtos =null;
		List<Relationship> relationship =	relationshipDao.findAll();	
		dtos = relationship.stream().map((Function<? super Relationship,  ? extends RelationshipDto>)obj->{
			RelationshipDto dto = new RelationshipDto();
			dto.setRelationshipId(obj.getRelationshipId());
			dto.setRelationshipName(obj.getRelationshipName());
			dto.setCreateDateTime(obj.getCreateDateTime());
			dto.setUpdateDateTime(obj.getUpdateDateTime());
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}
	@Override
	public RelationshipDto editRelationship(String relationshipId) throws Exception {
		// TODO Auto-generated method stub
		RelationshipDto relationshipDto = new RelationshipDto();
		Relationship relationship = relationshipDao.editRelationship(relationshipId);
		BeanUtils.copyProperties( relationshipDto, relationship);
		return relationshipDto;
	}
	@Override
	public void deleteRelationship(String relationshipId) {
		// TODO Auto-generated method stub
		relationshipDao.deleteRelationship(relationshipDao.editRelationship(relationshipId));
	}
	
}
