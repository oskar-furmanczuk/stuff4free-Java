package net.oskarfurmanczuk.staff4free.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.oskarfurmanczuk.staff4free.models.Location;
import net.oskarfurmanczuk.staff4free.models.User;

@Repository
public interface LocationRepository extends MongoRepository<Location, String>{
	
	List<Location> findByCountry(String country);
	
	
	
	
}
