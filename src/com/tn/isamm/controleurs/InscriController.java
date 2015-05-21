package com.tn.isamm.controleurs;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.beans.Adherent;
import com.tn.isamm.beans.Adresse;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.AdresseServiceImpl;



/**
 * Author Radhouene Rouached
 */
@Controller
public class InscriController {

	
	@Autowired
	private AdherentServiceImpl adherentServiceImpl ;
	@Autowired
	private AdresseServiceImpl adresseServiceImpl ;
	
	
	@RequestMapping(value = { "/inscription" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		
		System.gc();

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		model.setViewName("inscription");
		
		return model;

	}

	@RequestMapping(value = "/newAdherent", method = RequestMethod.POST)
	public ModelAndView processNewadherent(@ModelAttribute Adherent adherent, @ModelAttribute Adresse adresse) {

		ModelAndView model = new ModelAndView();
		
		adherent.setAdresse(adresse);
		adherentServiceImpl.createAdherent(adherent);
		
		adresseServiceImpl.createAdresse(adresse);
		model.addObject("message", "Vous etes bien enregistré!");
		model.setViewName("redirect:/connexion");

		return model;
	}

}