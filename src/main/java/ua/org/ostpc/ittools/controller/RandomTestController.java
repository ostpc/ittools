package ua.org.ostpc.ittools.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String displayForm(HttpSession session) {


        String testTemplate=session.getAttribute("speciality").toString().toLowerCase();
        testTemplate=testTemplate.substring(0,testTemplate.indexOf(' '));

        List<HTMLTest> tests= htmlTestRepository.findByType(testTemplate);
        Random randomGenerator=new Random();
        int index = randomGenerator.nextInt(tests.size());
        HTMLTest test = tests.get(index);
        String viewPath=test.getPath();
        return viewPath;


    }
}
