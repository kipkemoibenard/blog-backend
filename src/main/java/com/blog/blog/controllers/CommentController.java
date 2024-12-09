package com.blog.blog.controllers;

import com.blog.blog.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @PostMapping("/text")
//    public ResponseEntity<?> createComment(@RequestParam Long newsId, @RequestParam String author, @RequestBody String commentText) {
//        try {
//            return  ResponseEntity.ok(commentService.createCComment(newsId, author, commentText));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
//        }
//    }
@PostMapping("/text")
public ResponseEntity<?> createComment(
        @RequestParam Long newsId,
        @RequestParam String author,
        @RequestBody Map<String, String> requestBody) {
    try {
        String commentText = requestBody.get("commentText"); // Extract the commentText
        return ResponseEntity.ok(commentService.createComment(newsId, author, commentText));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }
}

@GetMapping("/text/{newsId}")
public ResponseEntity<?> getCommentByNewsId(@PathVariable Long newsId) {
        try {
            return ResponseEntity.ok(commentService.getCommentByNewsId(newsId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
}

}
