package net.oskarfurmanczuk.staff4free.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document(collection="Locations")
public class Location {
	private String country;
	private String city;
	private String admin_name;
}
