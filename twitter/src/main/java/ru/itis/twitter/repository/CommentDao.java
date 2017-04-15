package ru.itis.twitter.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.twitter.model.Comment;

import java.util.Set;

public interface CommentDao extends CrudRepository<Comment, Long> {

    Set<Comment> findByTwitId(long id);

}

