package ua.org.ostpc.ittools.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.HTMLTestRepository;
import ua.org.ostpc.ittools.entity.HTMLTest;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class RandomTestController {

    @Autowired
    HTMLTestRepository htmlTestRepository;

    @GetMapping(value = "/testing")
    public ModelAndView displayForm(HttpSession session) {


        String viewPath="Не найдено!";


        String testTemplate = (String) session.getAttribute("speciality");//.toString().toLowerCase();
        if (testTemplate!=null) {


            testTemplate = testTemplate.toLowerCase().substring(0, testTemplate.indexOf(' '));

            List<HTMLTest> tests = htmlTestRepository.findByType(testTemplate);
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(tests.size());
            HTMLTest test = tests.get(index);
            viewPath=test.getPath();

        }
        return  new ModelAndView(viewPath);


    }
}
