package com.vasslatam.sakila;

import com.vasslatam.sakila.domain.Actor;
import com.vasslatam.sakila.domain.Address;
import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.domain.Store;
import com.vasslatam.sakila.endpoint.request.ActorRequest;
import com.vasslatam.sakila.endpoint.request.CustomerRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTests.class);

    @LocalServerPort
    int randomServerPort;

    
    @Test
    @Order(1)
    void addActorTest() throws URISyntaxException {
        RestTemplate client = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/actor/";
        URI uri = new URI(baseUrl);
        ActorRequest actorRequest = new ActorRequest("LUIS", "CHAVEZ");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ActorRequest> request = new HttpEntity<>(actorRequest, headers);
        ResponseEntity<Actor> response = client.postForEntity(uri, request, Actor.class);
        assertEquals(200, response.getStatusCodeValue());
        LOGGER.info("body:{}", response.getBody());
    }
    
    @Test
    @Order(2)
    void actorTest() throws URISyntaxException {
        RestTemplate client = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/actor/";
        URI uri = new URI(baseUrl);
        ResponseEntity<List> response = client.getForEntity(uri, List.class);
        assertEquals(200, response.getStatusCodeValue());
        if (response.getBody() != null) {
            List<Map<String, ?>> list = response.getBody();
            if (list != null) {
                list.forEach((item) -> {
                    LOGGER.info("\t- {}", item);
                });
            }
        }
    }
    
    @Test
    @Order(3)
    void addCustomerTest()throws URISyntaxException{
        Store store = new Store();
        store.setStoreId(1);
        
        Address address = new Address();
        address.setAddressId(1);
        RestTemplate client = new RestTemplate();
        final String baseUrl =  "http://localhost:" + randomServerPort + "/api/customer/";
        URI uri = new URI(baseUrl);
        CustomerRequest customerRequest = new CustomerRequest(store,"LEVI","PAITA","LPAITAURETA@GMAIL.COM",
                                                address);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CustomerRequest> request = new HttpEntity<>(customerRequest,headers);
        ResponseEntity<Customer> response = client.postForEntity(uri, request, Customer.class);
        assertEquals(200, response.getStatusCode());
        LOGGER.info("body:{}", response.getBody());
        
    }
    
    @Test
    @Order(4)
    void customerTest() throws URISyntaxException{
        RestTemplate client = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/customer/";
        URI uri = new URI(baseUrl);
        ResponseEntity<List> response = client.getForEntity(uri, List.class);
        assertEquals(200, response.getStatusCodeValue());
        if(response.getBody() != null) {
            List<Map<String, ?>> list = response.getBody();
            if(list != null){
                list.forEach((item) ->{
                    LOGGER.info("\t- {}",item);
                });
            }
        }
    }
    
    

}
