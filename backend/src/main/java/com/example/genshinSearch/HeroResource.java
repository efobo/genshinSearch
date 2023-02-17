package com.example.genshinSearch;

import com.example.genshinSearch.model.Hero;
import com.example.genshinSearch.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroResource {
    private final HeroService heroService;

    public HeroResource(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hero>> getAllHeros() {
        List<Hero> heroes = heroService.findAllHeroes();
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") Long id) throws Throwable {
        Hero hero = heroService.findHeroById(id);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hero> addHero (@RequestBody Hero hero) {
        Hero newHero = heroService.addHero(hero);
        return new ResponseEntity<>(newHero, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Hero> updateHero (@RequestBody Hero hero) {
        Hero updateHero = heroService.updateHero(hero);
        return new ResponseEntity<>(updateHero, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHero (@PathVariable("id") Long id) {
        heroService.deleteHero(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
