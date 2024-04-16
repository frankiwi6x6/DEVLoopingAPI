package com.DEVLooping.cruddemo.rest;

import org.springframework.web.bind.annotation.*;

import com.DEVLooping.cruddemo.entity.Post;
import com.DEVLooping.cruddemo.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostRestController {

    private PostService postService;

    public PostRestController(PostService thePostService) {
        postService = thePostService;
    }
    // exponer "/posts" y retornar todos los usuarios

    @GetMapping("/posts")
    public List<Post> findAll() {
        List<Post> thePosts = postService.findAll();

        return thePosts;
    }

    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable int postId) {
        Post thePost = postService.findById(postId);
        if (thePost == null) {
            throw new RuntimeException("Post id not found - " + postId);
        }
        return thePost;
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post thePost) {
        thePost.setId(0);

        // Generar slug automáticamente
        String slug = generateSlug(thePost.getTitle(), thePost.getId());
        thePost.setSlug(slug);

        Post dbPost = postService.save(thePost);

        return dbPost;
    }

    private String generateSlug(String title, int id) {
        String baseSlug = title.toLowerCase().replaceAll(" ", "-");
        return baseSlug + "-" + id;
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post thePost) {
        Post dbPost = postService.findById(thePost.getId());

        if (dbPost == null) {
            throw new RuntimeException("Post id not found - " + thePost.getId());
        }

        // Actualizar los atributos
        dbPost.setTitle(thePost.getTitle());
        dbPost.setSlug(thePost.getSlug());
        dbPost.setAuthor_id(thePost.getAuthor_id());
        dbPost.setContent(thePost.getContent());
        dbPost.setStatus("updated");
        dbPost.setUpdated_at(LocalDateTime.now().toString());

        // Guardar los cambios en la base de datos
        postService.save(dbPost);

        return dbPost;
    }

    @PutMapping("/posts/{postId}")
    public String deletePost(@PathVariable int postId) {
        Post tempPost = postService.findById(postId);

        if (tempPost == null) {
            throw new RuntimeException("Post id not found - " + postId);
        }

        // Actualizar atributos deleted_at y status
        tempPost.setDeleted_at(LocalDateTime.now().toString());
        tempPost.setStatus("deleted");

        postService.save(tempPost); // Guardar los cambios en la base de datos

        return "Deleted post id - " + postId;
    }

}
