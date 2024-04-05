package net.myplugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import net.mycore.demo.PluginInterface;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
@Component
public class PluginAApplication  implements PluginInterface {

    private final String id;

    public PluginAApplication() {
        this.id = UUID.randomUUID().toString();
    }


//    public PluginAApplication() {
//    }
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ConfigurableApplicationContext getApplicationContext() {
        return context;
    }


}
