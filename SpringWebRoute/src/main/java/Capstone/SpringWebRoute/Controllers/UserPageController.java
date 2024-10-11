package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserPage")
public class UserPageController {

    public List<UserPage> userPages = new ArrayList<>();

    @GetMapping("/UID/{userId}")
    public UserPage getUserPageByUserID(@PathVariable int userId) {

        for(UserPage userP : userPages) {
            System.out.println(userP.getUserId());

            if (userP.getUserId() == userId) {

                return userP;
            }
        }
        UserPage nullUser = new UserPage();
        nullUser.setBio("Null User");

        return nullUser;
    }

    @GetMapping("/PID/{pageId}")
    public UserPage getUserPageByID(@PathVariable int pageId) {

        for(UserPage userP : userPages)  {

            if (userP.getPageId() == pageId) {

                return userP;
            }
        }
        UserPage nullUser = new UserPage();
        nullUser.setBio("Null User");

        return nullUser;

    }

    @GetMapping("/GetAllPages")
    public List<UserPage> getAllUserPages() {
        return userPages;
    }

    @PutMapping("/DisablePage/{pageId}")
    public String disablePage(@PathVariable int pageId) {

        for (UserPage userP : userPages) {
            if (userP.getPageId() == pageId) {
                userP.setDisabled(true);
                return "Page has Been Disabled";
            }
        }

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



        for( UserPage page : userPages) {
            if (page.getPageId() == pageId) {
                page.setProfilePicture(updatedUserPage.getProfilePicture());
            }
        }



        for (UserPage page : userPages) {
            System.out.println(page.getPageId());
        }

        return "userPage updated";
    }

}
