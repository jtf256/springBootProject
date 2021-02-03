package org.jtf256.controller;

import org.jtf256.entity.Card;
import org.jtf256.entity.Greeting;
import org.jtf256.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

//@RestController
@Controller
public class CardController 
{
		@Autowired
	    CardService cardService;
		
		//index mapping
		@RequestMapping(value = "/index")
		public String homePage() {
			//populate  index page here
			return "index.html";
		}
		
		
/*		
 * @GetMapping("/allCards")
		public List<Card> getAllCards()  throws InterruptedException, ExecutionException
		{
			return cardService.getAllCards();
		}
		

	    @GetMapping("/getCardDetails")
	    public Card getCard(@RequestParam String name) throws InterruptedException, ExecutionException
	    {
	        return cardService.getCardDetails(name);
	    }
	    

	    @GetMapping("/addCard")
	    public String addCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
	    {
	    	System.out.println(card);
	    	return card.toString();
	        //return cardService.saveCardDetatils(card);
	    }

	    @PostMapping("/createCard")
	    public String createCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
	    {
	        return cardService.saveCardDetatils(card);
	    }

	    @PutMapping("/updateCard")
	    public String updateCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
	    {
	        return cardService.updateCard(card);
	    }

	    @DeleteMapping("/deleteCard")
	    public String deleteCard(@RequestParam String name)
	    {
	        return cardService.deleteCard(name);
	    }
	    */
	    
	    
	    //testing methods
	    @GetMapping("/greeting")
	    public String greetingForm(Model model) {
	      model.addAttribute("greeting", new Greeting());
	      return "greeting";
	    }

	    @PostMapping("/greeting")
	    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
	      model.addAttribute("greeting", greeting);
	      return "result";
	    }
	    
	    @GetMapping("/del/{name}")
	    public String delCard(@PathVariable("name") String name, Model model)
	    {
	    	Card card  = new  Card();
	    	try {
		    	card = cardService.getCardDetails(name);
		    	System.out.println("Deleting: "  + card);
				String result =  cardService.deleteCard(card.getName());
		    	System.out.println(result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return addCard(model);
	    	
	    }
	    
		/*
		 * @PostMapping("/del/{name}") public String success_del(@ModelAttribute("card")
		 * Card card, Model model) { System.out.println("Post Del Method Call"); try {
		 * //String result = cardService.deleteCard(c); String result =
		 * cardService.deleteCard(card.getName()); System.out.println(result);
		 * model.addAttribute("cards", cardService.getAllCards()); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (ExecutionException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } return "database"; }
		 */
	    
	    @GetMapping("/up/{name}")
	    public String upCard(@PathVariable("name") String name, Model model)
	    {

	    	
	    	try {
		    	Card card = cardService.getCardDetails(name);
		    	System.out.println("TESTING: "  + card);
		    	model.addAttribute("card", card);
				//model.addAttribute("cards", cardService.getAllCards());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return "update.html";
	    	
	    }
	    
	    @PostMapping("/up/{name}")
	    public String success_upCard(@ModelAttribute("card") Card card, Model  model)
	    {
	    	System.out.println("success_upCard "+card);
	    	try {
				cardService.updateCard(card);
				model.addAttribute("cards", cardService.getAllCards());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return "database";
	    }
	    

	    @GetMapping("/addCard")
	    public String addCard(Model  model)
	    {
	    	Card card  = new Card();
	    	model.addAttribute("card",card);
	    	
	    	try {
				model.addAttribute("cards", cardService.getAllCards());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return "database";
	    }
	    
	    @PostMapping(value = "/addCard")
	    public String success_addCard(@ModelAttribute("card") Card card, Model  model)
	    {
	    	System.out.println(card);
	    	
	    	try {
				cardService.saveCardDetatils(card);
				model.addAttribute("cards", cardService.getAllCards());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return "database";
	    }


}
