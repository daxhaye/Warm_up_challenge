package com.challengewarmup.controllers;

import com.challengewarmup.models.entity.Post;
import com.challengewarmup.models.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PostRestController {

    @Autowired
    private IPostService postService;

    @GetMapping("/posts")
    public List<Post> listar(@RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "category", required = false) String category) {

    	if (title != null && category != null) {
    		return postService.findByTitleAndCategory(title, category);
    	}
    	
    	
        if (title != null) {
            return postService.findByTitle(title);
        }
        
        if (category != null) {
        	return postService.findByCategory(category);
        }

        return (List<Post>) postService.findAll();
    }
    
    @GetMapping("/posts/{id}")
    public Optional<Post> ver(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
    	Optional<Post> post =  postService.findById(id);
    	
    	if(post == null) {
    		flash.addFlashAttribute("error", "Id no valido");
    	}
    	
    	return post;
    }
    
    @PostMapping("/posts")
    public void guardar(Post post) {
    	postService.guardar(post);
    }
    
    @PatchMapping("/posts/{id}")
    public void actualizar(@PathVariable(value = "id") Long id, RedirectAttributes flash, HttpServletRequest request) {
    	
    }
    
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
    	  postService.delete(id);
    }
}
