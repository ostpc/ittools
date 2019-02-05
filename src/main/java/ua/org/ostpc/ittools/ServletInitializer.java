package ua.org.ostpc.ittools;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ServletInitializer extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IttoolsApplication.class);
	}



	//Uploading files

//	private String TMP_FOLDER = "/tmp";
//	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
//
//	@Override
//	public void onStartup(ServletContext sc) throws ServletException {
//
//		ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", new DispatcherServlet(
//				new GenericWebApplicationContext()));
//
//		appServlet.setLoadOnStartup(1);
//
//		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
//				MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//
//		appServlet.setMultipartConfig(multipartConfigElement);
//	}
}


