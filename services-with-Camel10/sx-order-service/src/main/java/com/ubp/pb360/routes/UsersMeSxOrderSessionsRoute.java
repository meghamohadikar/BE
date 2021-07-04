package com.ubp.pb360.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang.CharEncoding;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class UsersMeSxOrderSessionsRoute  extends RouteBuilder {

    private static final String LOG_QUERY_PARAMS = "?showHeaders=true&showExchangeId=true&showBody=true&level=DEBUG";
    private static final String CAMEL_HTTP_PATTERN = "CamelHttp*";

    // Route IDs
    public static final String DIRECT_GET_SX_ORDER_SESSIONS_ROUTE_ID = "com.ubp.pb360.get.sx.order.sessions";

    // DIRECT Endpoints
    public static final String DIRECT_SX_ORDER_SESSIONS_GET= "direct:/get-sx-order-sessions/remove";

    @Override
    public void configure() throws Exception {
        from(DIRECT_SX_ORDER_SESSIONS_GET)
                .routeId(DIRECT_GET_SX_ORDER_SESSIONS_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.GET))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_GET_SX_ORDER_SESSIONS_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/users/me/sxordersessions")
                .end();

    }
}
