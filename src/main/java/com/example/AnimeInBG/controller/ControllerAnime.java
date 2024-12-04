package com.example.AnimeInBG.controller;

import com.example.AnimeInBG.model.anime.Anime;
import com.example.AnimeInBG.service.AnimeService;
import com.example.AnimeInBG.service.FormatAnimeService;
import com.example.AnimeInBG.service.GenerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ControllerAnime {
    private final AnimeService animeService;
    private GenerService generService;
    private FormatAnimeService formatAnimeService;

    public ControllerAnime(AnimeService animeService, GenerService generService, FormatAnimeService formatAnimeService) {
        this.animeService = animeService;
        this.generService = generService;
        this.formatAnimeService = formatAnimeService;
    }

    @RequestMapping(value = "/anime/list", method = RequestMethod.GET)
    public String getAnimeList(Model model){
        model.addAttribute("listAnime", animeService.getAll());
        return "AnimeList";
    }

    @RequestMapping(value = "/anime/create",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createAnimeForm(Model model) {
        model.addAttribute("anime", new Anime());
        model.addAttribute("genres", generService.getAllGenres());
        model.addAttribute("formats", formatAnimeService.getAllFormats());
        return "anime-create";
    }

    @RequestMapping(value = "/anime/create",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createAnime(@ModelAttribute Anime anime) {
        animeService.saveAnime(anime);
        return "redirect:/anime/list";
    }

}
