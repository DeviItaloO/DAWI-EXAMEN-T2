package com.DAWI_I202224460.Espinoza_Atalaya_Italo.controller;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.LanguageDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.Language;
import org.springframework.ui.Model;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDetailDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.service.interfaces.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/maintenance")
@CrossOrigin(origins = "http://localhost:63342")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDTO> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDTO filmDetailDTO = maintenanceService.findDetailById(id);
        model.addAttribute("filmDTO", filmDetailDTO);
        return "maintenance-detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("filmDTO", new FilmDetailDTO(
                null,null,null,null,null,null,
                null,null,null,null,null,null
        ));
        List<LanguageDTO> languages = maintenanceService.findAllLanguages();
        model.addAttribute("languages", languages);
        return "maintenance-update";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute FilmDetailDTO filmDTO) {
        maintenanceService.createFilm(filmDTO);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        FilmDetailDTO filmDetailDTO = maintenanceService.findDetailById(id);
        List<LanguageDTO> languages = maintenanceService.findAllLanguages();
        model.addAttribute("filmDTO", filmDetailDTO);
        model.addAttribute("languages", languages);
        return "maintenance-update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute FilmDetailDTO filmDetailDTO) {
        maintenanceService.updateFilm(id, filmDetailDTO);
        return "redirect:/maintenance/start";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }
}
