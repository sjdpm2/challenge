package com.telusinternational.challenge.integration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class AdminReport extends RouteBuilder {


@Override
public void configure() throws Exception {

//from("timer://foo?period=500000000000")  // Create a message every 5 seconds
	
from("quartz2://simpleTimer?cron=0+0+10+%3F+*+*")
.setHeader("subject", simple("Candidates stats"))
.setBody(simple("Report attached below."))
        .process(new AttachmentProcessor())
        .log("sending?")
        .to("smtps://smtp.gmail.com?password=smtptest2019&username=smtp.test.2019.2@gmail.com&From=user@custom.com&To=ties_dataintegration@telusinternational.com");

}

}
