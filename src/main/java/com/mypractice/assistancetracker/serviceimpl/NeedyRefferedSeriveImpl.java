/**
 * nasru
 * NeedyRefferedSeriveImpl.java
 * Apr 17, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.NeedyRefferedDao;
import com.mypractice.assistancetracker.dao.RelationshipDao;
import com.mypractice.assistancetracker.dto.CommonDropDown;
import com.mypractice.assistancetracker.dto.NeedyRefferedDto;
import com.mypractice.assistancetracker.dto.RelationshipDto;
import com.mypractice.assistancetracker.model.NeedyReffered;
import com.mypractice.assistancetracker.model.Relationship;
import com.mypractice.assistancetracker.service.NeedyRefferedSerive;
import com.mypractice.assistancetracker.service.RelationshipService;

/**
 * @author nasru
 *
 */
@Service("needyRefferedSerive")
@Transactional
public class NeedyRefferedSeriveImpl implements NeedyRefferedSerive {
	@Autowired
	private RelationshipService relationShipService;
	@Autowired
	private RelationshipDao relationshipDao;
	@Autowired
	private NeedyRefferedDao needyReffereDAO;
	@Override
	public List<NeedyRefferedDto> findAllRefferer() {
		// TODO Auto-generated method stub
		return needyReffereDAO.findAllRefferer().stream().map((Function<? super NeedyReffered, ? extends NeedyRefferedDto>)obj->{
			NeedyRefferedDto dto = new NeedyRefferedDto();
			dto.setReffererId(obj.getReffererId());
			dto.setCreateDateTime(obj.getCreateDateTime());
			dto.setUpdateDateTime(obj.getUpdateDateTime());
			dto.setRefrerMobileNumber(obj.getRefrerMobileNumber());
			dto.setReffereName(obj.getReffereName());
			Relationship relationship =  obj.getRelationship();
			dto.setRelationShipWithNeedy(relationship.getRelationshipId());
			dto.setRelationShipName(relationship.getRelationshipName());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<CommonDropDown> findAllRelationShip() {
		// TODO Auto-generated method stub
		List<CommonDropDown> dropDowns = null;
		dropDowns = relationShipService.findAll().stream().map((Function<? super RelationshipDto, ? extends CommonDropDown>)obj->{
			return new CommonDropDown(obj.getRelationshipId(), obj.getRelationshipName());
		}).collect(Collectors.toList());

		return dropDowns;
	}

	@Override
	public void saveNeedyRefferer(NeedyRefferedDto refferDto) {
		// TODO Auto-generated method stub
		NeedyReffered needyReffered = new NeedyReffered();
		needyReffered.setRefrerMobileNumber(refferDto.getRefrerMobileNumber());
		needyReffered.setReffererId(refferDto.getReffererId());
		needyReffered.setCreateDateTime(refferDto.getCreateDateTime());
		needyReffered.setUpdateDateTime(refferDto.getUpdateDateTime());
		needyReffered.setReffereName(refferDto.getReffereName());
		needyReffered.setRelationship(relationshipDao.editRelationship(refferDto.getRelationShipWithNeedy()));
		needyReffereDAO.saveNeedyRefferer(needyReffered);
	}

	@Override
	public NeedyRefferedDto editNeedyRefferer(Integer needyReferId) {
		// TODO Auto-generated method stub
		NeedyReffered needyReffered = needyReffereDAO.editNeedyRefferer(needyReferId);
		NeedyRefferedDto dto = new NeedyRefferedDto();
		dto.setReffererId(needyReffered.getReffererId());
		dto.setCreateDateTime(needyReffered.getCreateDateTime());
		dto.setUpdateDateTime(needyReffered.getUpdateDateTime());
		dto.setRefrerMobileNumber(needyReffered.getRefrerMobileNumber());
		dto.setReffereName(needyReffered.getReffereName());
		Relationship relationship =  needyReffered.getRelationship();
		dto.setRelationShipWithNeedy(relationship.getRelationshipId());
		dto.setRelationShipName(relationship.getRelationshipName());
		return dto;
	}

	@Override
	public void deleteNeedyRefferer(Integer needyReferId) {
		// TODO Auto-generated method stub
		needyReffereDAO.deleteNeedyRefferer(needyReffereDAO.editNeedyRefferer(needyReferId));
	}

}
