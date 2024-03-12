package org.controlleradvice.controllers;

import org.controlleradvice.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/myerror")
    public String myError(){
        throw new RuntimeException("Erro personalizado");
    }

    @GetMapping("/mycustomerror")
    public String myCustomError(){
        throw new ResourceNotFoundException("Recurso não encontrado");
    }

}
