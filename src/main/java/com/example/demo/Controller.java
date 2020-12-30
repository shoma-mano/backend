package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.mapper.HeroMapper;
import com.example.model.Hero;



@RestController
@RequestMapping("/api")
public class Controller {



@Autowired
private HeroMapper heroMapper;

private List<Hero> heroes;




@CrossOrigin
@GetMapping("/get")
void get(){
System.out.println("hello");
}

@CrossOrigin
@PostMapping("/saveHero")
Hero insertHero(@RequestBody Hero hero){
	 System.out.println(hero);
     heroMapper.insertHero(hero);
     return hero;
}


@CrossOrigin
@GetMapping("/getHeroes")
 public List<Hero> getHeros(){
	
  return  heroMapper.getHeroes();
}

@CrossOrigin
@GetMapping("/getHeroes/{email}")
 public List<Hero> getHeros(@PathVariable("email") String email){
System.out.println(email);
  return  heroMapper.getHeroesfromemail(email);
}




@CrossOrigin
@GetMapping("/getMarvelHeroes")
 public List<Hero> getMarvelHeros(){
  this.heroes=heroMapper.getHeroes();
  System.out.println("hello");
  return  heroMapper.getMarvelHeroes();
}


@CrossOrigin
@GetMapping("/getHero/{id}")
 public Hero getHero(@PathVariable int id){
	
	return  heroMapper.getHero(id);
}


@CrossOrigin
@DeleteMapping("deleteHero/{id}")
  void deleteHero(@PathVariable int id ){
  heroMapper.deleteHero(id);
}

@CrossOrigin
@PutMapping("updateHero")
  void updateHero(@RequestBody Hero hero){
  heroMapper.updateHero(hero);
}

@CrossOrigin
@GetMapping("searchHero")
  List<Hero> searchHero(@RequestParam("name") String name){
  System.out.println(heroMapper.searchHero(name).get(0).getName());
  return heroMapper.searchHero(name);
}

}
