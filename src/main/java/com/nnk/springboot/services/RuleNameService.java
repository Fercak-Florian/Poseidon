package com.nnk.springboot.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameService {
	
	private RuleNameRepository ruleNameRepository;
	
	public RuleNameService(RuleNameRepository ruleNameRepository) {
		this.ruleNameRepository = ruleNameRepository;
	}

	public List<RuleName> getRuleNames(){
		return ruleNameRepository.findAll();
	}
	
	public RuleName getRuleNameById(int id){
		return ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id : " + id));
	}
	
	public RuleName saveRuleName(RuleName ruleName) {
		return ruleNameRepository.save(ruleName);
	}
	
	public RuleName updateRuleName(int id, RuleName ruleName) {
		RuleName ruleNameToUpdate = ruleNameRepository.findById(id).get();
		ruleNameToUpdate.setName(ruleName.getName());
		ruleNameToUpdate.setDescription(ruleName.getDescription());
		ruleNameToUpdate.setJson(ruleName.getJson());
		ruleNameToUpdate.setTemplate(ruleName.getTemplate());
		ruleNameToUpdate.setSqlStr(ruleName.getSqlStr());
		ruleNameToUpdate.setSqlPart(ruleName.getSqlPart());
		return ruleNameRepository.save(ruleNameToUpdate);
	}
	
	public void deleteRuleName(int id) {
		RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id : " + id));
		ruleNameRepository.delete(ruleName);
	}
}
