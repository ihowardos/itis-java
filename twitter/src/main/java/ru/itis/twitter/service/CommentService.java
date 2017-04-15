package ru.itis.twitter.service;

import ru.itis.twitter.model.Comment;

import java.util.Set;

public interface CommentService {
    Set<Comment> findByTwitId(long id);
    Comment findOne(long id);
    void save(Comment comment);
    void deleteComment(Comment comment);
}
