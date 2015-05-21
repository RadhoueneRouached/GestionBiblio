

package com.tn.isamm.controleurs;


/**
 * Author Radhouene Rouached
 */


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.beans.Adherent;
import com.tn.isamm.beans.Administrateur;
import com.tn.isamm.services.AdherentServiceImpl;
import com.tn.isamm.services.AdministrateurServiceImpl;



@Controller
public class LoginController {

	@Autowired
	private AdherentServiceImpl adherentServiceImpl ;
	@Autowired
	private AdministrateurServiceImpl administrateurServiceImpl ;
	
	
	@RequestMapping(value = { "/connexion" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		
		String task=""; 
		 LocaleContextHolder.getLocale();
		//model.addObject("emprunts", empruntServiceImpl.findAll()); 

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		//Administrateur administrateur = new Administrateur(); 
		//model1.addAttribute("Administrateur",administrateur); 
		model.setViewName("login");
		return model;

	}
	@RequestMapping(value = { "/deconnexion" })
	public ModelAndView deindex(
			@RequestParam(value = "message", required = false) String message , HttpSession session) {

		ModelAndView model = new ModelAndView();
		
		String task=""; 
		 LocaleContextHolder.getLocale();
		//model.addObject("emprunts", empruntServiceImpl.findAll()); 
			model.addObject("showmsg", true);
			model.addObject("message", message);
			session.invalidate();
			model.setViewName("login");
		return model;

	}
	
	
//
//	@RequestMapping(value = "/newEmprunt", method = RequestMethod.GET)
//	public ModelAndView newemprunt() {
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("ajouterEmprunt");
////		model.addObject("documents", documentServiceImpl.findAll());
////		model.addObject("adherents", adherentServiceImpl.findAll());
////		model.addObject("emprunt", new Emprunt());
//		return model;
//	}
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//	    sdf.setLenient(true);
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
	
	
	@RequestMapping(value = "/verifConnexion", method = RequestMethod.POST)
	public ModelAndView processVerifConnexion(  @RequestParam("login") String login,HttpSession session , @RequestParam("pwd") String pwd,org.springframework.web.context.request.WebRequest webRequest) {

		
		ModelAndView model = new ModelAndView();
		String admin = webRequest.getParameter("admin");
		//System.out.print("ADMIN value :"+admin);
		
		
		
		if (admin != null){
		Administrateur administrateur1 = administrateurServiceImpl.findByLogin(login, pwd); 
		//System.out.print("ADMIN ID VALUe :"+administrateur.getId_admin());
		if ( administrateur1 != null){

			model.addObject("message", "Bienvenue !");
			model.setViewName("redirect:/accueil");
			
		}
		else {
			
			model.addObject("message", "Invalide Login ou mdp !");
			model.setViewName("redirect:/connexion");
		}
		}
		else if (admin == null){
			Adherent adherent = adherentServiceImpl.findByLogin(login, pwd); 
			if ( adherent!=  null){
				session.setAttribute("id_adherent", adherent.getId_adherent());
				model.addObject("message", "Bienvenue !");
				model.setViewName("redirect:/consulterLivre");
				
			}	
			
		}
		else {
			model.addObject("message", "invalide login & mdp ");
			model.setViewName("redirect:/connexion");
			
		}
		

		return model;
	}

	
}
