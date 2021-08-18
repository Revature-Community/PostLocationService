package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PinStatus;
import com.revature.models.Posts;
import com.revature.repositories.PinStatusRepository;
import com.revature.repositories.PostsRepository;

@Service
public class PostsService {

	@Autowired
	PostsRepository postsRepository;
	
	@Autowired
	PinStatusRepository pinStatusRepository;

	public List<Posts> getAllPost() {

		List<Posts> postsList = postsRepository.findAllSortedByDate();
		
		return postsList;

	}

	public Posts addPost(Posts post) {

		Posts newPost = postsRepository.save(post);

		return newPost;

	}

	public List<Posts> getPostsByLocationId(int locationId) {
        List<Posts> postsByLocationId = postsRepository.getPostsByLocationId(locationId);
        return postsByLocationId;
    }

	public Posts updatePinStatus(String pinStatus, Posts post) {
		PinStatus chosenPinStatus = pinStatusRepository.findPinByStatus(pinStatus);
		Posts updatedPost = postsRepository.updatePinStatus(chosenPinStatus.getId(), post.getId());
		return updatedPost;
	}

	public void updateActiveState(Posts post) {
		postsRepository.updateActiveState(post.getId());
		
	}
}
