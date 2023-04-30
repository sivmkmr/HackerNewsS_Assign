package com.HackerNewsS_Assign.Controller;

import com.HackerNewsS_Assign.Entity.Story;
import com.HackerNewsS_Assign.Service.HackerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HackerNewsController {

	@Autowired
	private HackerNewService hackerNewService;
	
	@GetMapping("/top-stories")
	public List<Story> getTopStories()
	{
		return hackerNewService.getTopStory();
	}
	
	@GetMapping("/past-stories")
	public String getPastStrories()
	{
		return "poststories";
	}
	
	@GetMapping("/comments")
	public String getComments()
	{
		return "getcomments";
	}

	
}
