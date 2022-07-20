package com.currency_exchange.circuitbreakcont;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import io.github.resilience4j.retry.annotation.Retry;



@RestController
public class CircuitBreakerController
{
    private Logger logger=
            LoggerFactory.getLogger(CircuitBreakerController.class);


    @GetMapping("/sample-api")
   //@Retry(name = "sample-api",fallbackMethod = "fallbackMethod")
   @CircuitBreaker(name = "default",fallbackMethod = "fallbackMethod")
    @RateLimiter(name = "default")
    //10s =>1000 calls to the sample api
    @Bulkhead(name ="sample-api")
    public String sampleApi()
    {
        logger.info("sample api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9292/some-dummy-url",
//                String.class);
//      //  System.out.println("in class");
//        return forEntity.getBody();
        return "sample-api";
    }
    public String fallbackMethod(Exception ex)
    {
        return "fallback-response";
    }
}
