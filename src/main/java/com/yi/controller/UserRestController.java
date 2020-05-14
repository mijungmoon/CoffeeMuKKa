package com.yi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yi.domain.CafeVO;
import com.yi.service.CafeService;

@RestController
@RequestMapping("/rest/*")
public class UserRestController {
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<CafeVO>> cafeList(String cafeName){
		ResponseEntity<List<CafeVO>> entity = null;
		
		try {
			List<CafeVO> list = cafeService.searchCafeByName(cafeName);
			entity = new ResponseEntity<List<CafeVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<CafeVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}