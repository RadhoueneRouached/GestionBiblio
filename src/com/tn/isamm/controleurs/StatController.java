

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

import com.tn.isamm.DAO.AdministrateurDAO;
import com.tn.isamm.beans.Emprunt;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.AdministrateurServiceImpl;
import com.tn.isamm.services.DocumentServiceImpl;
import com.tn.isamm.services.EmpruntServiceImpl;



@Controller
public class StatController {

	@Autowired
	private AdherentServiceImpl adherentServiceImpl ;
	@Autowired
	private EmpruntServiceImpl empruntServiceImpl; 
	@Autowired
	private DocumentServiceImpl documentServiceImpl;  
	
	@RequestMapping(value = { "/stat" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		
		model.addObject("empruntTotal", empruntServiceImpl.nombreEmpruntTotal()); 
		Long lg =adherentServiceImpl.nombreTotalAdherent(); 
		model.addObject("adherentTotal",lg ); 
		model.addObject("documentTotal", documentServiceImpl.nombreLivre()); 
		System.out.print("adherentTotal  :"+lg);
		model.addObject("emprunts", empruntServiceImpl.findAll()); 

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		model.setViewName("statistique");
		return model;

	}
}