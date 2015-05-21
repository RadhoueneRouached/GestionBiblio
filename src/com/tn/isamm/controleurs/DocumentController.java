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

import com.tn.isamm.beans.Document;
import com.tn.isamm.beans.Adresse;
import com.tn.isamm.services.DocumentServiceImpl;
import com.tn.isamm.services.AdresseServiceImpl;



/**
 * Author Radhouene Rouached
 */
@Controller
public class DocumentController {

	
	@Autowired
	private DocumentServiceImpl documentServiceImpl ;
	
	
	@RequestMapping(value = { "/accueil" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		
		System.gc();
				model.addObject("documents", documentServiceImpl.findAll()); 

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		model.setViewName("accueil");
		return model;

	}

	@RequestMapping(value = "/newDocument", method = RequestMethod.GET)
	public ModelAndView newdocument() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ajouterLivre");
		model.addObject("document", new Document());
		return model;
	}

	@RequestMapping(value = "/newDocument", method = RequestMethod.POST)
	public ModelAndView processNewdocument(@ModelAttribute Document document) {

		ModelAndView model = new ModelAndView();
		
		
		documentServiceImpl.createDocument(document);
		
		
		model.addObject("message", "Votre document a été bien enregistré!");
		model.setViewName("redirect:/accueil");

		return model;
	}

	@RequestMapping(value = "/deleteDocument/{id_support}", method = RequestMethod.GET)
	public ModelAndView deletedocument(@PathVariable int id_support) {
		ModelAndView model = new ModelAndView();
		Document document = documentServiceImpl.findDocument(id_support); 
		documentServiceImpl.delete(document); 

		model.addObject("message", "Votre document a  été supprimé!");
		model.setViewName("redirect:/accueil");

		return model;
	}

	@RequestMapping(value = "/editDocument/{id_support}", method = RequestMethod.GET)
	public ModelAndView editdocument(@PathVariable int id_support) {

		ModelAndView model = new ModelAndView();
		Document document = documentServiceImpl.findDocument(id_support); 
		model.setViewName("ModifierLivre");
		model.addObject(document);

		return model;
	}
	
	@RequestMapping(value = "/editDocument/{id_support}", method = RequestMethod.POST)
	public ModelAndView processEditlivre(@ModelAttribute Document document, @PathVariable int id_support) {

		ModelAndView model = new ModelAndView();
		//document document = documentService.rechercherdocument(iddocument);
		
		
		document.setId_support(id_support);
		documentServiceImpl.update(document); 
		
		model.addObject("message", "Votre document a été modifié!");
		model.setViewName("redirect:/accueil");
		model.addObject(document);

		return model;
	}

	
}
