package ua.org.ostpc.ittools.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;

import javax.servlet.http.HttpSession;


@Controller
public class RandomTestRestController extends Form {

    @Autowired
    FormRepository formRepository;


    @RequestMapping(value = "runtest", method = RequestMethod.POST)
    private ModelAndView runtest(@RequestParam("testresult") String testresult, HttpSession session) throws Exception {



        Form form=new Form();
    if(Integer.valueOf(testresult)>90){

        form.setLevel(1);

    }

    else {       form.setLevel(1);      }

        formRepository.save(form);

        return new ModelAndView("FinalPageAfterTest");
    }

}



