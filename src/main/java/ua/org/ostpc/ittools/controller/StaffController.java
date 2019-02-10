package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;

import java.util.List;

@Controller
public class StaffController {

    @Autowired
    FormRepository formRepository;

    @GetMapping("hr")
    public ModelAndView diplayHR() {

        ModelAndView mav=new ModelAndView("hrPage");

        String peopleHTML="";

        List<Form> people= formRepository.findByLevel(1);

        for(int i=0;i<people.size();i++){
            Form formNow=people.get(i);
            peopleHTML=peopleHTML+
                    "<br>\n" +
                    "<div>\n" +
                    "    <form name=\"hrForm\"method=\"POST\" enctype=\"multipart/form-data\">\n" +
                    "        <input readonly name=\"id\" type=\"text\" value=\""+formNow.getId()+"\"></input>\n" +
                    "        <p text=\"\">"+formNow.getName()+"</p>\n" +
                    "        <p text=\"\">"+formNow.getMobilePhone()+"</p>\n" +
                    "        <p text=\"\">"+formNow.getEmail()+"</p>\n" +
                    "        <input type=\"submit\"  formaction=\"/hrShowResume\" value=\"Show resume\">\n" +
                    "        <br>\n" +
                    "        <input type=\"submit\"  formaction=\"/hrKeep\" value=\"Keep\">\n" +
                    "        <input type=\"submit\"  formaction=\"/hrAccept\" value=\"Accept\">\n" +
                    "        <input type=\"submit\"  formaction=\"/hrDecline\" value=\"Decline\">\n" +
                    "    </form>\n" +
                    "</div>\n";
        }

        mav.addObject("people",peopleHTML);

        return mav;


    }

    @GetMapping("spec")
    public ModelAndView diplaySpecialist() {

        ModelAndView mav=new ModelAndView("specPage");

        String peopleHTML="";

        List<Form> people= formRepository.findByLevel(2);

        for(int i=0;i<people.size();i++){
            Form formNow=people.get(i);
            peopleHTML=peopleHTML+
                    "<br>\n" +
                    "<div>\n" +
                    "    <form name=\"specialistForm\"method=\"POST\" enctype=\"multipart/form-data\">\n" +
                    "        <input readonly name=\"id\" type=\"text\" value=\""+formNow.getId()+"\"></input>\n" +
                    "        <p text=\"\">"+formNow.getName()+"</p>\n" +
                    "        <p text=\"\">"+formNow.getMobilePhone()+"</p>\n" +
                    "        <p text=\"\">"+formNow.getEmail()+"</p>\n" +
                    "        <input type=\"submit\"  formaction=\"/specShowResume\" value=\"Show resume\">\n" +
                    "        <br>\n" +
                    "        <input type=\"submit\"  formaction=\"/specKeep\" value=\"Keep\">\n" +
                    "        <input type=\"submit\"  formaction=\"/specAccept\" value=\"Accept\">\n" +
                    "        <input type=\"submit\"  formaction=\"/specDecline\" value=\"Decline\">\n" +
                    "    </form>\n" +
                    "</div>\n";
        }

        mav.addObject("people",peopleHTML);

        return mav;


    }
}
