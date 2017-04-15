package ru.itis.twitter.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.twitter.model.Twit;

import java.util.Set;

public interface TwitDao extends CrudRepository<Twit, Long> {
    Set<Twit> findByUserId(long id);
}
