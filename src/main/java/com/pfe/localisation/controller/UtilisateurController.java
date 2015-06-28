package com.pfe.localisation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.pfe.localisation.json.ResponseJson;
import com.pfe.localisation.object.Utilisateur;
import com.pfe.localisation.service.UtilisateurService;



@Controller
@RequestMapping("/rest")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	//private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);
    
	
	
	@RequestMapping(value="/bonjour/{personne}", method = RequestMethod.GET)
    public @ResponseBody String afficherBonjour(final ModelMap pModel, 
                @PathVariable(value="personne") final String username) {

		String msg;
        pModel.addAttribute("personne", username);
        msg= "bonjour".concat(username).concat("avecspring");
        return msg;
    }
	
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST,headers = {"Content-type=application/json", "Accept=application/json"} )
    @ResponseBody
    public ResponseJson addUser(@RequestBody Utilisateur user)  {
		Utilisateur u=new Utilisateur();
		Date dateinscrit=new Date();

		if((u=utilisateurService.getUtilisateurByEmail(user.getEmail()))!=null){
			return new ResponseJson(false, "used email: try to sign in", null); 
			
				}else{
					user.setDateinscrit(dateinscrit);
			utilisateurService.persistUtilisateur(user);
			return new ResponseJson(true, "Registered", user); 
		}

    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,headers = {"Content-type=application/json", "Accept=application/json"} )
	@ResponseStatus( HttpStatus.OK )
    public @ResponseBody ResponseJson	 Login(@RequestBody String se)  {
		
		Boolean success=false;
		String info="Login Failed";
		Utilisateur user=new Utilisateur();
		String roleuser="";
		System.out.println(se);
		String password=se.substring(se.indexOf("d")+4, se.indexOf(",")-1);
		String email=se.substring(se.lastIndexOf(":")+2, se.length()-3);
		user=utilisateurService.getUtilisateurByEmail(email);
		System.out.print("username:  ");
		System.out.println(email);
    	System.out.print("password: ");
		System.out.println(password);
		if(user!=null){
    	   
    	   if(user.getPassword().equals(password)){
    		   success=true;
    		   info="Logged in";
    		   System.out.printf("OK");
    		   roleuser=user.getRole();
    		  
    		   
    	   }
    	   else{
    		  
    		   info=info.concat(":  Please re-enter your password: The password you entered is incorrect. Please try again");
    		   System.out.printf("Please re-enter your password: The password you entered is incorrect. Please try again ");
    		
    	   }
       }
       else{
    	
    	 
    	   info=info.concat(":  Incorrect Username: The username you entered does not belong to any account.");
    	   System.out.printf("Incorrect Username: The username you entered does not belong to any account.");
    	   
       }
      
		 return new ResponseJson(success, info,roleuser );
    }
	
	
	
}