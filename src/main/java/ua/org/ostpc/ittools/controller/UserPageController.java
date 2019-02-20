package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;
import ua.org.ostpc.ittools.entity.User;
import ua.org.ostpc.ittools.service.UserService;

import java.util.List;
@Controller
public class UserPageController {



        @Autowired
        FormRepository formRepository;

        @Autowired
        UserService userService;

        @GetMapping("user/hr")
        public ModelAndView diplayMyHR() {

            ModelAndView mav=new ModelAndView("userPage");

            String peopleHTML="";
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            List<Form> people= formRepository.findByUserId((long)user.getId());

            for(int i=0;i<people.size();i++){
                Form formNow=people.get(i);
                if (formNow.getLevel() == 1) {
                    peopleHTML = peopleHTML +
                            "<br>\n" +
                            "<div class=\"allhr\">\n" +
                            "    <form name=\"hrForm\"method=\"POST\"  enctype=\"multipart/form-data\">\n" +
                            "        <input readonly name=\"id\" class=\"resutf\"  type=\"text\" value=\"" + formNow.getId() + "\"></input>\n" +
                            "        <p class=\"namef\" text=\"\">" + formNow.getName() + "</p>\n" +
                            "        <p class=\"mobf\" text=\"\">" + formNow.getMobilePhone() + "</p>\n" +
                            "        <p class=\"emf\" text=\"\">" + formNow.getEmail() + "</p>\n" +
                            "        <input type=\"submit\" class=\"hhh\" formaction=\"/hrShowResume\" value=\"Show resume\">\n" +
                            "        <br>\n" +
                            "<div class=\"menubut\">\n" +
                            "        <input type=\"submit\" class=\"bttnblue\" formaction=\"/hrAccept\" value=\"Accept\">\n" +
                            "        <input type=\"submit\"  class=\"bttnred\" formaction=\"/hrDecline\" value=\"Decline\">\n" +
                            "</div>\n" +
                            "    </form>\n" +
                            "</div>\n";
                }
            }

            mav.addObject("people",peopleHTML);

            return mav;


        }

        @GetMapping("user/spec")
        public ModelAndView diplayMySpecialist() {

            ModelAndView mav=new ModelAndView("userPage");

            String peopleHTML="";
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            List<Form> people= formRepository.findByUserId((long)user.getId());

            for(int i=0;i<people.size();i++){
                Form formNow=people.get(i);
                if(formNow.getLevel()==2) {
                    peopleHTML = peopleHTML +
                            "<br>\n" +
                            "<div class=\"allhr\">\n" +
                            "    <form name=\"specialistForm\"method=\"POST\" enctype=\"multipart/form-data\">\n" +
                            "        <input readonly name=\"id\" class=\"resutf\"  type=\"text\" value=\"" + formNow.getId() + "\"></input>\n" +
                            "        <p class=\"namef\" text=\"\">" + formNow.getName() + "</p>\n" +
                            "        <p class=\"mobf\" text=\"\">" + formNow.getMobilePhone() + "</p>\n" +
                            "        <p class=\"emf\" text=\"\">" + formNow.getEmail() + "</p>\n" +
                            "        <input type=\"submit\" class=\"hhh\" formaction=\"/specShowResume\" value=\"Show resume\">\n" +
                            " <br>\n" +
                            "<div class=\"menubut\">\n" +
                            "        <input type=\"submit\" class=\"bttnblue\"  formaction=\"/specAccept\" value=\"Accept\">\n" +
                            "        <input type=\"submit\" class=\"bttnred\" formaction=\"/specDecline\" value=\"Decline\">\n" +
                            "</div>\n" +
                            "    </form>\n" +
                            "</div>\n";
                }
            }

            mav.addObject("people",peopleHTML);

            return mav;


        }


}
