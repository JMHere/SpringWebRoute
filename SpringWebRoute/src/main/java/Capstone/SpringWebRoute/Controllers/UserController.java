package Capstone.SpringWebRoute.Controllers;

import Capstone.SpringWebRoute.Models.User;
import Capstone.SpringWebRoute.Models.UserPage;
import Capstone.SpringWebRoute.Service.UserPageService;
import Capstone.SpringWebRoute.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    public List<User> Users = new ArrayList<>();

    @Autowired
    private UserService userSer;

    @Autowired
    private UserPageService pageSer;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userSer.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
            User result = userSer.findUserById(1);
            return result;
    }

    @GetMapping("/CheckUsername/{username}")
    public Boolean getUserById(@PathVariable String username) {
        User result = userSer.findUserByUsername(username);

        boolean valid = result != null;

        System.out.println(valid);
        System.out.println("Brains");

        return valid;
    }

    @GetMapping("/{userName}/{passWord}")
    public User getUserByCred(@PathVariable String userName,@PathVariable String passWord) {
        User user = userSer.findUserWithCred(userName, passWord);
        return user;
    }

    @PostMapping("/AddUser")
    public User addNewUser(@RequestBody User newUser) {
        userSer.save(newUser);
        UserPage newPage = new UserPage(newUser.getUsername(), newUser);
        newPage.setPageDate(addDate());
        //newUser.setUserPage(newPage);
        pageSer.save(newPage);

        // Create User Page When A new User is created
        //UserPage userPage = new UserPage( 1, newUser.getUserName(), newUser.getUserId());

        return newUser;
    }

    public Date addDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date curentDate = new Date();
        return curentDate;
    }

    @PutMapping("/DeleteUser/{id}")
    public String deleteUser(@PathVariable int id) {

        String userName = "";

        User user = userSer.delete(id);
        userName = user.getUsername();
        user.setDeleted(true);

        userSer.save(user);

//        for(User user : Users) {
//            if (user.getUserId() == id) {
//                user.setDeleted(true);
//                userName = user.getUserName();
//            }
//        }
//
//        if (userName == "") {
//            return "User was not found";
//        }

        return "User " + userName + " has been deleted";
    }

    @PutMapping("/RestoreUser/{userId}")
    public String restoreUser(@PathVariable int userId) {

        String userName = "";
        User user = userSer.findUserById(userId);
        userName = user.getUsername();
        user.setDeleted(false);
        userSer.save(user);

        return "User " + userName + " has been restored";

    }


    @RequestMapping(value = "/UpdateUser/{id}", method = RequestMethod.PUT)
    public User UpdateUserInfo(@PathVariable int id, @RequestBody User upUser) {

        User foundUser = userSer.findUserById(id);
        System.out.println(foundUser);
        foundUser.setEmail(upUser.getEmail());
        foundUser.setPassword(upUser.getPassword());
        userSer.save(foundUser);



//        for (User user : Users) {
//            if (user.getUserId() == id) {
//                user.setUserId(newUserInfo.getUserId());
//                user.setUserName(newUserInfo.getUserName());
//                user.setEmail(newUserInfo.getEmail());
//                user.setPassWord(newUserInfo.getPassWord());
//                user.setUserPageId(newUserInfo.getUserPageId());
//                user.setDeleted(newUserInfo.isDeleted());
//                userName = user.getUserName();
//            }
//        }

        return foundUser;
    }

}
