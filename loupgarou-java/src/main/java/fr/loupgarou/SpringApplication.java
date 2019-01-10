package fr.loupgarou;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.loupgarou.config.AppConfig;




public class SpringApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBeanFactory().createBean(Principale.class).run(args);
		myContext.close();
		
		}
}
