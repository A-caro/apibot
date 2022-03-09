package com.bot.java_coach.controllers;

import com.bot.java_coach.model.dao.CapitulosDao;
import com.bot.java_coach.model.dto.CapitulosDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminCapitulos{
    private CapitulosDao capitulosDao; //llamamos a capitulo dao para obtener capitulo dto(capitulos dao sabe llamar a capitulos y capitulosdto sabe mostrar la informacion)

    private static final Logger logger =
            LoggerFactory.getLogger(AdminCapitulos.class);


    @GetMapping("/capitulos")
    public CapitulosDto listarCapitulos(){
      return null;
    }

    /*@GetMapping("/capitulos")
    public CapitulosDto listarCapitulos(){
        CapitulosDto capitulosDto = listarCapitulos();
        return capitulosDto;
    }*/

}

