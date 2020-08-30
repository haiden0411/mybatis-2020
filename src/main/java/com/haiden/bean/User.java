package com.haiden.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private long uId;
  private String uName;
  private String uSex;
  private long uAge;

}
