package ua.org.ostpc.ittools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
@RestController
public class FileUploadRestController {

    private static String UPLOAD_DIR="";

    @RequestMapping(value="/uploading", method= RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        try{
            String fileName=file.getOriginalFilename();
            String path= request.getServletContext().getRealPath("") + UPLOAD_DIR + "" + File.separator + fileName;
            saveFile(file.getInputStream(), path);
            return (path);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    private void saveFile(InputStream inputStream, String path){

        try{
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


    }

}
