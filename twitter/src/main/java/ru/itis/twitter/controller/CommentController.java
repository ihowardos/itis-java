package ru.itis.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.twitter.helper.Helper;
import ru.itis.twitter.model.Comment;
import ru.itis.twitter.service.CommentService;
import ru.itis.twitter.service.TwitService;
import ru.itis.twitter.service.UserService;

@Controller
public class CommentController {

    @Autowired
    Helper helper;

    @Autowired
    CommentService commentService;

    @Autowired
    TwitService twitService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{login}/{id}/comment", method = RequestMethod.POST)
    public String newComment(@PathVariable String login, @PathVariable long id, @ModelAttribute Comment comment) {
        comment.setUser(userService.findByLogin(login));
        comment.setTwit(twitService.findOne(id));
        commentService.save(comment);
        return "redirect:/{login}/{id}";
    }

    @RequestMapping(value = "/{login}/{twitId}/{commentId}/delete", method = RequestMethod.GET)
    public String deleteComment(@PathVariable String login, @PathVariable long twitId, @PathVariable long commentId) {
        if (commentService.findOne(commentId) == null) {
            System.out.println("comment null");
            return "redirect:/{login}/{twitId}";
        }

        if (!commentService.findOne(commentId).getUser().getLogin().equals(helper.getPrincipal())) {
            System.out.println(commentService.findOne(commentId).getUser().getLogin());
            System.out.println(helper.getPrincipal());
            System.out.println("not equals");
            return "redirect:/{login}/{twitId}";
        }

        System.out.println("ready...");
        commentService.deleteComment(commentService.findOne(commentId));
        System.out.println("perfect!");
        return "redirect:/{login}/{twitId}";
    }
}
