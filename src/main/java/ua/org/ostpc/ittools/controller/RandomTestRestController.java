package ua.org.ostpc.ittools.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;

import javax.servlet.http.HttpSession;


@RestController //Controller
public class RandomTestRestController extends Form {

    @Autowired
    FormRepository formRepository;

    @RequestMapping(value = "runtest", method = RequestMethod.POST)
    private ModelAndView runtest(@RequestParam("testresult") String testresult, HttpSession session) throws Exception {

        ModelAndView mav=new ModelAndView("WinAfterTest");

        if(Double.parseDouble(testresult) >=0.5) {
            Long longId;
            longId = (long) session.getAttribute("id");
            formRepository.setLevelForForm(1, (long) session.getAttribute("id"));

            mav.addObject("color","color: green");
            mav.addObject("conclusion", "Ожидайте оповещение от нашего оператора :)");
            return mav;
        }
        else{
            mav.addObject("conclusion", "Оуу... А вы не ошиблись в выборе специальности?");
            mav.addObject("color","color: red");
            return mav;
        }
    }
}



