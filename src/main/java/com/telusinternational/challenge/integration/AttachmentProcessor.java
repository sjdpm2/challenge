package com.telusinternational.challenge.integration;

import java.net.MalformedURLException;
import java.net.URL;
import javax.activation.DataHandler;
import javax.activation.URLDataSource;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class AttachmentProcessor implements Processor {

 @Override
 public void process(Exchange exchange) throws MalformedURLException{
  Message in = exchange.getIn();

URL u = new URL("http://localhost:8080/api/report/candidates");

new DataHandler(new URLDataSource(u));
in.addAttachment("report.json", new DataHandler(new URLDataSource(u)));
 }
}