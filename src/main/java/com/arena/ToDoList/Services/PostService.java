package com.arena.ToDoList.Services;

import com.arena.ToDoList.Entities.Post;
import com.arena.ToDoList.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post get(long id) {
        return postRepository.findById(id).get();
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}

