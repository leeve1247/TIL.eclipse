package kr.or.connect.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private Integer horsepower = 800;
	
	public Engine() {
		System.out.println("Engine 생성자");
	}

	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}

	public Integer getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}

}
