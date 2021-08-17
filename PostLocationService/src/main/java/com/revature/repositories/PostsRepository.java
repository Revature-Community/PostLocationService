package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	@Query(value = "SELECT * FROM post WHERE post.location_id = :locationId AND active_state = true ORDER BY date DESC", nativeQuery = true)
    List<Posts> getPostsByLocationId(@Param("locationId") int locationId);
	
	@Query(value = "SELECT * FROM post WHERE active_state = true ORDER BY date DESC", nativeQuery = true)
	List<Posts> findAllSortedByDate();
}
