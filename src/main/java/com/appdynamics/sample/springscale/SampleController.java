package com.appdynamics.sample.springscale;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Thread.sleep;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() throws InterruptedException {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if(envName.equals("TIMEOUT")){
                System.out.format("%s=%s%n",
                        envName,
                        env.get(envName));
                sleep(Integer.parseInt(env.get(envName)));
            }
        }
        return "Response!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
