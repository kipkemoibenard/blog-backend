package com.blog.blog.services;

import com.blog.blog.entity.News;

import java.util.List;

public interface NewsService {

    News saveNews(News news);

    List<News> getAllNews();

    News getNewsById(Long id);

    void likePost(Long newsId);

    List<News> seearchByTitle(String title);
}
