package ru.itis.twitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.twitter.model.Twit;
import ru.itis.twitter.model.User;
import ru.itis.twitter.model.UserProfile;
import ru.itis.twitter.service.TwitService;
import ru.itis.twitter.service.UserProfileService;
import ru.itis.twitter.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@SessionAttributes("roles")
public class UserController {

	@Autowired
    UserService userService;
	
	@Autowired
    UserProfileService userProfileService;

	@Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

	@Autowired
	TwitService twitService;

	@RequestMapping(value = "/")
	public String welcome(ModelMap model) {
		model.addAttribute("username", getPrincipal());
		return "app/welcome";
	}


	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("username", getPrincipal());
		return "user/index";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.addObject("username", getPrincipal());
		modelAndView.addObject("isRegistrationPage", true);
		modelAndView.setViewName("user/new");
		return modelAndView;

	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		if (userService.isUserLoginUnique(user.getLogin()) && userService.isUserEmailUnique(user.getEmail())) {
			Set<UserProfile> userProfiles = new HashSet<>();
			userProfiles.add(userProfileService.findByType("USER"));
			user.setUserProfiles(userProfiles);
			userService.saveUser(user);
			modelAndView.setViewName("security/login");
		} else modelAndView.setViewName("user/new");
		return modelAndView;
	}

	@RequestMapping(value = { "/{login}/edit" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String login, ModelMap model) {
		if (!login.equals(getPrincipal())) {
			return "user/index";
		}
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		model.addAttribute("username", getPrincipal());
		return "user/edit";
	}

	@Transactional
	@RequestMapping(value = { "/{login}/edit" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String login) {

		if (result.hasErrors()) {
			return "user/edit";
		}


		userService.updateUser(user.getEmail(), user.getId());

		model.addAttribute("username", getPrincipal());
		return "redirect:/${login}";
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showUser(@PathVariable String login, ModelMap modelMap) {
		Twit twit = new Twit();
		User user = userService.findByLogin(login);
		if (user == null) {
			return "app/welcome";
		}
		Set<Twit> twits = twitService.findByUserId(user.getId());
		user.setTwits(twits);
		modelMap.addAttribute("twit", twit);
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("username", getPrincipal());
		return "user/show";
	}


	@RequestMapping(value = { "/admin/delete/{login}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String login) {
		userService.deleteUserByLogin(login);
		return "redirect:/list";
	}
	

	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("username", getPrincipal());
		return "app/accessDenied";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "security/login";
	    } else {
	    	return "redirect:/list";  
	    }
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			//persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}


	private String getPrincipal(){
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = "Guest";
		}
		return username;
	}
	

	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}