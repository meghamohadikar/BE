package com.ubp.pb360.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang.CharEncoding;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class SxOrdersRoute extends RouteBuilder {
    private static final String LOG_QUERY_PARAMS = "?showHeaders=true&showExchangeId=true&showBody=true&level=DEBUG";
    private static final String CAMEL_HTTP_PATTERN = "CamelHttp*";

    // Route IDs
    public static final String DIRECT_SX_ORDERS_CANCEL_ROUTE_ID = "com.ubp.pb360.sx.order.cancel";
    public static final String DIRECT_SX_ORDERS_COMPLETE_ROUTE_ID = "com.ubp.pb360.sx.order.complete";
    public static final String DIRECT_SX_ORDERS_REMOVE_ROUTE_ID = "com.ubp.pb360.sx.order.remove";
    public static final String DIRECT_SX_ORDERS_CANCEL_POST_ROUTE_ID="com.ubp.pb360.sx.order.cancel.post";

    // DIRECT Endpoints
    public static final String DIRECT_SX_ORDERS_CANCEL = "direct:/sx-order/cancel";
    public static final String DIRECT_SX_ORDERS_COMPLETE = "direct:/sx-order/complete";
    public static final String DIRECT_SX_ORDERS_REMOVE = "direct:/sx-order/remove";
    public static final String DIRECT_SX_ORDERS_CANCEL_POST="direct:/sx-orders/cancel/post";

    @Override
    public void configure() throws Exception
    {
        from(DIRECT_SX_ORDERS_REMOVE)
                .routeId(DIRECT_SX_ORDERS_REMOVE_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDERS_REMOVE_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxorders/remove")
                .end();

        from(DIRECT_SX_ORDERS_CANCEL_POST)
                .routeId(DIRECT_SX_ORDERS_CANCEL_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDERS_CANCEL_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxorders/cancel")
                .end();

        from(DIRECT_SX_ORDERS_CANCEL)
                .routeId(DIRECT_SX_ORDERS_CANCEL_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDERS_CANCEL_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxorders/cancel")
                .end();

        from(DIRECT_SX_ORDERS_COMPLETE)
                .routeId(DIRECT_SX_ORDERS_COMPLETE_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.PUT))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDERS_COMPLETE_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxorders/complete")
                .end();
    }
}
