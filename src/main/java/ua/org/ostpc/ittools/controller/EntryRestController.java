package ua.org.ostpc.ittools.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class EntryRestController {
    @PostMapping(value="/entry")
    public ModelAndView upload(@RequestParam("speciality") String speciality){
        ModelAndView mav=new ModelAndView();
        if(speciality.equals("Java developer")){
            String testForJava="a";
            mav.addObject("test", testForJava);
            mav.setViewName("redirect:/form");    //Добавить атрибут теста
        }
        else if(speciality.equals("C++ developer")){
            String testForCpp="b";
            mav.addObject("test", testForCpp);
            mav.setViewName("redirect:/form");    //Добавить атрибут теста
        }
        return mav;
    }
}
