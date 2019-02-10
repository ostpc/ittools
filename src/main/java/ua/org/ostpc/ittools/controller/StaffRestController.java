package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;

import javax.swing.text.html.FormSubmitEvent;
import java.io.File;
import java.util.List;

@RestController
public class StaffRestController {

    @Autowired
    FormRepository formRepository;

    @PostMapping("/hrKeep")
    private ModelAndView hrKeep(@RequestParam("id") String id){
        System.out.println("keep");
        return new ModelAndView();
    }

    @PostMapping("/hrAccept")
    private ModelAndView hrAccept(@RequestParam("id") String id){
        formRepository.setLevelForForm(2, Long.parseLong(id));
        return new ModelAndView("redirect:hr");
    }

    @PostMapping("/hrShowResume")
    private ModelAndView hrShowResume(@RequestParam("id") String id){
        try{

            List<Form> resumeForm=formRepository.findById(Long.parseLong(id));
            String resumePath=resumeForm.get(0).getResumePath();
            if ((new File(resumePath)).exists()) {

                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler "+resumePath);
                p.waitFor();

            } else {

                System.out.println("File does not exist");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:hr");
    }

    @PostMapping("/hrDecline")
    private ModelAndView hrDecline(@RequestParam("id") String id){
        formRepository.setLevelForForm(-1, Long.parseLong(id));
        return new ModelAndView("redirect:hr");
    }































    @PostMapping("/specKeep")
    private ModelAndView specKeep(@RequestParam("id") String id){
        System.out.println("keep");
        return new ModelAndView();
    }

    @PostMapping("/specAccept")
    private ModelAndView specAccept(@RequestParam("id") String id){
        formRepository.setLevelForForm(3, Long.parseLong(id));
        return new ModelAndView("redirect:spec");
    }

    @PostMapping("/specShowResume")
    private ModelAndView specShowResume(@RequestParam("id") String id){
        hrShowResume(id);
        return new ModelAndView("redirect:spec");
    }


    @PostMapping("/specDecline")
    private ModelAndView specDecline(@RequestParam("id") String id){
        formRepository.setLevelForForm(-2, Long.parseLong(id));
        return new ModelAndView("redirect:spec");
    }











}
