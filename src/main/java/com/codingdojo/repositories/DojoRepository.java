package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	@SuppressWarnings("unchecked")
	Dojo save( Dojo dojo );
	
	List<Dojo> findAll();
	
	List<Dojo> findById( long id );
}
