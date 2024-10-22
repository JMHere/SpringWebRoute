package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
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

    @PutMapping("/DisablePage/{pageId}")
    public String disablePage(@PathVariable int pageId) {

        UserPage currentUserPage = userPSer.findUserPageById(pageId);
        currentUserPage.setDisabled(true);
        userPSer.save(currentUserPage);

        return "Page does Not exist";
    }

//    @PostMapping("/CreatePage/{userId}")
//    public String createUserPage(@PathVariable int userId, @RequestBody UserPage newUserPage) {
//
//        newUserPage.setUserId(userId);
//
//        userPages.add(newUserPage);
//
//        return "UserPage Created";
//    }

    @PutMapping("/ChangePFP/{pageId}")
    public String updatedPFP(@PathVariable int pageId, @RequestBody UserPage updatedUserPage) {


        UserPage currentUserPage = userPSer.findUserPageById(pageId);
        currentUserPage.setProfilePicture(updatedUserPage.getProfilePicture());
        userPSer.save(currentUserPage);

//        for( UserPage page : userPages) {
//            if (page.getPageId() == pageId) {
//                page.setProfilePicture(updatedUserPage.getProfilePicture());
//            }
//        }
//
//
//
//        for (UserPage page : userPages) {
//            System.out.println(page.getPageId());
//        }

        return "userPage updated";
    }

}
