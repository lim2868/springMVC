package language;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		kr_eng ke  =
				ctx.getBean("ke", kr_eng.class);
		ke.bb();
		
		ctx.close();

	}
}