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
        FileWriter nFile = new FileWriter(new File("src/main/resources/templates/TEXT_TXT").getAbsolutePath()+"//"+pathname+".html"+"//",true);


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
                "\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "\n" +  "<span id=\"time\"></span>"+
                "<form method=\"POST\" action=\"runtest\" name= \"forma\" >";

        newFile(firstparthtml , nameHTML);


        return new ModelAndView("/AdminPanel");
    }


    @RequestMapping(value="lastparthtml", method= RequestMethod.POST)
    public static ModelAndView adminom(@RequestParam("nameHTML")String nameHTMLEND, @RequestParam("timeHTML")String timeHTML) throws Exception {



        String lastparthtml="  <p>\n" +
                "\n" +
                "\n" +
                "    <input type=\"button\"  value=\"Подсчитать результаты\" onClick = \"checkForm()\">\n" +
                "    <input type=\"reset\" value=\"Сброс\">\n" +
                "  </p>\n" +
                "    Итого баллов: <input type=\"text\" name=\"testresult\" readonly>\n" +
                "</form>\n" +
                "  \n" +
                "    \n" +
                "<script>\n" +
                "    function checkForm()\n" +
                "    {\n" +
                "        setTimeout('document.forma.submit()',300); //задерка\n" +
                "\n" +
                "\n" +
                "    var myform = this.forma,\n" +
                "        chbx = myform['precipitation[]'],\n" +
                "        b=0,\n" +
                "\t\ta=0;\n" +
                "    for(var i = 0; i < chbx.length; i++)\n" +
                "\t{\n" +
                "            \n" +
                "\n" +
                "\t\t\tif(chbx[i].value==\"true\")\n" +
                "\t\t\t{\n" +
                "\t\t\t\n" +
                "\t\t\ta+=1\n" +
                "\n" +
                "\t\t\t if(chbx[i].checked) \n" +
                "\t\t\t\t{\n" +
                "\n" +
                "\t\t\t\t\tb+=1 \n" +
                "\t\t\t\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t}\n" +
                "    }\n" +
                "\t\n" +
                "\tvar c = (b*100)/a;\n" +
                "\t\n" +
                "\t\n" +
                "    myform.testresult.value = parseInt(c)+\"%\";\n" +
                "}\n" +
                "\n" +
                "\n" +
                "    function startTimer(duration, display) {\n" +
                "        var timer = duration, minutes, seconds;\n" +
                "        setInterval(function () {\n" +
                "            minutes = parseInt(timer / 60, 10)\n" +
                "            seconds = parseInt(timer % 60, 10);\n" +
                "\n" +
                "            minutes = minutes < 10 ? \"0\" + minutes : minutes;\n" +
                "            seconds = seconds < 10 ? \"0\" + seconds : seconds;\n" +
                "\n" +
                "            display.textContent = minutes + \":\" + seconds;\n" +
                "\n" +
                "            if (--timer == 0) {\n" +
                "\n" +
                "\n" +
                "\n" +
                "                checkForm();\n" +
                "\n" +
                "            }\n" +
                "        }, 1000);\n" +
                "    }\n" +
                "\n" +
                "    window.onload = function () {\n" +
                "        var fiveMinutes = 60 * Number("+timeHTML+"),\n" +
                "            display = document.querySelector('#time');\n" +
                "        startTimer(fiveMinutes, display);\n" +
                "    };\n" +
                "</script>\n" +
                "    </body>\n" +
                "</html>";

        newFile(lastparthtml , nameHTMLEND);


        return new ModelAndView("/AdminPanel");
    }








}
