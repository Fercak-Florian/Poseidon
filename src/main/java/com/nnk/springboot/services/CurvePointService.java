package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointService {
	
	private CurvePointRepository curvePointRepository;
	
	public CurvePointService(CurvePointRepository curvePointRepository) {
		this.curvePointRepository = curvePointRepository;
	}

	public List<CurvePoint> getCurvePoints(){
		return curvePointRepository.findAll();
	}
	
	public Optional<CurvePoint> getCurvePointById(int id) {
		return curvePointRepository.findById(id);
	}
	
	public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
	}
	
	public CurvePoint updateCurvePoint(int id, CurvePoint curvePoint) {
		CurvePoint curvePointToUpdate = curvePointRepository.findById(id).get();
		curvePointToUpdate.setCurveId(curvePoint.getCurveId());
		curvePointToUpdate.setTerm(curvePoint.getTerm());
		curvePointToUpdate.setValue(curvePoint.getValue());
		return curvePointRepository.save(curvePointToUpdate);
	}
	
	public void deleteCurvePoint(int id) {
		CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id : " + id));
		curvePointRepository.delete(curvePoint);
	}
}
