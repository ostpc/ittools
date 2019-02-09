package ua.org.ostpc.ittools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {


    @GetMapping(value = "/adminpanel")
    public String displayForm() {
    return "AdminPanel";
    }
}

