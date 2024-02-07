package com.example.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class EjemploGobalFilter implements GlobalFilter {

    private final Logger logger = LoggerFactory.getLogger(EjemploGobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("ejecutando filtro pre");
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            logger.info("ejecutando filtro post");
            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color","rojo").build());
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }
    
}
