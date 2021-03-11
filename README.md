Simple Spring Boot application to learn how to send emails.
It has only few endpoints that allow you to send emails via different methods. On of them is to send to default values defined in IntelliJ Environment Variables. You can access that via that endpoint:

```
localhost:8080/send
```

There are also three other ways to send emails to specified emails with specified text and subject. They are:
 
 * By params

You can send email and specify everything at endpoit '/send/params' after '?' in a format 'argument=value' and separated by '&'. Here's example:

```
 http://localhost:8080/send/params?to=example@gmail.com&subject=exampletopic&text=exapmpletext&html=true 
```

 * By path

You can send email and specify everything at endpoit '/send/path/{to}/{subject}/{text}/{html}' by replacing every attribute in brackets by the actual value. Here's example:

```
 http://localhost:8080/send/path/example@gmail.com/exampletopic/exampletext/true
```

 * By body

You can send email and specify everything at endpoit '/send/body' by sending JSON in the body of the request with all the necessary values. Here's example:

```
 http://localhost:8080/send/body


JSON:

{
    "to": "example@gmail.com",
    "subject": "exampletopic",
    "text": "exampletext",
    "isHtmlContent": true 
}

 ```
