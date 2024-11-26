package Capstone.SpringWebRoute.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.source.tree.ForLoopTree;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class UserPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pageId;
    private String bio;

    @Column(columnDefinition = "LONGTEXT")
    private String profilePicture;
    private String username;
    private int numberOfFollowers;
    private int numberOfFollowing;
    private int numberOfPosts;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date pageDate;
    @JsonIgnore
    @OneToMany(mappedBy = "followed")
    private List<Follow> followers;
    @JsonIgnore
    @OneToMany(mappedBy = "follower")
    private List<Follow> following;
    private boolean disabled;

    public UserPage() {

    }

    public UserPage( String userName) {
        this.username = userName;
    }

    public UserPage(String userName, User user) {
        this.username = userName;
        this.user = user;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public int getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(int numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public Date getPageDate() {
        return pageDate;
    }

    public void setPageDate(Date pageDate) {
        this.pageDate = pageDate;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void showFollowers() {
        for (Follow follow : followers) {
            System.out.println(follow.getFollowed().getUsername());
        }
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
