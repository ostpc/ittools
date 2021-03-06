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
            if(formNow.getUserId()==null) {
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
                        "        <input type=\"submit\" class=\"bttnwhite\" formaction=\"/hrKeep\" value=\"Keep\">\n" +
//                    "        <input type=\"submit\" class=\"bttnblue\" formaction=\"/hrAccept\" value=\"Accept\">\n" +
//                    "        <input type=\"submit\"  class=\"bttnred\" formaction=\"/hrDecline\" value=\"Decline\">\n" +
                        "</div>\n" +
                        "    </form>\n" +
                        "</div>\n";
            }
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
            if(formNow.getUserId()==null) {
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
                        "        <input type=\"submit\" class=\"bttnwhite\" formaction=\"/specKeep\" value=\"Keep\">\n" +
//                    "        <input type=\"submit\" class=\"bttnblue\"  formaction=\"/specAccept\" value=\"Accept\">\n" +
//                    "        <input type=\"submit\" class=\"bttnred\" formaction=\"/specDecline\" value=\"Decline\">\n" +
                        "</div>\n" +
                        "    </form>\n" +
                        "</div>\n";
            }
        }

        mav.addObject("people",peopleHTML);
        return mav;
    }



    @GetMapping("staff")
    public ModelAndView diplayStaff() {

        ModelAndView mav = new ModelAndView("staffPage");
        String staffHTML="";

        List<Form> staff= formRepository.findByLevel(3);

        for(Form formNow:staff){
            staffHTML= staffHTML + "<br>\n" +
                    "<div class=\"allhr\">\n" +
                    "    <form name=\"specialistForm\"method=\"POST\" enctype=\"multipart/form-data\">\n" +
                    "        <input readonly name=\"id\" class=\"resutf\"  type=\"text\" value=\"" + formNow.getId() + "\"></input>\n" +
                    "        <p class=\"namef\" text=\"\">" + formNow.getName() + "</p>\n" +
                    "        <p class=\"mobf\" text=\"\">" + formNow.getMobilePhone() + "</p>\n" +
                    "        <p class=\"emf\" text=\"\">" + formNow.getEmail() + "</p>\n" +
                    "        <input type=\"submit\" class=\"hhh\" formaction=\"/specShowResume\" value=\"Show resume\">\n" +
                    " <br>\n" +
                    "    </form>\n" +
                    "</div>\n";
        }
        mav.addObject("staff",staffHTML);
        return mav;
    }









}
