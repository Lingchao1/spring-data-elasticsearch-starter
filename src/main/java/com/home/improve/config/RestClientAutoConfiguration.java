package com.home.improve.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author lingchao
 * @date 2020-06-02 23:46
 **/
@Configuration
public class RestClientAutoConfiguration extends AbstractElasticsearchConfiguration {
    @Value("${spring.data.elasticsearch.hosts:localhost:9200}")
    private String hosts;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(hosts)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
