package ua.org.ostpc.ittools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntryController {
    @GetMapping(value = "/entry")
    public String displayForm() {

        return "entry";
    }
}
