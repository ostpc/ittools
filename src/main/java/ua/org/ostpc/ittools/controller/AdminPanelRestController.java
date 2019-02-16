package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.HTMLTestRepository;
import ua.org.ostpc.ittools.entity.HTMLTest;
import java.util.UUID;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


@RestController
public class AdminPanelRestController {

    @Autowired  //Save to DB part
    private HTMLTestRepository HTMLTestRepository;  //Save to DB part

    private void saveHTMLtoDb(String insideHTMLpath){

        String absolutePath=new File("src/main/resources/templates/TEXT_TXT").getAbsolutePath()+"\\"+insideHTMLpath+".html";
        String fileName;
        int iLastSlash=insideHTMLpath.lastIndexOf("\\");
        fileName=insideHTMLpath.substring(iLastSlash+1);

        HTMLTest newTest=new HTMLTest();
        newTest.setType(fileName.substring(0,fileName.lastIndexOf('t')-3).toLowerCase());
        newTest.setPath("TEXT_TXT/"+insideHTMLpath+".html");
        HTMLTestRepository.save(newTest);

    }  //Save to DB part end

    @RequestMapping(value="adminpanel", method= RequestMethod.POST)
    public ModelAndView admin(@RequestParam("namePathHTML") String namePathHTML , @RequestParam("question") String question , @RequestParam("answer1") String answer1 , @RequestParam("answer2") String answer2, @RequestParam("answer3") String answer3, @RequestParam("answer4") String answer4, @RequestParam("answer5") String answer5, @RequestParam("boolansver1") String boolansver1, @RequestParam("boolansver2") String boolansver2, @RequestParam("boolansver3") String boolansver3 , @RequestParam("boolansver4") String boolansver4 , @RequestParam("boolansver5") String boolansver5) throws Exception {

        UUID forid1= UUID.randomUUID();
        UUID forid2= UUID.randomUUID();
        UUID forid3= UUID.randomUUID();
        UUID forid4= UUID.randomUUID();
        UUID forid5= UUID.randomUUID();

        
        String testhtmlform ="<div >\n" +
                "\n" +
                "            <p>"+question+"</p><br>\n" +
                "\n" +
                "            <input  id =\""+forid1+"\" type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver1+"\">\n" +
                "            <label for=\""+forid1+"\" >"+answer1+"</label>\n" +
                "\n" +
                "            <br>\n" +
                "            <br>" +
                "" +
                " <input  id = \""+forid2+"\" type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver2+"\">\n" +
                "            <label for=\""+forid2+"\" >"+answer2+"</label>\n" +
                "\n" +
                "            <br>\n" +
                "            <br>" +
                "" +
                " <input  id = \""+forid3+"\" type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver3+"\">\n" +
                "            <label for=\""+forid3+"\" >"+answer3+"</label>\n" +
                "\n" +
                "            <br>\n" +
                "            <br>" +
                "" +
                "<input  id = \""+forid4+"\" type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver4+"\">\n" +
                "            <label for=\""+forid4+"\" >"+answer4+"</label>\n" +
                "\n" +
                "            <br>\n" +
                "            <br>" +
                "" +
                "<input  id = \""+forid5+"\" type=\"checkbox\" name=\"precipitation[]\" value=\""+boolansver5+"\">\n" +
                "            <label for=\""+forid5+"\" >"+answer5+"</label>\n" +
                "\n" +
                "            <br>\n" +
                "            <br> </div>\n" +
                "\n" +
                "        <br> " +
                "" ;










        newFile(testhtmlform , namePathHTML);

        return new ModelAndView("/AdminPanel");
    }

    private void newFile(String str, String pathname) throws Exception {        //public --> private

        File file=new File((new File("src/main/resources/templates/TEXT_TXT").getAbsolutePath() + "\\" + pathname + ".html"));
        try {
            FileWriter nFile = new FileWriter(file, true);
            nFile.write(str);
            nFile.close();
        }
        catch(FileNotFoundException e){
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter nFile = new FileWriter(file, true);
            nFile.write(str);
            nFile.close();
        }
    }


    @RequestMapping(value="firstparthtml", method= RequestMethod.POST)
    public ModelAndView adminh(@RequestParam("nameHTML")String nameHTML ) throws Exception {


        String firstparthtml="<html lang=\"en\" xmlns:th=\"http://www.springframework.org/schema/data/jaxb\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "\n" +
                "\n" +
                "    <link  rel=\"stylesheet\" th:href=\"@{/css/CSSfortest.css}\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"../../static/css/CSSadmin.css\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<span id=\"time\"></span>\n" +
                "\n" +
                "<div id=\"centr\">\n" +
                "\n" +
                "    <form method=\"POST\" action=\"runtest\" name= \"forma\" >";

        newFile(firstparthtml , nameHTML);


        return new ModelAndView("/AdminPanel");
    }


    @RequestMapping(value="lastparthtml", method= RequestMethod.POST)
    public ModelAndView adminom(@RequestParam("nameHTML")String nameHTMLEND, @RequestParam("timeHTML")String timeHTML) throws Exception {   //Я убрал тут статик



        String lastparthtml="     <div>\n" +
                "\n" +
                "            <p>\n" +
                "\n" +
                "                <input type=\"button\" class=\"bttn\" value=\"Send to check\" onClick = \"checkForm()\">\n" +
                "\n" +
                "                <input type=\"reset\" class=\"bttn\" value=\"Reset\">\n" +
                "            </p>\n" +
                "\n" +
                "\n" +
                "        </div>     <div>\n" +
                "            <p id=\"namepath1\">Success:</p>\n" +
                "\n" +
                "            <input id=\"namepath\" type=\"text\" name=\"testresultstr\" readonly>\n" +
                "\n" +
                "            <input  hidden type=\"text\" name=\"testresult\">\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "    </form>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "<script>\n" +
                "    function checkForm()\n" +
                "    {\n" +
                "        setTimeout('document.forma.submit()',300); //задерка\n" +
                "\n" +
                "\n" +
                "        var myform = this.forma,\n" +
                "            chbx = myform['precipitation[]'],\n" +
                "            b=0,\n" +
                "            a=0;\n" +
                "        var d = 0 ;\n" +
                "        for(var i = 0; i < chbx.length; i++)\n" +
                "        {\n" +
                "\n" +
                "\n" +
                "            if(chbx[i].value==\"true\")\n" +
                "            {\n" +
                "\n" +
                "                a+=1\n" +
                "\n" +
                "                if(chbx[i].checked)\n" +
                "                {\n" +
                "\n" +
                "                    b+=1\n" +
                "\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "            if(chbx[i].value==\"false\")\n" +
                "            {\n" +
                "                if(chbx[i].checked)\n" +
                "                {\n" +
                "\n" +
                "                    d+=0.25;\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        var c = ((b-d)*100)/a;\n" +
                "\n" +
                "\n" +
                "        myform.testresultstr.value = c+\"%\";\n" +
                "        myform.testresult.value = parseInt(c)/100;}\n" +
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
                "        var fiveMinutes = 60 *Number("+timeHTML+"),\n"+
                "            display = document.querySelector('#time');\n" +
                "        startTimer(fiveMinutes, display);\n" +
                "    };\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";


        saveHTMLtoDb(nameHTMLEND);      //TEST сохраняется в базу данных

        newFile(lastparthtml , nameHTMLEND);


        return new ModelAndView("/AdminPanel");
    }

}
