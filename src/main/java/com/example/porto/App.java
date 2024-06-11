package com.example.porto;

import com.github.lalyos.jfiglet.FigletFont;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {

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
