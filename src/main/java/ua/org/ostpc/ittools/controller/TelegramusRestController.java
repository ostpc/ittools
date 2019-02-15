package ua.org.ostpc.ittools.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.TelegramusRepository;
import ua.org.ostpc.ittools.entity.Telegramus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TelegramusRestController {

    @Autowired
    private TelegramusRepository telegramUserRepository;

    @RequestMapping(value = "telegrampage", method = RequestMethod.POST)
    public ModelAndView upload(HttpSession session, @RequestParam("sname") String sname, @RequestParam("tname") String tname, HttpServletRequest request) {
        try {

            ModelAndView testMav = new ModelAndView();

            Telegramus telegramUserToBD = new Telegramus();
            if (!(sname.equals("") || tname.equals(""))) {

                telegramUserToBD.setUsername(sname);
                telegramUserToBD.setTelegramname(tname);


                telegramUserRepository.save(telegramUserToBD);

                session.setAttribute("id", telegramUserToBD.getId());   //id in session

                testMav.setViewName("redirect:/telegrampage");    //redirect:test !!!
            } else {
                testMav.setViewName("failureTelegramusStage");    //ajax feature is welcome
            }

            return testMav;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("error");

    }
}
