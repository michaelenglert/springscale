package com.appdynamics.sample.springscale;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;

@Controller
@EnableAutoConfiguration
public class SampleController {
    static int timeout = 4;

    @RequestMapping("/")
    @ResponseBody
    String home() throws InterruptedException {
        Map<String, String> env = System.getenv();
        if(timeout < 2){
            sleep(10000);
        }
        return Integer.toString(timeout) + " - Response!";
    }

    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        timeout = rnd.nextInt(5) + 1;
        SpringApplication.run(SampleController.class, args);
    }
}
