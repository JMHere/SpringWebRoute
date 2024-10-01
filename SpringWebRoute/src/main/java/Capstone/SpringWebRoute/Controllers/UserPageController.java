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

    @GetMapping("/{userId}")
    public UserPage getUserPage(@PathVariable int userId) {

        for(UserPage userP : userPages) {

            if (userP.getUserId() == userId) {
                return userP;
            }
        }
        UserPage nullUser = new UserPage();

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

    

}
