package kr.or.connect.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.or.connect.guestbook.controller"})
public class WebMvcContextConfiguration implements WebMvcConfigurer{
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
		//addResourceHandler에 설정된 요청을, addResourceLocations 에서 설정된 디렉토리 위치에서 찾는다.
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//configurer.enable(); 함으로써 매핑정보가 없는 url 요청을 configureDefaultServletHandling(DefaultServletHttpRequsetHandler)가 처리하는데,
	// 이러한 처리를 configurer.enable()하지 않으면 못한다.
	// 이런 부분들을 설정하게 함으로써 매핑이 없는 URL이 넘어왔을 때 WAS의 default servlet이 static 한 자원을 읽어서 보여줄 수 있게끔 해준다.
	
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		//addViewControllers : (특정 URL에 대한 처리를) 컨트롤러 클래스를 작성하지 않아도 매핑할 수 있도록 한다.
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("index");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
