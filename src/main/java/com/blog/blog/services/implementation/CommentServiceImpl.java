package com.blog.blog.services.implementation;

import com.blog.blog.entity.Comment;
import com.blog.blog.entity.News;
import com.blog.blog.repositories.CommentRepository;
import com.blog.blog.repositories.NewsRepository;
import com.blog.blog.services.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;

    public CommentServiceImpl(CommentRepository commentRepository, NewsRepository newsRepository) {
        this.commentRepository = commentRepository;
        this.newsRepository = newsRepository;
    }

    @Override
    public Comment createComment(Long newsId, String author, String comment_text) {
        Optional<News> news = newsRepository.findById(newsId);
        if(news.isPresent()) {
            Comment comment = new Comment();

            comment.setNews(news.get());
            comment.setCommentText(comment_text);
            comment.setAuthor(author);
            comment.setCommentDate(new Date());

            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException("News not found");
    }

    @Override
    public List<Comment> getCommentByNewsId(Long newsId) {
        return commentRepository.findCommentByNewsId(newsId);
    }
}
