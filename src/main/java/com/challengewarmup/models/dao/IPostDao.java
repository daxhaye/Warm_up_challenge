package com.challengewarmup.models.dao;

import com.challengewarmup.models.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IPostDao extends JpaRepository<Post, Long> {


    public List<Post> findByTitulo(String title);
    
    public List<Post> findByCategoria(String categoria);
    
    public List<Post> findByTituloAndCategoria(String titulo, String categoria);
}
