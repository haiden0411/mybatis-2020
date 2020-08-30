package com.haiden.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
  private long cId;
  private String cName;
  private List<Student> students;
}
