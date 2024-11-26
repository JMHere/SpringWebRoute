package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.Userlike;
import Capstone.SpringWebRoute.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepo;

    public Userlike findLikeByIdAndPageId(int likeId, int pageId) {
        return likeRepo.findByLikeIdAndPageId(likeId, pageId);
    }

    public Userlike findByUsername(String username) {
        return likeRepo.findByUsername(username);
    }
}
