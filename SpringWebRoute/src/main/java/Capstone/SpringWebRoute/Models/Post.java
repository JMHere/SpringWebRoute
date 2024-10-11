package Capstone.SpringWebRoute.Models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    private int postId;
    private String postImage;
    private String postText;
    private String postDescription;
    @OneToMany
    private List<Comment> comments;
    private int UserId;
    private int UserPageId;
    private int postLikes;
    private int postShares;
    private Date postDate;
    private boolean postDisabled;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getUserPageId() {
        return UserPageId;
    }

    public void setUserPageId(int userPageId) {
        UserPageId = userPageId;
    }

    public int getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(int postLikes) {
        this.postLikes = postLikes;
    }

    public int getPostShares() {
        return postShares;
    }

    public void setPostShares(int postShares) {
        this.postShares = postShares;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isPostDisabled() {
        return postDisabled;
    }

    public void setPostDisabled(boolean postDisabled) {
        this.postDisabled = postDisabled;
    }
}
