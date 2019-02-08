package ua.org.ostpc.ittools.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class RandomTestRestController {

    @RequestMapping(value="runtest", method= RequestMethod.POST)
    public static ModelAndView runtest(@RequestParam ("testresult") String  testresult) throws Exception
    {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(new File("src/main/resources/templates/TEXT_TXT").getAbsolutePath()+"//tttt.txt//",true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        nFile.write(testresult);

        nFile.close();


        return  new ModelAndView("FinalPageAfterTest");
    }


}
