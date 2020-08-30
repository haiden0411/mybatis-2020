package com.haiden.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private long sId;
  private String sName;
  private long sAge;
  private String sEmail;
  private long classId;

}
