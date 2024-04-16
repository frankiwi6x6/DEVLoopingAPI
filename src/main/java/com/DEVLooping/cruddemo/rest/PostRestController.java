package com.DEVLooping.cruddemo.rest;

import org.springframework.web.bind.annotation.*;

import com.DEVLooping.cruddemo.entity.Post;
import com.DEVLooping.cruddemo.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostRestController {

    private PostService postService;
    public PostRestController(PostService thePostService){
        postService = thePostService;
    }
    // exponer "/posts" y retornar todos los usuarios

    @GetMapping("/posts")
    public List<Post> findAll(){
        List<Post> thePosts = postService.findAll();
        

        return thePosts;
    }

    @GetMapping("/posts/{userId}")
    public Post findById(@PathVariable int postId){
        Post thePost = postService.findById(postId);
        if (thePost == null){
            throw new RuntimeException("User id not found - " + postId );
        }
        return thePost;
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post thePost){
        thePost.setId(0);

        Post dbPost = postService.save(thePost);

        return dbPost;
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post theUser){

        Post dbPost = postService.save(theUser);

        return dbPost;
    }

    @DeleteMapping("/posts/{postId}")
    public String deleteUser(@PathVariable int postId){
        Post tempUser = postService.findById(postId);

        if (tempUser==null){
            throw new RuntimeException("User id not found - "+postId);
        }
        postService.deleteById(postId);
        return "Deleted user id - "+postId;
    }
}
