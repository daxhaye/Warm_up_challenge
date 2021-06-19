package com.challengewarmup.models.services;

import com.challengewarmup.models.dao.IPostDao;
import com.challengewarmup.models.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostServicesImpl implements IPostService{

    @Autowired
    private IPostDao postDao;

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        List<Post> post = (List<Post>) postDao.findAll();

        post.sort(Comparator.comparing(Post::getCreateAt).reversed());

        return post;
    }

    @Override
    public List<Post> findByTitle(String title) {
        return postDao.findByTitulo(title);
    }

	@Override
	public List<Post> findByCategory(String category) {
		return postDao.findByCategoria(category);
	}

	@Override
	public List<Post> findByTitleAndCategory(String title, String category) {
		return postDao.findByTituloAndCategoria(title, category);
	}

	@Override
	public Optional<Post> findById(Long id) {
		return postDao.findById(id);
	}

	@Override
	public void guardar(Post post) {
		postDao.save(post);
	}

	@Override
	public void actualizar(Long id) {
		postDao.save(null);
	}

	@Override
	public void delete(Long id) {
		postDao.delete(postDao.getById(id));
	}
}
