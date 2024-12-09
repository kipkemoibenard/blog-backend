//package com.blog.blog.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Date;
//
//@Entity
//@Data
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//
//    private String commentText;
//
//    private String author;
//
//    private Date commentDate;
//
//    @ManyToOne
//    @JoinColumn(name = "news_id", nullable = false)
//    private News news;
//}

package com.blog.blog.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;

    private String author;

    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for commentText
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for commentDate
    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    // Getter and Setter for news
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}

