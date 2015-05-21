package com.tn.isamm.controleurs;

import com.tn.isamm.services.EmpruntServiceImpl;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

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
import com.tn.isamm.beans.Document;
import com.tn.isamm.beans.Emprunt;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.DocumentServiceImpl;


/**
 * Author Radhouene Rouached
 */
@Controller
public class AdherentViewController {

	
	@Autowired
	private DocumentServiceImpl documentServiceImpl ;
	@Autowired
	private AdherentServiceImpl adherentServiceImpl ;
	@Autowired
	EmpruntServiceImpl empruntServiceImpl2 = new EmpruntServiceImpl();

	String message  ;
	
	@RequestMapping(value = "/consulterLivre", method = RequestMethod.GET)
	public ModelAndView consulterLivre() {

		ModelAndView model = new ModelAndView();
	
	model.addObject("documents",documentServiceImpl.findAll() );
	model.addObject("message", message);	
	model.setViewName("consulterLivre");
		//model.addObject("adherent", new Adherent());
		return model;
	}

	@RequestMapping(value = "/rechercheLivre", method = RequestMethod.GET)
	public ModelAndView rechercheDocument(@RequestParam(value = "rechDoc", required = false) String rechDoc) {

		ModelAndView model = new ModelAndView();
		model.addObject("Document", documentServiceImpl.findByName(rechDoc)); 
		model.setViewName("RechercherLivre");
		
		//model.addObject("adherent", new Adherent());
		return model;
	}
	@RequestMapping(value = "/EmprunterLivreAdherent/{id_support}", method = RequestMethod.GET)
	public ModelAndView processEditlivre(@PathVariable int id_support, HttpSession session) {

		ModelAndView model = new ModelAndView();
		//adherent adherent = adherentService.rechercheradherent(idadherent);
		
		
		int id_adherent= (int)session.getAttribute("id_adherent"); 
		Document document = documentServiceImpl.findDocument(id_support); 
		Adherent adherent = adherentServiceImpl.findAdherent(id_adherent); 
		Emprunt emprunt = new Emprunt(); 
		Calendar db = Calendar.getInstance();
		Calendar df = Calendar.getInstance();
		
		df.add(Calendar.DAY_OF_MONTH, 3);
		System.out.print("date calendar :" + db.getTime());
		emprunt.setDateDeb(db.getTime());
		emprunt.setDateFin(df.getTime());
		Byte x = 0;
		emprunt.setDepasse(x);
		
		emprunt.setDocument(document);
		emprunt.setAdherent(adherent);
		
		if (empruntServiceImpl2.EmpruntDouble(id_adherent) == 0){
		if (documentServiceImpl.numberExDoc(id_support) >0){
		empruntServiceImpl2.createEmprunt(emprunt);
		documentServiceImpl.minusDoc(id_support); 
//empruntServiceImpl2.EmpruntParAdherent(); 
		model.addObject("message", "Votre Emprunt a été ajouté !");
		model.setViewName("redirect:/consulterLivre");
		message ="Votre emprunt a  été ajouté avec succés !";
		}else {
			
			model.setViewName("redirect:/consulterLivre");
			message="Nombre d'exemplaire insuffisant !";
			
		}
		}
		else {
			model.setViewName("redirect:/consulterLivre");
			message="Vous avez deja emprunté !";
		}
		 
		return model;
	}
	@RequestMapping(value = "/mesEmp", method = RequestMethod.GET)
	public ModelAndView empruntDocument(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		//model.addObject("messageEmprunt", "Votre Emprunt a été ajouté !");
		int id_adherent= (int)session.getAttribute("id_adherent"); 
		model.addObject("emprunts", empruntServiceImpl2.EmpruntParAdherent(id_adherent)); 
		model.setViewName("MesEmprunt");
		
		//model.addObject("adherent", new Adherent());
		return model;
	}
}