package net.oskarfurmanczuk.staff4free.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.oskarfurmanczuk.staff4free.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	User findByUsername(String username);
}
