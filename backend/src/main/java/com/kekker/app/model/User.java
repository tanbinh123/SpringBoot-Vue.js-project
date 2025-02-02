package com.kekker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    private String nickName; // user's id -> must me unique

    @NotNull

    @Size(max=100)
    private String email; // also unique

    @NotNull
    @Size(max = 128)
    private String password;

    @NotNull
    @Size(max=120)
    private String firstName;

    @NotNull
    @Size(max=120)
    private String lastName;

    private String avatarUrl;

    @Size(max = 120)
    private String bio;

    @Size(max = 15)
    @Column
    private String gender;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Kek> keks;   // array of all written keks by user

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Comment> comments;   // array of all written comments by user

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reaction> reactions;   // array of all reactions set by user

    // following_nickName - user you are following
    // user_nickName - you
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userFollowers", joinColumns = {
            @JoinColumn(name = "following_nickName", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "user_nickName", nullable = false)})
    @JsonIgnore
    private Set<User> userFollowers;   // array of all written comments by user

   /* @ManyToMany(mappedBy = "userFollowers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> friends;*/

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Kek> getKeks() {
        return keks;
    }

    public void setKeks(Set<Kek> keks) {
        this.keks = keks;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Set<User> getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(Set<User> userFollowers) {
        this.userFollowers = userFollowers;
    }

}
