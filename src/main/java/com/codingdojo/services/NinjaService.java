package com.codingdojo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public Ninja insertIntoNinjas( Ninja ninja ) {
		return ninjaRepository.save(ninja);
	}
}
