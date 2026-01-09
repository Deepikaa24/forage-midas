package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IncentiveClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public IncentiveClient(
            RestTemplate restTemplate,
            @Value("${incentive.api.base-url}") String baseUrl
    ) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public Incentive fetchIncentive(Transaction transaction) {
        return restTemplate.postForObject(
                baseUrl + "/incentive",
                transaction,
                Incentive.class
        );
    }
}

