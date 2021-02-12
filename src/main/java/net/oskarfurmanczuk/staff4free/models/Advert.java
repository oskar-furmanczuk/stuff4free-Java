package net.oskarfurmanczuk.staff4free.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Adverts")

public class Advert {
	
	private ObjectId id;
	private String title;
	private String description;
	private String country;
	private String state;
	private String city;
	private String pathToPhoto;
	
	
	@CreatedBy
    private String username;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModifiedDate;

	
}
