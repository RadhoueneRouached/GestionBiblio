

package com.tn.isamm.controleurs;



/**
 * Author Radhouene Rouached
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.beans.Emprunt;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.DocumentServiceImpl;
import com.tn.isamm.services.EmpruntServiceImpl;



@Controller
public class EmpruntController {

	
	@Autowired
	private EmpruntServiceImpl empruntServiceImpl ;
	@Autowired
	private AdherentServiceImpl adherentServiceImpl; 
	@Autowired
	private DocumentServiceImpl documentServiceImpl ; 
	
	@RequestMapping(value = { "/GererEmprunt" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		

		model.addObject("emprunts", empruntServiceImpl.findAll()); 

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		model.setViewName("GererEmprunt");
		return model;

	}

	@RequestMapping(value = "/newEmprunt", method = RequestMethod.GET)
	public ModelAndView newemprunt() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ajouterEmprunt");
		model.addObject("documents", documentServiceImpl.findAll());
		model.addObject("adherents", adherentServiceImpl.findAll());
		model.addObject("emprunt", new Emprunt());
		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	@RequestMapping(value = "/newEmprunt", method = RequestMethod.POST)
	public ModelAndView processNewemprunt(@ModelAttribute Emprunt emprunt ,  @RequestParam("id_adherent") int id_adherent , @RequestParam("id_support") int id_support) {

		ModelAndView model = new ModelAndView();
		
		
		
		emprunt.setAdherent(adherentServiceImpl.findAdherent(id_adherent));
		emprunt.setDocument(documentServiceImpl.findDocument(id_support));
		empruntServiceImpl.createEmprunt(emprunt);
		
		
		model.addObject("message", "Votre emprunt a été bien enregistré!");
		model.setViewName("redirect:/GererEmprunt");

		return model;
	}

	@RequestMapping(value = "/deleteEmprunt/{id_emprunt}", method = RequestMethod.GET)
	public ModelAndView deleteemprunt(@PathVariable int id_emprunt) {
		ModelAndView model = new ModelAndView();
		Emprunt emprunt = empruntServiceImpl.findEmprunt(id_emprunt); 
		empruntServiceImpl.delete(emprunt); 

		model.addObject("message", "Votre emprunt a  été supprimé!");
		model.setViewName("redirect:/GererEmprunt");

		return model;
	}

	@RequestMapping(value = "/editEmprunt/{id_emprunt}", method = RequestMethod.GET)
	public ModelAndView editemprunt(@PathVariable int id_emprunt) {

		ModelAndView model = new ModelAndView();
		Emprunt emprunt = empruntServiceImpl.findEmprunt(id_emprunt); 
		model.setViewName("ModifierEmprunt");
		model.addObject("documents", documentServiceImpl.findAll());
		model.addObject("adherents", adherentServiceImpl.findAll());
		model.addObject("emprunts" , empruntServiceImpl.findEmprunt(id_emprunt));

		return model;
	}
	
	@RequestMapping(value = "/editEmprunt/{id_emprunt}", method = RequestMethod.POST)
	public ModelAndView processEditlivre(@ModelAttribute Emprunt emprunt, @PathVariable int id_emprunt ,  @RequestParam("id_adherent") int id_adherent , @RequestParam("id_support") int id_support) {

		ModelAndView model = new ModelAndView();
		//emprunt emprunt = empruntService.rechercheremprunt(idemprunt);
		
		
		emprunt.setId_emp(id_emprunt);
		emprunt.setAdherent(adherentServiceImpl.findAdherent(id_adherent));
		emprunt.setDocument(documentServiceImpl.findDocument(id_support));
		empruntServiceImpl.update(emprunt); 
		
		model.addObject("message", "Votre emprunt a été modifié!");
		model.setViewName("redirect:/GererEmprunt");
		model.addObject(emprunt);

		return model;
	}

	
}
