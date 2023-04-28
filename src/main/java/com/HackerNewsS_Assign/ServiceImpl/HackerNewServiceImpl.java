package com.HackerNewsS_Assign.ServiceImpl;

import com.HackerNewsS_Assign.Entity.Story;
import com.HackerNewsS_Assign.HackerNewsClient.HackerNewsClient;
import com.HackerNewsS_Assign.Repository.StoryRepository;
import com.HackerNewsS_Assign.Response.HackerNewsStoryResponse;
import com.HackerNewsS_Assign.Service.HackerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HackerNewServiceImpl implements HackerNewService {

    @Autowired
    StoryRepository storyRepository;

    @Override
    public List<Story> getTopStory() {
       HackerNewsClient hackerNewsClient = new HackerNewsClient(storyRepository);
       return hackerNewsClient.getTopStories();
    }
}
