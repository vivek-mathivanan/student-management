package com.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		Class[] config = {ApplicationConfiguration.class};
		
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		
		String[] mappings = {"/"};
		
		return mappings;
	}

	

}
