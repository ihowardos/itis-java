package ru.itis.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.twitter.model.Comment;
import ru.itis.twitter.repository.CommentDao;

import java.util.Set;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public Set<Comment> findByTwitId(long id) {
        return commentDao.findByTwitId(id);
    }

    @Override
    public Comment findOne(long id) {
        return commentDao.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Comment comment) {
        commentDao.delete(comment);
    }
}
