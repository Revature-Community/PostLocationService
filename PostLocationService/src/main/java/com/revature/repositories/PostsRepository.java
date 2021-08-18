package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
	@Query(value = "SELECT * FROM post WHERE post.location_id = :locationId AND active_state = true ORDER BY pin_status_id DESC, date DESC", nativeQuery = true)
    List<Posts> getPostsByLocationId(@Param("locationId") int locationId);
	
	@Query(value = "SELECT * FROM post WHERE active_state = true ORDER BY pin_status_id ASC,date DESC", nativeQuery = true)
	List<Posts> findAllSortedByDate();

	@Query(value="UPDATE post SET pin_status_id = :pinStatusId WHERE post_id = :postId RETURNING *", nativeQuery = true)
	Posts updatePinStatus(@Param("pinStatusId") int pinStatusId, @Param("postId") int postId);
	
	@Query(value="UPDATE post SET active_state = false WHERE post_id = :id RETURNING *", nativeQuery = true)
	Posts updateActiveState(@Param("id") int id);
}
