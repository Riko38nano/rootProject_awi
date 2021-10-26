package project.awi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    public HashMap<String, String> get() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("version", appVersion);
        return hashMap;
    }


}
