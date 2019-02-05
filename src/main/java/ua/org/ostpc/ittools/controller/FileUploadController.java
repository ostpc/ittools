package ua.org.ostpc.ittools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class FileUploadController {
    @GetMapping(value = "uploading")
    public String displayForm() {

        return "fileUploadForm";
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
