package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.PinStatus;

public interface PinStatusRepository extends JpaRepository<PinStatus, Integer> {

	@Query(value="SELECT * FROM pin_status WHERE pin_status.pin_status = :pinStatus", nativeQuery = true)
	PinStatus findPinByStatus(@Param("pinStatus") String pinStatus);

}
