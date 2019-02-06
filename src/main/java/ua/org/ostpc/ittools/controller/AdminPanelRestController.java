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








       String testhtmlform ="\n" +
               "  <p>"+question+"<br>" +
               "<label> <input type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver1+"\">"+answer1+"</label><br>" +
               "<label> <input type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver2+"\">"+answer2+"</label><br>" +
               "<label> <input type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver3+"\">"+answer3+"</label><br>" +
               "<label> <input type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver4+"\">"+answer4+"</label><br>" +
               "<label> <input type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver5+"\">"+answer5+"</label><br></p>";








                newFile(testhtmlform , namePathHTML);

        return new ModelAndView("/AdminPanel");
    }

    public static void newFile(String str, String pathname) throws Exception {
        FileWriter nFile = new FileWriter(new File("src/main/resources/TEXT_TXT").getAbsolutePath()+"//"+pathname+".html"+"//",true);


        nFile.write(str);

        nFile.close();
    }


    @RequestMapping(value="firstparthtml", method= RequestMethod.POST)
    public static ModelAndView adminh(@RequestParam("nameHTML")String nameHTML ) throws Exception {


        String firstparthtml="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "\t<script src=\"/my/script.js\"></script>\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<form>";

        newFile(firstparthtml , nameHTML);


        return new ModelAndView("/AdminPanel");
    }


    @RequestMapping(value="lastparthtml", method= RequestMethod.POST)
    public static ModelAndView adminom(@RequestParam("nameHTML")String nameHTMLEND ) throws Exception {



        String lastparthtml=" <p>\n" +
                "    <input type=\"button\" id=\"calc\" value=\"Подсчитать результаты\">\n" +
                "    <input type=\"reset\" value=\"Сброс\">\n" +
                "  </p>\n" +
                "    Итого баллов: <input type=\"text\" name=\"result\" readonly>\n" +
                "</form>\n" +
                "  \n" +
                "    \n" +
                "<script>\n" +
                "calc.onclick = function(){\n" +
                "    var myform = this.form,\n" +
                "        chbx = myform['precipitation[]'],\n" +
                "        res=0;\n" +
                "    for(var i = 0; i < chbx.length; i++){\n" +
                "        if(chbx[i].checked) {\n" +
                "            \n" +
                "\n" +
                "\t\t\tif(chbx[i].value==\"true\"){  res+=1 };\n" +
                "\t\t\t\n" +
                "        }\n" +
                "    }\n" +
                "\t\n" +
                "\t\n" +
                "    myform.result.value = res;\n" +
                "}\n" +
                "\n" +
                "   </script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        newFile(lastparthtml , nameHTMLEND);


        return new ModelAndView("/AdminPanel");
    }








}
