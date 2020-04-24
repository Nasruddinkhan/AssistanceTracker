/**
 * nasru
 * RelationShipController.java
 * Apr 11, 2020
 */
package com.mypractice.assistancetracker.controller;
import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.COLON;
import static com.mypractice.assistancetracker.util.CommonUtils.CSS;
import static com.mypractice.assistancetracker.util.CommonUtils.DELETE;
import static com.mypractice.assistancetracker.util.CommonUtils.EDIT;
import static com.mypractice.assistancetracker.util.CommonUtils.MSG;
import static com.mypractice.assistancetracker.util.CommonUtils.MST;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIP;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIPS;
import static com.mypractice.assistancetracker.util.CommonUtils.RELATIONSHIP_URL;
import static com.mypractice.assistancetracker.util.CommonUtils.RIDIRECT;
import static com.mypractice.assistancetracker.util.CommonUtils.SAVE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;
import static com.mypractice.assistancetracker.util.CommonUtils.responseResult;
import static com.mypractice.assistancetracker.util.ErrorConstant.SUCCESS;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mypractice.assistancetracker.dto.RelationshipDto;
import com.mypractice.assistancetracker.service.RelationshipService;

/**
 * @author nasru
 *
 */
@Controller
@RequestMapping(MST)
public class RelationShipController {
	@Autowired
	private RelationshipService relationService;
	public void onLoads(ModelMap model)  {
		model.addAttribute(RELATIONSHIPS, relationService.findAll());
	}
	@GetMapping(RELATIONSHIP_URL)
	public String showReason(ModelMap model)  {
		onLoads(model);
		model.addAttribute(RELATIONSHIP, new RelationshipDto());
		return RELATIONSHIP;
	}
	@PostMapping(SLASH + SAVE + RELATIONSHIP)
	public String saveRelationship(@ModelAttribute(RELATIONSHIP) @Valid RelationshipDto relationshipDto, BindingResult result,
			ModelMap model, final RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("RelationShipController.saveRelationship()"+relationshipDto);
		if (result.hasErrors()) {
			onLoads(model);
			return RELATIONSHIP;
		}
		relationService.saveRelationship(relationshipDto);
		redirectAttributes.addFlashAttribute(CSS, SUCCESS);
		redirectAttributes.addFlashAttribute(MSG, responseResult(relationshipDto.getIsNew()));
		return RIDIRECT.concat(COLON).concat(RELATIONSHIP).concat(URL_ACTION);

	}
	@GetMapping(EDIT+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+RELATIONSHIP)
	public String editRelationship(@PathVariable(URL_ID) String relationshipId,ModelMap model) throws Exception {
		onLoads(model);						
		RelationshipDto relationshipDto =  relationService.editRelationship( relationshipId);
		model.addAttribute(RELATIONSHIP, relationshipDto);
		return RELATIONSHIP;
	}
	
	@GetMapping(DELETE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+RELATIONSHIP)
	public String  deleteRelationship(@PathVariable(URL_ID) String relationshipId,
			ModelMap model) {
		relationService.deleteRelationship(relationshipId);
		onLoads(model);
		model.addAttribute(RELATIONSHIP, new RelationshipDto());
		return RELATIONSHIP;
	}
}
