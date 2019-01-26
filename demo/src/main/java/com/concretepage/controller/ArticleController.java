package com.concretepage.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;


@Controller
@SessionAttributes("title")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("Article", "command", new Article());
	   }
	
	
	 
	 @GetMapping("/selectArticle")
		public String getArticleBycategory(@PathVariable("category") String category) {
			Article article = articleService.findDistinctByCategory(category);
			System.out.println(article.getCategory());
			ModelAndView mv = new ModelAndView();
			mv.addObject("article",article);
			return "welcome";
		}
	 
	 
	 @PostMapping("addArticle")
		public String addArticle(@ModelAttribute("article") Article article, UriComponentsBuilder builder,Model model) {
			  model.addAttribute("id", article.getArticleId());
		      model.addAttribute("category", article.getCategory());
		      model.addAttribute("title", article.getTitle());
		      model.addAttribute("article", article);
			boolean flag = articleService.addArticle(article);  
	        if (flag == false) {
	        	return "welcome";
	        }
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
	        return "welcome";
		}
	 
	 
	@GetMapping("/articleByCategory")
	public String getArticleById(@PathVariable("category") String category) {
		Article article = articleService.findDistinctByCategory(category);
		System.out.println(article.getCategory());
		ModelAndView mv = new ModelAndView();
		mv.addObject("article",article);
		return "welcome";
	}
	
	@GetMapping("/articles")
	public String getAllArticles(Model mv) {
		
		mv.addAttribute("message","Dilip");
		List<Article> list = articleService.getAllArticles();
		mv.addAttribute("list",list);
		return "new";
	}
	
	@GetMapping("/allCategory")
	public ModelAndView getAllDistinctCategories(Model model) {
		 
		List<Article> list = articleService.getAllArticles();
		List<String> catList= new ArrayList<>();
		for(Article art :list )
		{
			catList.add(art.getCategory());
		}
		ModelAndView mv = new ModelAndView("index","command",catList);
		mv.addObject("list", catList);
		return  mv;
	}
	
	
	@PostMapping("Article")
	public String updateArticle(@ModelAttribute("article") Article article,Model model){
		      model.addAttribute("name", article.getArticleId());
		      model.addAttribute("age", article.getCategory());
		      model.addAttribute("id", article.getTitle());
		      articleService.updateArticle(article);
		
		return "welcome";
	}
	   
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 