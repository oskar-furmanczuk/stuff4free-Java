package net.oskarfurmanczuk.staff4free.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.oskarfurmanczuk.staff4free.models.Advert;
import net.oskarfurmanczuk.staff4free.models.User;

@Repository
public interface AdvertRepository extends MongoRepository<Advert, String>{
	
	public Advert findByTitle(String title);
	public Advert findByUsername(String title);
	public Page<Advert> findAll(Pageable pageable);
	public Page<Advert> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
