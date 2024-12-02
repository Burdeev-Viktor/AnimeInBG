package com.example.AnimeInBG.controller;

import com.example.AnimeInBG.model.AnimeProperties;
import com.example.AnimeInBG.service.AnimePropertiesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ControllerAnimeProperties {
    private final AnimePropertiesService animePropertiesService;

    public ControllerAnimeProperties(AnimePropertiesService animePropertiesService) {
        this.animePropertiesService = animePropertiesService;
    }

    @RequestMapping(value = "/anime-list", method = RequestMethod.GET)
    public String getAnimeList(Model model){
        model.addAttribute("listAnime",animePropertiesService.getAll());
        return "AnimeList";
    }

    @RequestMapping(value = "/add-anime",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAnimeForm(Model model){
        model.addAttribute("newAnime",new AnimeProperties());
        return "AnimeForm";
    }

    @RequestMapping(value = "/add-anime",method = RequestMethod.POST)
    public String addAnime(AnimeProperties animeProperties){
        animePropertiesService.setAnimeProperties(animeProperties);
        return "redirect:/anime-list";
    }

}
