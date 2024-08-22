package com.springboot.blog.springboot.blog.controller;

import com.springboot.blog.springboot.blog.model.BlogModel;
import com.springboot.blog.springboot.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

//    @GetMapping(value = "/name")
//    public String name(){
//
//        return "Shivangi Gupta";
//  }

    //call the service method in controller

    @Autowired
    private BlogService blogService;

    @PostMapping(value = "/addBlog")
    public BlogModel addBlogService(@RequestBody BlogModel blogModel){

        return blogService.addBlog(blogModel);

    }

    @GetMapping(value = "/getAllblogs")
    public List<BlogModel> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    //to get particular blog
    @GetMapping(value = "/{blogId}")
    public BlogModel getBlog(@PathVariable("blogId") int blogId)
    {
        return blogService.getBlog(blogId);
    }

    //to delete the particular blog

    @DeleteMapping(value = "/{blogId}")
    public String deleteTickets(@PathVariable("blogId") int blogId)
    {
        blogService.deleteBlog(blogId);
        return "Blog deleted";
    }
    @PutMapping(value =  "/{blogId}")
    public BlogModel updateBlog(@PathVariable("blogId") int blogId, @RequestBody BlogModel blogModel)
    {
        return blogService.updateBlog(blogId, blogModel);
    }

}
