package com.example.authorization.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String status;

    private String alias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private Avatar avatar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_id", referencedColumnName = "id")
    private Cover cover;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "profile")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "profile_subscriptions",
            joinColumns = {@JoinColumn(name = "subscriber_id") },
            inverseJoinColumns = {@JoinColumn(name = "channel_id") }
    )
    private Set<Profile> subscriptions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "profile_subscriptions",
            joinColumns = {@JoinColumn(name = "channel_id") },
            inverseJoinColumns = {@JoinColumn(name = "subscriber_id") }
    )
    private Set<Profile> subscribers = new HashSet<>();


    public void addAvatar(Avatar avatar) {
        setAvatar(avatar);
        avatar.setProfile(this);
    }

    public void addCover(Cover cover) {
        setCover(cover);
        cover.setProfile(this);
    }
}
