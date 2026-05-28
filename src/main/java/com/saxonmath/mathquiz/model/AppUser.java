package com.saxonmath.mathquiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String displayName;

    /** Either a URL to a profile image or a single emoji character */
    @Column(length = 500)
    private String avatar;

    /** "emoji" or "image" */
    @Column(nullable = false)
    private String avatarType;

    public AppUser() {}

    public AppUser(String username, String password, String displayName, String avatar, String avatarType) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.avatar = avatar;
        this.avatarType = avatarType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public String getAvatarType() { return avatarType; }
    public void setAvatarType(String avatarType) { this.avatarType = avatarType; }
}
