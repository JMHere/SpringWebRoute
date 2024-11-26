package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Service.FollowService;
import Capstone.SpringWebRoute.Service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserPage")
public class UserPageController {

    public List<UserPage> userPages = new ArrayList<>();

    @Autowired
    UserPageService userPSer;

    @Autowired
    FollowService followSer;

    @GetMapping("/UID/{userId}")
    public UserPage getUserPageByUserID(@PathVariable int userId) {
        return userPSer.findUserPageByUserId(userId);
    }

    @GetMapping("/PID/{pageId}")
    public UserPage getUserPageByID(@PathVariable int pageId) {
        return userPSer.findUserPageById(pageId);
    }

    @GetMapping("/GetAllPages")
    public List<UserPage> getAllUserPages() {
        return userPSer.getAllUserPages();
    }

    @GetMapping("/GetByUserName/{username}")
    public List<UserPage> getPagesByUsername(@PathVariable String username) {
        return userPSer.findUserPageByUsername(username);
    }

    @PutMapping("/DisablePage/{pageId}")
    public String disablePage(@PathVariable int pageId) {

        UserPage currentUserPage = userPSer.findUserPageById(pageId);
        currentUserPage.setDisabled(true);
        userPSer.save(currentUserPage);

        return "Page does Not exist";
    }

    @PutMapping("/ChangePFP/{pageId}")
    public void updatedPFP(@PathVariable int pageId, @RequestBody UserPage updatedUserPage) {

        UserPage currentUserPage = userPSer.findUserPageById(pageId);
        currentUserPage.setProfilePicture(updatedUserPage.getProfilePicture());
        userPSer.save(currentUserPage);
    }

    @PutMapping("/UpdateBio/{pageId}")
    public void updateBio(@PathVariable int pageId, @RequestBody UserPage updatedUserPage) {

        UserPage currentUserPage = userPSer.findUserPageById(pageId);
        currentUserPage.setBio(updatedUserPage.getBio());
        userPSer.save(currentUserPage);

    }

    @PostMapping("/{followerId}/follow/{followedId}")
    public String follow(@PathVariable int followerId, @PathVariable int followedId) {
        UserPage foundUser = userPSer.findUserPageById(followedId);
        foundUser.setNumberOfFollowers(foundUser.getNumberOfFollowers() + 1);
        return followSer.followUser(followerId, followedId);
    }

    @PostMapping("/{followerId}/unfollow/{followedId}")
    public String unfollow(@PathVariable int followerId, @PathVariable int followedId) {
        UserPage foundUser = userPSer.findUserPageById(followedId);
        foundUser.setNumberOfFollowers(foundUser.getNumberOfFollowers() - 1);
        return followSer.unFollowUser(followerId, followedId);
    }

    @GetMapping("/checkFollow/{followerId}/{followedId}")
    public boolean checkFollow(@PathVariable int followerId, @PathVariable int followedId) {
        return followSer.checkFollow(followerId, followedId);
    }

}
