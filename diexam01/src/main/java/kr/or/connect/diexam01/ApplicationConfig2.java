package kr.or.connect.diexam01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
//@componentscan 사용자가 일일이 알려주지 않아도, annotation을 찾아서 알아서 등록해라. (굉장히광범위하므로, scan할 위치를 특정해주는게 좋다.)
public class ApplicationConfig2 {
	
}
