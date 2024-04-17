package com.DEVLooping.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            throw new PostNotFoundException("Post id not found - " + postId);
        }
        return thePost;
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post thePost) {
        thePost.setId(0);
        String slug = generateSlug(thePost.getTitle(), thePost.getId());
        thePost.setSlug(slug);
        Post dbPost = postService.save(thePost);
        return dbPost;
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post thePost) {
        Post dbPost = postService.findById(thePost.getId());
        if (dbPost == null) {
            throw new PostNotFoundException("Post id not found - " + thePost.getId());
        }
        dbPost.setTitle(thePost.getTitle());
        dbPost.setSlug(thePost.getSlug());
        dbPost.setAuthor_id(thePost.getAuthor_id());
        dbPost.setContent(thePost.getContent());
        dbPost.setStatus("updated");
        dbPost.setUpdated_at(LocalDateTime.now().toString());
        postService.save(dbPost);
        return dbPost;
    }

    @PutMapping("/posts/{postId}")
    public String deletePost(@PathVariable int postId) {
        Post tempPost = postService.findById(postId);
        if (tempPost == null) {
            throw new PostNotFoundException("Post id not found - " + postId);
        }
        tempPost.setDeleted_at(LocalDateTime.now().toString());
        tempPost.setStatus("deleted");
        postService.save(tempPost);
        return "Deleted post id - " + postId;
    }

    private String generateSlug(String title, int id) {
        String baseSlug = title.toLowerCase().replaceAll(" ", "-");
        return baseSlug + "-" + id;
    }
}

@RestControllerAdvice
class PostRestControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(PostNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}

class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}