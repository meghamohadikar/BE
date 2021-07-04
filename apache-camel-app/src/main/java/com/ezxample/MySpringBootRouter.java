package com.ezxample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}").routeId("hello")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
                .to("log:{{timer.period}}")
            .end()
            .to("stream:out");
        
        /*@Override
        public void configure() {
            from("queue:a").filter(header("foo").isEqualTo("bar")).to("queue:b");
            from("queue:c").choice()
                    .when(header("foo").isEqualTo("bar")).to("queue:d")
                    .when(header("foo").isEqualTo("cheese")).to("queue:e")
                    .otherwise().to("queue:f");
        }
    }*/

}
