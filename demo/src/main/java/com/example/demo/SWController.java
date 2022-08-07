package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("swapi")
public class SWController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getSWCharacter(@PathVariable int id) {
        System.out.println("The requested id is: " + id);
        String url = "https://swapi.dev/api/people/" + id;
        ResponseEntity<Character> resp = restTemplate.getForEntity(url, Character.class);
        //String resp = restTemplate.getForObject(url, String.class);

        System.out.println(resp);
        return ResponseEntity.ok(resp);
    }
}
