package com.example.genshinSearch.service;

import com.example.genshinSearch.exeption.UserNotFoundException;
import com.example.genshinSearch.model.Hero;
import com.example.genshinSearch.repo.HeroRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HeroService {
    private final HeroRepo heroRepo;

    @Autowired
    public HeroService(HeroRepo heroRepo) {
        this.heroRepo = heroRepo;
    }

    public Hero addHero(Hero hero) {
        hero.setHeroCode(UUID.randomUUID().toString());
        return heroRepo.save(hero);
    }

    public List<Hero> findAllHeroes() {
        return heroRepo.findAll();

    }

    public Hero updateHero (Hero hero) {
        return heroRepo.save(hero);
    }
    public Hero findHeroById(Long id) throws Throwable {
        return heroRepo.findHeroById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteHero(Long id) {
        heroRepo.deleteHeroById(id);
    }
}
