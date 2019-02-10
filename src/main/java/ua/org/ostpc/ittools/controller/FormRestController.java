package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.net.www.http.HttpCapture;
import ua.org.ostpc.ittools.dao.FormRepository;
import ua.org.ostpc.ittools.entity.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
@RestController
public class FormRestController {

    private static String UPLOAD_DIR="";
    @Autowired
    private FormRepository formRepository;

    @RequestMapping(value="form", method= RequestMethod.POST)
    public ModelAndView upload(HttpSession session, @RequestParam("file") MultipartFile file, @RequestParam("fname") String fname, @RequestParam("sname") String sname, @RequestParam("mobilePhone") String mobilePhone, @RequestParam("email") String email, HttpServletRequest request){
        try{
            String fileName=file.getOriginalFilename();
            String path= "C:\\Users\\Pinky\\IdeaProjects\\ittools\\src\\main\\resources\\static\\resumes" + UPLOAD_DIR + "" + File.separator + fileName;    //Change depends of System
            path=saveFile(file.getInputStream(), path);

            ModelAndView testMav= new ModelAndView();

            Form formToBD=new Form();
            if(!(fname.equals("") || sname.equals("") || mobilePhone.equals("") || fileName.equals("") || email.equals(""))) {
                formToBD.setResumePath(path);
                formToBD.setName(fname + sname);
                formToBD.setEmail(email);
                formToBD.setLevel(0);
                formToBD.setMobilePhone(mobilePhone);
                formToBD.setSpeciality(session.getAttribute("speciality").toString());



                formRepository.save(formToBD);

                session.setAttribute("id", formToBD.getId());   //id in session

                testMav.setViewName("redirect:/testing");    //redirect:test !!!
            }
            else{
                testMav.setViewName("failureFormStage");    //ajax feature is welcome
            }

            return testMav;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("error");

    }





    private String saveFile(InputStream inputStream, String path){        //Проверка на существование файла!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        try{
            String pathWithoutDot=path.substring(0,path.lastIndexOf('.'));
            String fileType=path.substring((path.lastIndexOf('.')));


            int uniq=0;
            while(new File(pathWithoutDot+uniq+fileType).exists()){

                uniq++;
            }
            pathWithoutDot=pathWithoutDot+uniq;
            path=pathWithoutDot+fileType;
            //path changing
            File file=new File(path);

            try{
                file.createNewFile();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("File hasn't been created");
            }
            OutputStream outputStream=new FileOutputStream(file);
            int read;
            byte []bytes=new byte[1024];
            while((read = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return path;
    }

}
