package ua.org.ostpc.ittools.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@RestController
public class EntryRestController {
    @PostMapping(value="entry")
    public ModelAndView upload(@RequestParam("speciality") String speciality, HttpSession session){
        ModelAndView mav=new ModelAndView();
        if(speciality.equals("Java developer")){
            session.setAttribute("speciality", speciality);
            mav.setViewName("redirect:form");    //Добавить атрибут теста
        }
        else if(speciality.equals("C++ developer")){
            mav.addObject("speciality", speciality);
            mav.setViewName("redirect:form");    //Добавить атрибут теста
        }
        return mav;
    }
}
