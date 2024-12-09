package com.blog.blog.services.implementation;


import com.blog.blog.entity.News;
import com.blog.blog.repositories.NewsRepository;
import com.blog.blog.services.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News saveNews(News news) {
        news.setLikeCount(0);
        news.setViewCount(0);
        news.setDatePosted(new Date());

        return newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            News news =  optionalNews.get();
            news.setViewCount(news.getViewCount() + 1);
            return newsRepository.save(news);
        } else {
            throw new EntityNotFoundException("News Not Found");
        }
    }

    @Override
    public void likePost(Long newsId) {
        Optional<News> optionalNews = newsRepository.findById(newsId);
        if (optionalNews.isPresent()) {
            News news = optionalNews.get();
            news.setLikeCount(news.getLikeCount() + 1);
            newsRepository.save(news);
        } else {
            throw new EntityNotFoundException("News Not Found with ID: " + newsId);
        }
    }

    @Override
    public List<News> seearchByTitle(String title) {
        return newsRepository.findByTitleContaining(title);
    }
}
