package com.zhn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
//在企业中，所有pojo实体类都需要序列化
public class User implements Serializable {
    private String name;
    private int age;
}
