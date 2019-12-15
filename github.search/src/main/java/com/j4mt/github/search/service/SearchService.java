package com.j4mt.github.search.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class SearchService {

    @Value("${github.respository.uri}")
    private String uri;

    private String searchCriteria;

    public ResponseEntity<String> searchUser(String user) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri + "/users/" + user, HttpMethod.GET, entity, String.class);

        System.out.println(result);
        return result;
    }

    public String searchRepo(String repo) {
        //TODO: add restful search call here for user
        return "NOR IMPLEMENTED :  restful search call for Repository Search : " + repo;
    }

}
