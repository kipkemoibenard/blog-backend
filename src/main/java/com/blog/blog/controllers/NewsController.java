package com.blog.blog.controllers;

import com.blog.blog.entity.News;
import com.blog.blog.services.NewsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> postNews(@RequestBody News news) {
        try {
            News postedNews = newsService.saveNews(news);
            return ResponseEntity.ok(postedNews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @GetMapping("/all-news")
//    public ResponseEntity<List<News>> getAllNews() {
//        List<News> newsList = newsService.getAllNews(); // Assuming this returns List<News>
//        return ResponseEntity.ok(newsList); // Wrap the list in ResponseEntity
//    }

    @GetMapping("/all-news")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> allNews = newsService.getAllNews();
        if (allNews == null || allNews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allNews);
    }

    @GetMapping("/{newsId}")
    public ResponseEntity<?> getNewsById(@PathVariable Long newsId) {
        try {
            News news = newsService.getNewsById(newsId);
            return ResponseEntity.ok(news);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{newsId}/like")
    public ResponseEntity<?> likeNews(@PathVariable Long newsId) {
        try {
            newsService.likePost(newsId);
            return ResponseEntity.ok(new String[]{"Post Liked successfully."});
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchNewsByTitle(@PathVariable String title) {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(newsService.seearchByTitle(title));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
