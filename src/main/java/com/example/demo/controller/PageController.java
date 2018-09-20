package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	@RequestMapping(value= {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	@RequestMapping("/generator")
	public String valueGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		String jumlah = "";
		String hasil = "";
		if(a == 0) {
			a = 1;
		}
		if(b == 0) {
			b = 1;
		}
		for(int j = 0; j < a; j++) {
			jumlah+="m";
		}
		for(int i = 0; i < b; i++) {
			hasil+="h"+jumlah+" ";
		}
		System.out.println(hasil);
		model.addAttribute("hasil", hasil);
		return "generator";
	}
}