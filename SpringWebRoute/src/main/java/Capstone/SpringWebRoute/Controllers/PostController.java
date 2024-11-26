package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.Userlike;
import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Service.LikeService;
import Capstone.SpringWebRoute.Service.PostService;
import Capstone.SpringWebRoute.Service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

    public List<Post> posts = new ArrayList<>();

    @Autowired
    PostService postSer;

    @Autowired
    UserPageService userSer;

    @Autowired
    LikeService likeSer;

    @PostMapping("/AddPost/{pageId}/{username}")
    public Post addPost(@PathVariable int pageId,@PathVariable String username ,@RequestBody Post newPost) {

        newPost.setUserPageId(pageId);
        newPost.setPostDate(addDate());
        newPost.setUsername(username);
        postSer.save(newPost);
        UserPage foundUser = userSer.findSingleUserPageByUsername(username);
        foundUser.setNumberOfPosts(foundUser.getNumberOfPosts() + 1);
        return newPost;
    }

    public Date addDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date curentDate = new Date();
        return curentDate;
    }

    @GetMapping("/GetAllPosts")
    public List<Post> getAllPosts() {
        return postSer.getAllPosts();
    }

    @GetMapping("/GetPost/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postSer.getPostById(postId);
    }


    @GetMapping("/GetPostsByPageId/{pageId}")
    public List<Post> getPostsByUserId(@PathVariable int pageId) {

        return postSer.getAllPostsByUserId(pageId);
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

    @PutMapping("/likePost/{pageId}/{postId}")
    public String likedPost(@PathVariable int pageId, @PathVariable int postId) {
        Post currentPost = postSer.getPostById(postId);
        UserPage currentPage = userSer.findUserPageById(pageId);
        Userlike newLike = new Userlike(currentPage.getUsername(), pageId, currentPost);
        currentPost.getLikes().add(newLike);
        return postSer.addLike(currentPage, currentPost, newLike);
    }

    @PutMapping("/removeLike/{pageId}/{postId}")
    public String removedLike(@PathVariable int pageId, @PathVariable int postId) {
        Post currentPost = postSer.getPostById(postId);
        UserPage currentPage = userSer.findUserPageById(pageId);
        Userlike currentLike = likeSer.findByUsername(currentPage.getUsername());
        return postSer.removeLike(currentPage, currentPost, currentLike);
    }

    @GetMapping("/{pageId}/liked/{postId}")
    public Boolean userLiked(@PathVariable int pageId, @PathVariable int postId) {
        Userlike foundLike = likeSer.findLikeByIdAndPageId(pageId, postId);
        System.out.println(foundLike);
        return foundLike != null;
    }

    @PutMapping("/DeletePost/{postId}")
    public Post deletePost(@PathVariable int postId) {

        Post currentPost = postSer.getPostById(postId);

        currentPost.setPostDisabled(true);

        return currentPost;
    }

}
