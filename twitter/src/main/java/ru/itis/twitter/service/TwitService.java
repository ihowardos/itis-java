package ru.itis.twitter.service;

import ru.itis.twitter.model.Twit;

import java.util.Set;

public interface TwitService {
    Set<Twit> findByUserId(long id);
    Twit saveTwit(Twit twit);
    Twit findOne(long id);
    void deleteById(long id);
}
