package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.Pregunta;
import com.example.backendh93p1.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin("*")

public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> busquedapregunta() {
        return (List<Pregunta>) preguntaService.obtenerPreguntas();
    }

    @PostMapping
    public void crearpregunta(@RequestBody Pregunta preguntaClient) {
        preguntaService.agregarPregunta(preguntaClient);
    }

    @PutMapping
    public void actualizarExamen(@RequestBody Pregunta preguntaClient){
        preguntaService.actualizarPregunta(preguntaClient);
    }
    @GetMapping (value = "{preguntaId}")
    public  Pregunta obtenerExamenId (@PathVariable ("preguntaId") Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);

    }
}
