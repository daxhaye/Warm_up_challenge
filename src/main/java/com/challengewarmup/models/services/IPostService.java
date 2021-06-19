package com.challengewarmup.models.services;

import com.challengewarmup.models.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {

	public Optional<Post> findById(Long id);
	
    public List<Post> findAll();

    public List<Post> findByTitle(String title);
    
    public List<Post> findByCategory(String category);
    
    public List<Post> findByTitleAndCategory(String title, String category);
    
    public void guardar(Post post);
    
    public void actualizar(Long id);
    
    public void delete(Long id);
    
    
}
