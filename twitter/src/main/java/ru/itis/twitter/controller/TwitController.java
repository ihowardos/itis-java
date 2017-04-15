package ru.itis.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.twitter.helper.Helper;
import ru.itis.twitter.model.Comment;
import ru.itis.twitter.model.Twit;
import ru.itis.twitter.model.User;
import ru.itis.twitter.service.CommentService;
import ru.itis.twitter.service.TwitService;
import ru.itis.twitter.service.UserService;

import java.util.Set;

@Controller
public class TwitController {

    @Autowired
    private UserService userService;

    @Autowired
    private TwitService twitService;

    @Autowired
    private CommentService commentService;

    @Autowired
    Helper helper;

    @RequestMapping(value = "/{login}/twit", method = RequestMethod.POST)
    public String newTwit(@PathVariable String login, @ModelAttribute Twit twit) {
        if (!login.equals(helper.getPrincipal())) {
            return "redirect:/welcome";
        }
        User user = userService.findByLogin(login);
        twit.setUser(user);
        twitService.saveTwit(twit);
        return "redirect:/{login}";
    }

    @RequestMapping(value = "/{login}/{id}", method = RequestMethod.GET)
    public String showTwit(@PathVariable long id, @PathVariable String login, ModelMap modelMap) {
        Comment comment = new Comment();
        User user = userService.findByLogin(login);
        Twit twit = twitService.findOne(id);
        Set<Comment> comments = commentService.findByTwitId(id);
        modelMap.addAttribute("comments", comments);
        modelMap.addAttribute("twit", twit);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("comment", comment);
        modelMap.addAttribute("username", helper.getPrincipal());
        return "twit/show";
    }

    @RequestMapping(value = "/{login}/{id}/delete")
    public String deleteTwit(@PathVariable long id, @PathVariable String login, ModelMap modelMap) {
        if (twitService.findOne(id) == null) {
            return "redirect:/{login}";
        }

        if (!twitService.findOne(id).getUser().equals(helper.getPrincipal())) {
            return "redirect:/{login}";
        }
        twitService.deleteById(id);
        return "redirect:/{login}";
    }
}
