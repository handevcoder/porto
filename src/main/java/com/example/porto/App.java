package com.example.porto;

import com.example.porto.mvc.repository.UserRepository;
import com.github.lalyos.jfiglet.FigletFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
public class App {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(App.class);
        app.setBanner((environment, sourceClass, out) -> {
            String fontName = "<<H@ND3VCOD3R>>";
            String asciiArt = null;
            try {
                asciiArt = FigletFont.convertOneLine(fontName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.println(asciiArt);
        });
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
//        System.out.println(UUID.randomUUID());
    }

}
