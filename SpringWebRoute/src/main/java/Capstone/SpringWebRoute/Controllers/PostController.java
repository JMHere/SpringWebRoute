package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

        public List<Post> posts = new ArrayList<>();

        @PostMapping("/AddPost/{userId}")
        public Post addPost(@PathVariable int userId, @RequestBody Post newPost) {

            newPost.setUserId(userId);
            posts.add(newPost);

            return newPost;
        }

        @GetMapping("/GetAllPosts")
        public List<Post> getAllPosts() {
            return posts;
        }

        @GetMapping("/GetPostsByUserId/{userId}")
        public List<Post> getPostsByUserId(@PathVariable int userId) {

            List<Post> foundPosts = new ArrayList<>();

            for (Post post : posts) {
                if (post.getUserId() == userId) {
                    foundPosts.add(post);
                }
            }

            return foundPosts;
        }

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

            Post foundPost = new Post();

            for (Post post : posts) {
                if (post.getPostId() == postId) {
                    post.setPostDisabled(true);
                    foundPost = post;
                }
            }

            return foundPost;
        }

}
