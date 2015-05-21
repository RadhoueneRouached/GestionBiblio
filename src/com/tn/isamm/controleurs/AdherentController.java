package com.tn.isamm.controleurs;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tn.isamm.beans.Adherent;
import com.tn.isamm.beans.Adresse;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.AdresseServiceImpl;



/**
 * Author Radhouene Rouached
 */
@Controller
public class AdherentController extends WebMvcConfigurerAdapter{

	
	@Autowired
	private AdherentServiceImpl adherentServiceImpl ;
	@Autowired
	private AdresseServiceImpl adresseServiceImpl ;
	

    
	@RequestMapping(value = { "/GererAdherent" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		
		System.gc();
				model.addObject("adherents", adherentServiceImpl.findAll()); 

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		model.setViewName("GererAdherent");
		return model;

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newadherent() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ajouterAdherent");
		model.addObject("adherent", new Adherent());
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView processNewadherent(@ModelAttribute Adherent adherent, @ModelAttribute Adresse adresse) {

		ModelAndView model = new ModelAndView();
		
		adherent.setAdresse(adresse);
		adherentServiceImpl.createAdherent(adherent);
		
		adresseServiceImpl.createAdresse(adresse);
		model.addObject("message", "Votre adherent a été bien enregistré!");
		model.setViewName("redirect:/GererAdherent");

		return model;
	}

	@RequestMapping(value = "/delete/{id_adherent}", method = RequestMethod.GET)
	public ModelAndView deleteadherent(@PathVariable int id_adherent) {
		ModelAndView model = new ModelAndView();
		Adherent adherent = adherentServiceImpl.findAdherent(id_adherent); 
		adherentServiceImpl.delete(adherent); 

		model.addObject("message", "Votre adherent a  été supprimé!");
		model.setViewName("redirect:/GererAdherent");

		return model;
	}

	@RequestMapping(value = "/edit/{id_adherent}", method = RequestMethod.GET)
	public ModelAndView editadherent(@PathVariable int id_adherent) {

		ModelAndView model = new ModelAndView();
		Adherent adherent = adherentServiceImpl.findAdherent(id_adherent); 
		model.setViewName("ModifierAdherent");
		model.addObject(adherent);

		return model;
	}
	
	@RequestMapping(value = "/edit/{id_adherent}", method = RequestMethod.POST)
	public ModelAndView processEditlivre(@ModelAttribute Adherent adherent,@ModelAttribute Adresse adresse, @PathVariable int id_adherent) {

		ModelAndView model = new ModelAndView();
		//adherent adherent = adherentService.rechercheradherent(idadherent);
		
		
		adherent.setId_adherent(id_adherent);
		adherent.setAdresse(adresse);
		adherentServiceImpl.update(adherent); 
		
		model.addObject("message", "Votre adherent a été modifié!");
		model.setViewName("redirect:/GererAdherent");
		model.addObject(adherent);

		return model;
	}

	
}
