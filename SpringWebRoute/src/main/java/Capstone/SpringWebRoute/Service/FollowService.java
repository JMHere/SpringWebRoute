package Capstone.SpringWebRoute.Service;

import Capstone.SpringWebRoute.Models.Follow;
import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Repository.FollowRepository;
import Capstone.SpringWebRoute.Repository.UserPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    UserPageRepository userPRepo;

    @Autowired
    FollowRepository followRepo;

    public String followUser(int followerId, int followedId) {
        UserPage follower = userPRepo.findUserPageByUserID(followerId);
        UserPage followed = userPRepo.findUserPageByUserID(followedId);

        if(follower == null || followed == null) {
            return "User(s) do not found";
        }

        if (followRepo.existsByFollowerAndFollowed(follower, followed)) {
            return "You are already following this User";
        }

        Follow follow = new Follow(follower, followed);
        followRepo.save(follow);

        follower.getFollowing().add(follow);
        followed.getFollowers().add(follow);

        userPRepo.save(follower);
        userPRepo.save(followed);

        return "You are now following this user.";
    }

    public String unFollowUser(int followerId, int followedId) {
        UserPage follower = userPRepo.findUserPageByUserID(followerId);
        UserPage followed = userPRepo.findUserPageByUserID(followedId);

        if(follower == null || followed == null) {
            return "User(s) do not found";
        }

        Follow follow = followRepo.findByFollowerAndFollowed(follower, followed);

        if (follow != null) {
            followRepo.delete(follow);

            follower.getFollowing().remove(follow);
            followed.getFollowers().remove(follow);

            userPRepo.save(follower);
            userPRepo.save(followed);

            return "You have unfollowed the user.";
        }

        return "You are not following this user.";
    }

    public boolean checkFollow(int followerId, int followedId) {
        UserPage follower = userPRepo.findUserPageByUserID(followerId);
        UserPage followed = userPRepo.findUserPageByUserID(followedId);

        Follow follow = followRepo.findByFollowerAndFollowed(follower, followed);

        return follow != null;
    }
}
