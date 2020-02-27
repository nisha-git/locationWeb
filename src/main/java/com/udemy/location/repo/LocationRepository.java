package com.udemy.location.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udemy.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	@Query("select type,count(*) from Location group by type")
	public List<Object[]> getDataOfLOcationType();
}
