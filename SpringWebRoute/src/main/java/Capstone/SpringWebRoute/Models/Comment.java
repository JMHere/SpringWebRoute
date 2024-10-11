package Capstone.SpringWebRoute.Models;

import java.util.Date;

public class Comment {

    private int commentId;
    private int userId;
    private int postId;
    private String userName;
    private Date commentDate;
    private String comment;
    private boolean commentDisabled;
    private int commentLikes;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isCommentDisabled() {
        return commentDisabled;
    }

    public void setCommentDisabled(boolean commentDisabled) {
        this.commentDisabled = commentDisabled;
    }

    public int getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(int commentLikes) {
        this.commentLikes = commentLikes;
    }
}
