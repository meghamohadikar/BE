package com.ubp.pb360.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMethods;
import org.apache.commons.lang.CharEncoding;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class SxOrderSessionsRoute extends RouteBuilder {

    private static final String LOG_QUERY_PARAMS = "?showHeaders=true&showExchangeId=true&showBody=true&level=DEBUG";
    private static final String CAMEL_HTTP_PATTERN = "CamelHttp*";

    // Route IDs
    public static final String DIRECT_SXORDER_SESSIONS_WARNINGS_CLARIFY_POST_ROUTE_ID="com.ubp.pb360.sx.order.session.warnings.clarify.post";
    public static final String DIRECT_SXORDER_SESSIONS_WARNINGS_GET_ROUTE_ID="com.ubp.pb360.sx.order.session.warnings.get";
    public static final String DIRECT_SX_ORDER_POST_ROUTE_ID="com.ubp.pb360.sx.order.session.post";
    public static final String DIRECT_SX_ORDER_SESSIONS_REMOVE_POST_ROUTE_ID = "com.ubp.pb360.sx.order.session.remove.post";
    public static final String DIRECT_SX_ORDER_SESSIONS_INIT_POST_ROUTE_ID = "com.ubp.pb360.sx.order.session.init.post";
    public static final String DIRECT_SX_ORDER_SESSIONS_ID_CONTROL_PUT_ROUTE_ID = "com.ubp.pb360.sx.order.session.control.put";
    public static final String DIRECT_SX_ORDER_INIT_POST_ROUTE_ID = "com.ubp.pb360.sx.order.sessions.sx.order.init.post";
    public static final String DIRECT_SX_ORDER_COMPLETE_POST_ROUTE_ID = "com.ubp.pb360.sx.order.sessions.sx.order.complete.post";
    public static final String DIRECT_SX_ORDER_SESSION_EXECUTE_POST_ROUTE_ID = "com.ubp.pb360.api.execute.post";
    // DIRECT Endpoints
    public static final String DIRECT_SXORDER_SESSIONS_WARNINGS_CLARIFY_POST="direct:/sx-order-session/warnings/clarify/post";
    public static final String DIRECT_SXORDER_SESSIONS_WARNINGS_GET="direct:/sx-order-session/warnings/get";
    public static final String DIRECT_SX_ORDER_POST="direct:/sx-order-session/post";
    public static final String DIRECT_SX_ORDER_SESSIONS_REMOVE_POST = "direct:/sx-order-session/remove/post";
    public static final String DIRECT_SX_ORDER_SESSIONS_INIT_POST = "direct:/sx-order-session/init/post";
    public static final String DIRECT_SX_ORDER_SESSIONS_ID_CONTROL_PUT = "direct:/sx-order-session/control/put";
    public static final String DIRECT_SX_ORDER_INIT_POST = "direct:/sx-order/init/post";
    public static final String DIRECT_SX_ORDER_COMPLETE_POST = "direct:/sx-order/complete/post";
    public static final String DIRECT_SX_ORDER_SESSION_EXECUTE_POST = "direct:api/sxordersession/execute/post";

    @Override
    public void configure() throws Exception {
        from(DIRECT_SX_ORDER_SESSIONS_REMOVE_POST)
                .routeId(DIRECT_SX_ORDER_SESSIONS_REMOVE_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_SESSIONS_REMOVE_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/remove")
                .end();

        from(DIRECT_SX_ORDER_SESSIONS_INIT_POST)
                .routeId(DIRECT_SX_ORDER_SESSIONS_INIT_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_SESSIONS_INIT_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/init")
                .end();

        from(DIRECT_SX_ORDER_SESSIONS_ID_CONTROL_PUT)
                .routeId(DIRECT_SX_ORDER_SESSIONS_ID_CONTROL_PUT_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.PUT))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_SESSIONS_ID_CONTROL_PUT_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}/control")
                .end();

        from(DIRECT_SX_ORDER_INIT_POST)
                .routeId(DIRECT_SX_ORDER_INIT_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_INIT_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .toD("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}/sxorders/init")
                .end();

        from(DIRECT_SX_ORDER_COMPLETE_POST)
                .routeId(DIRECT_SX_ORDER_COMPLETE_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_COMPLETE_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .toD("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}/sxorder/complete")
                .end();

        from(DIRECT_SX_ORDER_SESSION_EXECUTE_POST)
                .routeId(DIRECT_SX_ORDER_SESSION_EXECUTE_POST_ROUTE_ID)
                .removeHeaders("CamelHttp*", Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_SESSION_EXECUTE_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}/execute")
                .end();

        from(DIRECT_SX_ORDER_POST)
                .routeId(DIRECT_SX_ORDER_POST_ROUTE_ID)
                .removeHeaders("CamelHttp*", Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(RequestMethod.POST))
                .setHeader(HttpHeaders.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(HttpHeaders.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader(HttpHeaders.ACCEPT, constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:" + DIRECT_SX_ORDER_POST_ROUTE_ID + LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}")
                .end();

        from(DIRECT_SXORDER_SESSIONS_WARNINGS_GET)
                .routeId(DIRECT_SXORDER_SESSIONS_WARNINGS_GET_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader(Exchange.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(Exchange.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader("Accept", constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:"+DIRECT_SXORDER_SESSIONS_WARNINGS_GET_ROUTE_ID+ LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/${header.sxOrderSessionId}/warnings")
                .end();

        from(DIRECT_SXORDER_SESSIONS_WARNINGS_CLARIFY_POST)
                .routeId(DIRECT_SXORDER_SESSIONS_WARNINGS_CLARIFY_POST_ROUTE_ID)
                .removeHeaders(CAMEL_HTTP_PATTERN, Exchange.HTTP_METHOD, Exchange.HTTP_QUERY)
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .setHeader(Exchange.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .setHeader(Exchange.CONTENT_ENCODING, constant(CharEncoding.UTF_8))
                .setHeader("Accept", constant(MediaType.APPLICATION_JSON_VALUE))
                .to("log:"+DIRECT_SXORDER_SESSIONS_WARNINGS_CLARIFY_POST_ROUTE_ID+ LOG_QUERY_PARAMS)
                .to("{{pms-api.protocol}}://{{pms-api.host}}:{{pms-api.port}}/{{pms-api.context}}/sxordersessions/{sxOrderSessionId}/warnings/clarify")
                .end();
    }
}

