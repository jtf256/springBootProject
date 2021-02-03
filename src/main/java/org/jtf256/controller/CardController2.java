//package org.jtf256.controller;
//
//import org.jtf256.entity.Card;
//import org.jtf256.entity.Greeting;
//import org.jtf256.service.CardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//@RestController
////@Controller
//public class CardController2 
//{
//		@Autowired
//	    CardService cardService;
//		
//		//index mapping
//		@RequestMapping(value = "/index")
//		public String homePage() {
//			//populate  index page here
//			return "index.html";
//		}
//		
//		@GetMapping("/allCards")
//		public List<Card> getAllCards()  throws InterruptedException, ExecutionException
//		{
//			return cardService.getAllCards();
//		}
//		
//
//	    @GetMapping("/getCardDetails")
//	    public Card getCard(@RequestParam String name) throws InterruptedException, ExecutionException
//	    {
//	        return cardService.getCardDetails(name);
//	    }
//	    
//	    @GetMapping("/addCard")
//	    public String addCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
//	    {
//	    	System.out.println(card);
//	    	return card.toString();
//	        //return cardService.saveCardDetatils(card);
//	    }
//
//	    @PostMapping("/createCard")
//	    public String createCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
//	    {
//	        return cardService.saveCardDetatils(card);
//	    }
//
//	    @PutMapping("/updateCard")
//	    public String updateCard(@RequestBody Card card ) throws InterruptedException, ExecutionException 
//	    {
//	        return cardService.updateCard(card);
//	    }
//
//	    @DeleteMapping("/deleteCard")
//	    public String deleteCard(@RequestParam String name)
//	    {
//	        return cardService.deleteCard(name);
//	    }
//	    
//	    
//	    //testing methods
//	    @GetMapping("/greeting")
//	    public String greetingForm(Model model) {
//	      model.addAttribute("greeting", new Greeting());
//	      return "greeting";
//	    }
//
//	    @PostMapping("/greeting")
//	    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//	      model.addAttribute("greeting", greeting);
//	      return "result";
//	    }
//
//}
