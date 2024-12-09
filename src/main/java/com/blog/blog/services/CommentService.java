package com.blog.blog.services;

import com.blog.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long newsId, String author, String comment_text);

    List<Comment> getCommentByNewsId(Long newsId);
}
