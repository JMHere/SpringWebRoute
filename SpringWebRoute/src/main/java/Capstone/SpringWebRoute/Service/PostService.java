package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.Post;
import Capstone.SpringWebRoute.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepo;

    public Post getPostById(int postId) {
        return postRepo.findById(postId).get();
    }

    public List<Post> getAllPostsByUserId(int userId) {
        return postRepo.findPostsByUserId(userId);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post save(Post post) {
        postRepo.save(post);
        return post;
    }



}
