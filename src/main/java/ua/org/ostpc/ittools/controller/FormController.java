package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class FormController {
    @GetMapping(value = "form")
    public ModelAndView displayForm(ModelAndView mav, HttpSession session, HttpServletRequest request) {         //ModelAndView return??
//        mav.addObject("speciality",session.getAttribute("speciality"));
        mav.setViewName("form");
        return mav;
    }
}


//    @RequestMapping(value = "/uploading", method = RequestMethod.GET)     it shouldn't be in the rest controller
//    public String displayForm() {
//
//        return "fileUploadForm";
//    }


//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public String submit(@RequestParam("file") final MultipartFile file, final ModelMap modelMap) {
//
//        modelMap.addAttribute("file", file);
//        return "fileUploadView";
//    }
//
//    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
//    public String submit(@RequestParam("files") final MultipartFile[] files, final ModelMap modelMap) {
//
//        modelMap.addAttribute("files", files);
//        return "fileUploadView";
//    }
//
//    @RequestMapping(value = "/uploadFileWithAddtionalData", method = RequestMethod.POST)
//    public String submit(@RequestParam final MultipartFile file, @RequestParam final String name, @RequestParam final String email, final ModelMap modelMap) {
//
//        modelMap.addAttribute("name", name);
//        modelMap.addAttribute("email", email);
//        modelMap.addAttribute("file", file);
//        return "fileUploadView";
//    }

//    @RequestMapping(value = "/uploadFileModelAttribute", method = RequestMethod.POST)
//    public String submit(@ModelAttribute final FormDataWithFile formDataWithFile, final ModelMap modelMap) {
//
//        modelMap.addAttribute("formDataWithFile", formDataWithFile);
//        return "fileUploadView";
//    }
