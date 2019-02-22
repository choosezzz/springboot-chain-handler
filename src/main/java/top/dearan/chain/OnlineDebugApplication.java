package top.dearan.chain;

import top.dearan.chain.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineDebugApplication {

    public static void main(String[] args) {
         final ApplicationContext context = SpringApplication.run(OnlineDebugApplication.class, args);
        SpringUtil.setApplicationContext(context);
    }

}
