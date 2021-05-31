package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.mapper.HeroMapper;
import com.example.model.Hero;


@SpringBootApplication
public class SampleMybatisApplication implements CommandLineRunner {

  
  @Autowired
  private HeroMapper heroMapper;
  private Hero[] heros;
  
  public static void main(String[] args) {
    SpringApplication.run(SampleMybatisApplication.class, args);
  }
  

  @Override
  public void run(String... args) throws Exception {  System.out.println("hello"); }
  
  
 

}