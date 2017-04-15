package ru.itis.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.twitter.model.Twit;
import ru.itis.twitter.repository.TwitDao;

import java.util.Set;

@Service
@Transactional
public class TwitServiceImpl implements TwitService {

    @Autowired
    TwitDao twitDao;

    @Override
    public Set<Twit> findByUserId(long id) {
        return twitDao.findByUserId(id);
    }

    @Override
    public Twit saveTwit(Twit twit) {
        return twitDao.save(twit);
    }

    @Override
    public Twit findOne(long id) {
        return twitDao.findOne(id);
    }

    @Override
    public void deleteById(long id) {
        twitDao.delete(id);
    }
}
