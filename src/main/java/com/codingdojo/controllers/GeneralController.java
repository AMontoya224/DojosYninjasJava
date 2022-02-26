package com.codingdojo.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;
import com.codingdojo.services.NinjaService;

@Controller
public class GeneralController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	public Date date = new Date();
	
	@RequestMapping( value="dojos/new", method=RequestMethod.GET )
	public String dojos( Model model, @ModelAttribute("dojos") Dojo dojo ) {
		return "dojos.jsp";
	}
	
	@RequestMapping( value="/dojos/new", method=RequestMethod.POST )
	public String dojo_register( @Valid @ModelAttribute("dojos") Dojo dojo, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			return "dojos.jsp";
		}
		dojo.setCreatedAt(date);
		dojo.setUpdatedAt(date);
		dojoService.insertIntoDojos(dojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping( value="ninjas/new", method=RequestMethod.GET )
	public String ninjas( Model model, @ModelAttribute("ninjas") Ninja ninja ) {
		List<Dojo> dojosList = dojoService.selectAllFromDojos();
		model.addAttribute( "dojosList", dojosList );
		return "ninjas.jsp";
	}
	
	@RequestMapping( value="/ninjas/new", method=RequestMethod.POST )
	public String ninja_register( @Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			List<Dojo> dojosList = dojoService.selectAllFromDojos();
			model.addAttribute( "dojosList", dojosList );
			return "ninjas.jsp";
		}
		ninja.setCreatedAt(date);
		ninja.setUpdatedAt(date);
		ninjaService.insertIntoNinjas(ninja);
		return String.format( "redirect:/dojos/%s", ninja.getDojo().getId());
	}
	
	@RequestMapping( value="/dojos/{id}", method=RequestMethod.GET )
	public String dashboard(@PathVariable("id") long id, Model model ) {
		Dojo dojo = dojoService.selectFromDojosWhereId(id);
		model.addAttribute( "dojo", dojo );
		return "dashboard.jsp";
    }
}
