package edu.ucan.formsspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucan.formsspring.model.Login;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
// @CrossOrigin(origins = "*")
@RequestMapping("/")
public class HelloController 
{
    private static List<Login> listaLogin = new ArrayList();

    public HelloController()
    {
        listaLogin.add(new Login("admin", "1234"));
        listaLogin.add(new Login("edson.duma", "1234"));
        listaLogin.add(new Login("aires.veloso", "1234"));
    }

    @GetMapping
    public String hello()
    {
        return "Olá mundo!";
    }

    @PostMapping
    public String login(@RequestBody Login login)
    {
        // System.out.println(login);
        // System.err.println(login);
        String message = "Problemas no Login!";

        for (Login temp: listaLogin)
        {
            // Login temp = listaLogin.get(listaLogin.indexOf(e));
            
            if (temp.getUsername().equals(login.getUsername()))
                if (temp.getPassword().equals(login.getPassword()))
                    message = "Login efetuado com sucesso!";
        }

        return message;
    }
}