package com.ll.exam.app__2022_10_11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
// @EnableJpaAuditing은 Entity를 기획할 때 모든 엔티티에 들어가는 공통 컬럼들이 있는데 (ex. 등록일자, 수정일자 등) 공통 Entity를 뽑아내서 사용하고자 할 때 사용한다.
@EnableJpaAuditing
public class App20221011Application {

	public static void main(String[] args) {
		SpringApplication.run(App20221011Application.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// BCryptPasswordEncoder는 BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 인코딩해주는 메서드와 사용자의 의해 제출된 비밀번호와 저장소에 저장되어 있는 비밀번호의 일치 여부를 확인해주는 메서드를 제공한다ㄴ.
		return new BCryptPasswordEncoder();
	}

}
