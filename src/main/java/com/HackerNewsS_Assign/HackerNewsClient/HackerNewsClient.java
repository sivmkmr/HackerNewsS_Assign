package com.HackerNewsS_Assign.HackerNewsClient;

import java.sql.SQLOutput;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.HackerNewsS_Assign.Repository.StoryRepository;
import com.HackerNewsS_Assign.Response.HackerNewsStoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.HackerNewsS_Assign.Entity.Story;

@Component
public class HackerNewsClient
{
    @Autowired
    StoryRepository storyRepository;

    public HackerNewsClient(StoryRepository storyRepository)
    {
        this.storyRepository = storyRepository;
    }

    private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";
    private static final String TOP_STORIES_URL = BASE_URL + "topstories.json";
    private static final String ITEM_URL = BASE_URL + "item/%s.json";

    public List<Story> getTopStories()
    {
        RestTemplate restTemplate = new RestTemplate();
        List<Long> storyList = Arrays.asList(restTemplate.getForObject(TOP_STORIES_URL, Long[].class));
        List<Story> sList = new ArrayList<>();
        storyList = storyList.stream().limit(10).collect(Collectors.toList());
        System.out.println(storyList.size());
        storyList.forEach(id ->{
            HackerNewsStoryResponse storyResponse = new HackerNewsStoryResponse();
            storyResponse = restTemplate.getForObject(String.format(ITEM_URL,id), HackerNewsStoryResponse.class);
            Story story = convertFromResponseToStory(storyResponse);
            sList.add(story);
            System.out.println(sList);
        });

            return storyRepository.saveAll(sList);

    }

    private static Story convertFromResponseToStory(HackerNewsStoryResponse storyResponse) {
    Story story = new Story();
    story.setUrl(storyResponse.getUrl());
    story.setTitle(storyResponse.getTitle());
    story.setUser(storyResponse.getBy());
    story.setScore(storyResponse.getScore());
    story.setTimeOfSubmission(storyResponse.getTime());
    return story;
    }
}
