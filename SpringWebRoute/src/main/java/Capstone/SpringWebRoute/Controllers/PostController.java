package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

    public List<Post> posts = new ArrayList<>();

    @Autowired
    PostService postSer;

    @PostMapping("/AddPost/{userId}")
    public Post addPost(@PathVariable int userId, @RequestBody Post newPost) {

        newPost.setUserId(userId);
        postSer.save(newPost);

        return newPost;
    }

    @GetMapping("/GetAllPosts")
    public List<Post> getAllPosts() {
        return postSer.getAllPosts();
    }

    @GetMapping("/GetPost/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postSer.getPostById(postId);
    }


    @GetMapping("/GetPostsByUserId/{userId}")
    public List<Post> getPostsByUserId(@PathVariable int userId) {

        return postSer.getAllPostsByUserId(userId);
    }

    @PutMapping("/UpdatePost")
    public Post updatePost(@RequestBody Post upPost) {
        return postSer.save(upPost);
    }

    //TODO Update for DB --Not sure
    @PutMapping("/UpdatePostDesc/{postId}")
    public Post updatePostDescription(@PathVariable int postId, @RequestBody Post upPost) {

        Post foundPost = new Post();

        for (Post post : posts) {
            if (post.getPostId() == postId) {
                post.setPostDescription(upPost.getPostDescription());
                foundPost = post;
            }
        }

        return foundPost;
    }

    @PutMapping("/DeletePost/{postId}")
    public Post deletePost(@PathVariable int postId) {

        Post currentPost = postSer.getPostById(postId);

        currentPost.setPostDisabled(true);

        return currentPost;
    }

}
