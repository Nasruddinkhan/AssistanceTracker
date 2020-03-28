package com.mypractice.assistancetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.mypractice.assistancetracker.controller" })
public class WebConfig implements WebMvcConfigurer    {
	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp"); }
	 */

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login.do").setViewName("login");
  }
  
  @Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
  @Bean
  public InternalResourceViewResolver resolver() {
     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
     resolver.setViewClass(JstlView.class);
     resolver.setPrefix("/WEB-INF/views/pages/");
     resolver.setSuffix(".jsp");
     return resolver;
  }
  /**
   * Configure ViewResolvers to deliver preferred views.
   */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
	/*@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}*/
}
