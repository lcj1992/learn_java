package com.demo;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.naming.spi.ObjectFactory;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-06-21T16:12:37.120+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://demo.com/", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorld {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHiToUser", targetNamespace = "http://demo.com/", className = "com.demo.SayHiToUser")
    @WebMethod
    @ResponseWrapper(localName = "sayHiToUserResponse", targetNamespace = "http://demo.com/", className = "com.demo.SayHiToUserResponse")
    public java.lang.String sayHiToUser(
        @WebParam(name = "arg0", targetNamespace = "")
        com.demo.User arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "SayHiToUserList", targetNamespace = "http://demo.com/", className = "com.demo.SayHiToUserList")
    @WebMethod(operationName = "SayHiToUserList")
    @ResponseWrapper(localName = "SayHiToUserListResponse", targetNamespace = "http://demo.com/", className = "com.demo.SayHiToUserListResponse")
    public java.util.List<java.lang.String> sayHiToUserList(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.demo.User> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://demo.com/", className = "com.demo.SayHi")
    @WebMethod
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://demo.com/", className = "com.demo.SayHiResponse")
    public java.lang.String sayHi(
        @WebParam(name = "text", targetNamespace = "")
        java.lang.String text
    );
}