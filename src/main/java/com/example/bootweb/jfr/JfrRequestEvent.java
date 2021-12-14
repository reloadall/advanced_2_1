package com.example.bootweb.jfr;

import jdk.jfr.*;

@Name("Request")
@Label("HTTP Request")
@Category({"HTTP", "Request"})
public class JfrRequestEvent extends Event{
    @Label("HTTP method")
    public String method;

    @Label("Url")
    public String url;

    @Label("HTTP Body Size")
    @DataAmount
    public long size;
}
