package Capstone.SpringWebRoute.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Userlike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeId;
    private String username;
    private int pageId;
    @JsonIgnore
    @ManyToOne
    private Post post;


    public Userlike(String username, int pageId, Post post) {
        this.username = username;
        this.pageId = pageId;
        this.post = post;
    }

    public Userlike() {

    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
