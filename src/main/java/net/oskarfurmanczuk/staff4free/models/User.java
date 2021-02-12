package net.oskarfurmanczuk.staff4free.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="Users")
public class User {
  @Id
  public ObjectId id;
  public String username;
  public String password;
  public String email;
  public String phoneNumber;
  @CreatedBy
  private String createdBy;

  @CreatedDate
  private Date createdDate;

  @LastModifiedBy
  private String lastModifiedBy;

  @LastModifiedDate
  private Date lastModifiedDate;
}
