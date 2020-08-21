package com.arena.ToDoList.Controllers;

import com.arena.ToDoList.Entities.Post;
import com.arena.ToDoList.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getPost(Model model) {
        List<Post> listPosts = postService.getAll();
        model.addAttribute("listPosts", listPosts);
        model.addAttribute("post", new Post());

        return "index";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @RequestMapping("/update_post/{id}")
    public ModelAndView getPost(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("update_post");
        Post post = postService.get(id);
        mav.addObject("post", post);
        return mav;
    }

    @RequestMapping(value="/deletePost/{id}")
    public String deletePost(@PathVariable Long id, Model model) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
