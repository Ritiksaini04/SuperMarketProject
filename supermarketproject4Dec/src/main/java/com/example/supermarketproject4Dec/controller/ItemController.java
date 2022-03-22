package com.example.supermarketproject4Dec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.supermarketproject4Dec.domain.Item;
import com.example.supermarketproject4Dec.service.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService service;

    @RequestMapping("/")
    public String viewHomepage() {
       
    	// It returns the app menu home html page.
    	return "App menu";
    }
    
    @RequestMapping(path="/choice",method = RequestMethod.POST)
    public String handleChoice(@RequestParam("choice") int choice,Model model) {
    	
    int  myChoice = choice;
    
    if(choice == 1) {
    	List<Item> itemlist = service.listAll();
        model.addAttribute("itemlist", itemlist);
        System.out.print("Get / ");
        return "ViewItems";
    }
    else if(choice == 2){
    	model.addAttribute("item", new Item());
        return "new";
    }else if(choice == 3){
         return "delete";
    }
    else {
    	return "Not Found";
    }

    
    }
    
    @RequestMapping(path = "/deleteItem", method = RequestMethod.POST)
    public String deleteHandling(
    		@RequestParam("deleteitemvalue") int deleteItemValue,
    		Model model) {
    	service.delete(deleteItemValue);
    	return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") Item std) {
        service.save(std);
        return "redirect:/";
    }



}