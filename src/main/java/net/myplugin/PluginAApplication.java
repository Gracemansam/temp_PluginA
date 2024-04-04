package net.myplugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import net.mycore.demo.PluginInterface;

@SpringBootApplication
public class PluginAApplication  implements PluginInterface {


    public PluginAApplication() {
    }
    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(PluginAApplication.class, args);
    }

    @Override

    public void start() {
        context = SpringApplication.run(PluginAApplication.class);

    }

    @Override
    public void stop() {
        if (context != null) {
            context.close();
        }
    }
}
