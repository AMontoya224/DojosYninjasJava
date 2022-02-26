package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	
	public Dojo insertIntoDojos( Dojo dojo ) {
		return dojoRepository.save(dojo);
	}
	
	public List<Dojo> selectAllFromDojos(){
		List<Dojo> dojosList = dojoRepository.findAll();
		if ( dojosList.isEmpty() ) {
			Dojo dojoVacio = new Dojo("N/A", null, null);
			dojosList.add(dojoVacio);
		}
		return dojosList;
	}
	
	public Dojo selectFromDojosWhereId( long id ){
		List<Dojo> dojosList = dojoRepository.findById(id);
		if ( dojosList.isEmpty() ) {
			Dojo dojoVacio = new Dojo();
			return dojoVacio;
		}
		return dojosList.get(0);
	}
}
