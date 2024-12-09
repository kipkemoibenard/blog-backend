package com.blog.blog.entity;

//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Data
//public class News {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//
//    private String title;
//
//    private String content;
//
//    private String postedBy;
//
//    private String image;
//
//    private Date datePosted;
//
//    private int likeCount;
//
//    private int viewCount;
//
//    @ElementCollection
////    @CollectionTable(name = "news_tags")
////    @Column(name = "tag")
//    private List<String> tags;
//}

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String content;

    private String postedBy;

    private String image;

    private Date datePosted;

    private int likeCount;

    private int viewCount;

    @ElementCollection
    private List<String> tags;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

