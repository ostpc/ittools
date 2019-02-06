package ua.org.ostpc.ittools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;


@RestController
public class AdminPanelRestController {


    @RequestMapping(value="adminpanel", method= RequestMethod.POST)
    public static ModelAndView admin(@RequestParam("namePathHTML") String namePathHTML , @RequestParam("question") String question , @RequestParam("answer1") String answer1 , @RequestParam("answer2") String answer2, @RequestParam("answer3") String answer3, @RequestParam("answer4") String answer4, @RequestParam("answer5") String answer5, @RequestParam("boolansver1") String boolansver1, @RequestParam("boolansver2") String boolansver2, @RequestParam("boolansver3") String boolansver3 , @RequestParam("boolansver4") String boolansver4 , @RequestParam("boolansver5") String boolansver5) throws Exception {

        String testhtmlform = "<p><b>"+question+"</b></p><p><input type=\"checkbox\" name=\"answer1\" value=\""+boolansver1+"\" >"+answer1+"<Br><p><input type=\"checkbox\" name=\"answer1\" value=\""+boolansver2+"\" >"+answer2+"<Br><p><input type=\"checkbox\" name=\"answer1\" value=\""+boolansver3+"\" >"+answer3+"<Br><p><input type=\"checkbox\" name=\"answer1\" value=\""+boolansver4+"\" >"+answer4+"<Br><p><input type=\"checkbox\" name=\"answer1\" value=\""+boolansver5+"\" >"+answer5+"</p>";



        newFile(testhtmlform , namePathHTML);

        return new ModelAndView("/AdminPanel");
    }

    public static void newFile(String str, String pathname) throws Exception {
        FileWriter nFile = new FileWriter(new File("src/main/resources/TEXT_TXT").getAbsolutePath()+"//"+pathname+".html"+"//",true);


        nFile.write(str);

        nFile.close();
    }



}
