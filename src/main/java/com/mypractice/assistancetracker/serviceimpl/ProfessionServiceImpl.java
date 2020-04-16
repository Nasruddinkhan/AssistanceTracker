/**
 * nasru
 * ProfessionServiceImpl.java
 * Apr 16, 2020
 */
package com.mypractice.assistancetracker.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.assistancetracker.dao.ProfessionDao;
import com.mypractice.assistancetracker.dto.ProfessionDTO;
import com.mypractice.assistancetracker.model.Profession;
import com.mypractice.assistancetracker.service.ProfessionService;

/**
 * @author nasru
 *
 */
@Service("professionService")
@Transactional
public class ProfessionServiceImpl implements ProfessionService {
	@Autowired
	private ProfessionDao professionDao;

	@Override
	public void saveProfession(ProfessionDTO professionDTO) {
		// TODO Auto-generated method stub
		System.out.println(professionDTO.getProfessionId());
		Profession profession = new Profession();
		profession.setProfessionId(professionDTO.getProfessionId());
		profession.setProfessionName(professionDTO.getProfessionName());
		profession.setCreateDateTime(professionDTO.getCreateDateTime());
		profession.setUpdateDateTime(professionDTO.getUpdateDateTime());
		professionDao.saveProfession(profession);
	}

	@Override
	public List<ProfessionDTO> getProfession() {
		// TODO Auto-generated method stub
		List<ProfessionDTO> dtos = null;
		List<Profession> professions = professionDao.getProfession();
		dtos = professions.stream().map((Function<? super Profession, ? extends ProfessionDTO>) obj -> {
			ProfessionDTO dto = new ProfessionDTO();
			dto.setProfessionId(obj.getProfessionId());
			dto.setProfessionName(obj.getProfessionName());
			dto.setUpdateDateTime(obj.getUpdateDateTime());
			dto.setCreateDateTime(obj.getUpdateDateTime());
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}



	@Override
	public ProfessionDTO editProfession(Integer professionId) throws Exception {
		// TODO Auto-generated method stub
		ProfessionDTO professionDTO = new ProfessionDTO();
		Profession profession = professionDao.editProfession(professionId);
		BeanUtils.copyProperties(professionDTO, profession);
		return professionDTO;
	}

	@Override
	public void deleteProfession(Integer professionId) {
		// TODO Auto-generated method stub
		professionDao.deleteProfession(professionDao.editProfession(professionId));
	}

}
