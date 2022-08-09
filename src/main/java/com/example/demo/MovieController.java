package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("movieSearch")
public class MovieController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value="/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMovie(@PathVariable String title) {
        System.out.println("The requested title is: " + title);
        String url = "http://www.omdbapi.com/?apikey=12b87e4f&" + "t=" + title;
        String resp = restTemplate.getForObject(url, String.class);

        System.out.println(resp);
        return ResponseEntity.ok(resp);
    }
}
