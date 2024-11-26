package Capstone.SpringWebRoute.Models;

import jakarta.persistence.*;

@Entity
public class Follow {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int followId;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserPage follower;


    @ManyToOne
    @JoinColumn(name = "followed_id")
    private UserPage followed;

    public Follow(UserPage follower, UserPage followed) {
        this.follower = follower;
        this.followed = followed;
    }

    public Follow() {

    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public UserPage getFollower() {
        return follower;
    }

    public void setFollower(UserPage follower) {
        this.follower = follower;
    }

    public UserPage getFollowed() {
        return followed;
    }

    public void setFollowed(UserPage followed) {
        this.followed = followed;
    }
}
