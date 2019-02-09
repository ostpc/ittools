package ua.org.ostpc.ittools.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomTestController {


    @GetMapping(value = "/testing")
    public String displayForm() {
        return "TEXT_TXT/Javatest2.html";//Здесь должен быть рандомный файл хтмл
    }
}
