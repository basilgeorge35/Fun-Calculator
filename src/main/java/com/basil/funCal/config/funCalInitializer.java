package com.basil.funCal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class funCalInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("custom Initializer.>>>>>Basil");
		
		//XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		//webApplicationContext.setConfigLocation("classpath:fc-servlet.xml");
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(funCalInitializerConfiguration.class);
		
		//create Dispatcher servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		
		
		//register Dispatcher servlet with servletContext
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
		
	}

}
