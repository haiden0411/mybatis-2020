package com.haiden.bean;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "employee")
public class Employee {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;

  @TableField(value = "last_name")
  private String lastName;

  @TableField(value = "email")
  private String email;

  @TableField(value = "gender")
  private String gender;

  @TableField(value = "age")
  //@TableField(exist = false)
  private long age;

  public Employee(String lastName, String email, String gender, long age)
  {
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.age = age;
  }
}
