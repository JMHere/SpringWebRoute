package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.Userlike;
import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Repository.LikeRepository;
import Capstone.SpringWebRoute.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepo;

    @Autowired
    LikeRepository likeRepo;

    public Post getPostById(int postId) {
        return postRepo.findById(postId).get();
    }

    public List<Post> getAllPostsByUserId(int pageId) {
        return postRepo.findPostsByUserPageId(pageId);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post save(Post post) {
        postRepo.save(post);
        return post;
    }

    public String addLike(UserPage userPage, Post post, Userlike like) {
        likeRepo.save(like);
        postRepo.save(post);

        return userPage.getUsername() + " liked your post";
    }

    public String removeLike(UserPage userPage, Post post, Userlike like) {
        post.getLikes().remove(like);
        postRepo.save(post);

        return userPage.getUsername() + " removed their like";
    }



}
