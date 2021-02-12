package net.oskarfurmanczuk.staff4free.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.oskarfurmanczuk.staff4free.models.Advert;
import net.oskarfurmanczuk.staff4free.repository.AdvertRepository;


@Service
public class AdvertService {
	@Autowired
	private AdvertRepository advertRepository;
	@Autowired
	private ContextService contextService;
	private Path path;
	
	public void saveAdvert(Advert adv) {
		ObjectId id = new ObjectId();
		adv.setId(id);
		System.out.println(adv.getId().toString());
		advertRepository.save(adv);
	}

	public void saveImage(MultipartFile imageFile, String id) throws Exception {
		String base = System.getProperty("user.dir").replace("\\", "/") 
				+ "/src/main/resources/static/images/advPhotos/"
				+ contextService.getCurrentUserId();
		
		File f = new File(base);
		if (!f.isDirectory()) {
			f.mkdir();
		}
			
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(base +"/"+ id);
		Files.write(path, bytes);
		
	}
	public Advert findByTitle(String title) {
		return advertRepository.findByTitle(title);
	}
	public String getAdvertId(String title) {
		return findByTitle(title).getId().toString();
	}
	
	public List<Advert> findAll(int numPage, int records){
		Page<Advert> page = advertRepository.findAll(PageRequest.of(numPage, records, Sort.by("createdDate")));
		List<Advert> listAdv = page.getContent();
		
		return listAdv;
	}
	
	
	  public List<Advert> findByTitle(String title, int numPage, int records){
		  Page<Advert> page = advertRepository.findByTitleContainingIgnoreCase(title, PageRequest.of(numPage, records, Sort.by("createdDate")));
		  List<Advert> listAdv = page.getContent();
			
		  return listAdv;
	  }


	

}
