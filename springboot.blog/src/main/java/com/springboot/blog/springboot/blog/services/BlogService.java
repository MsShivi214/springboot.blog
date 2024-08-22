package com.springboot.blog.springboot.blog.services;

import com.springboot.blog.springboot.blog.model.BlogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class BlogService {
    //add blog
    //get blog
    ///delete blog
    //update blog
    //get all blogs

    //to set initial blog id
    private int id = 1;
    //to set the data into collection class list of model
    List<BlogModel> list = new CopyOnWriteArrayList<>();

    //to add the blog
    public BlogModel addBlog(BlogModel blogModel){
        blogModel.setBlogId(id);
        list.add(blogModel);
        id++;
        return blogModel;
    }

    //to fetch the all blog
    public List<BlogModel> getAllBlogs(){
        return list;
    }

    ///to fetch the particular blog
    public BlogModel getBlog(int blogId)
    {
        return list.stream().filter(t -> t.getBlogId() == blogId)
                .findFirst().get();
    }

    //to delete the blog
    public void deleteBlog(int blogId)
    {
        list.stream()
                .forEach(t -> {
                    if (t.getBlogId() == blogId)
                    {
                        list.remove(t);
                    }
                });
    }

    //to update the blog
    public BlogModel updateBlog(int blogId, BlogModel blogModel)
    {
        list.stream().forEach(t -> {
            if (t.getBlogId() == blogId){
                t.setBlogTitle(blogModel.getBlogTitle());
                t.setBlogDesc(blogModel.getBlogDesc());
                t.setAuthorName(blogModel.getAuthorName());
                t.setData(blogModel.getData());
            }
        });

        return list.stream()
                .filter(t -> t.getBlogId() == blogId)
                .findFirst()
                .get();
    }











}
