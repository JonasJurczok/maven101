# Webapps

Most of the applications we are building here are deployed webapps. If you provide internal websites or just
REST endpoints, you will need a webserver of some kind. To transoform a maven project into a web application
is really easy. Just perform the following steps and then run `mvn clean verify -Ptask6`.

## Packaging

First you have to overwrite the `packaging` attribute of your project. The default is `jar` but if you switch it
to `war` maven will produce a webapp package instead all setup according to the standard
(dependencies as jars in a lib folder, etc.).

## actual webapp

Of course you also need a real webapp to deploy. You will find a small hello world website in the task folder.

The important part here is the folder structure (again convention over configuration). You will find the page
in the webapp folder.

```
project-home
  |--- src
        |--- main
              |--- java
              |--- webapp
                    |--- WEB-INF
                    |     |--- web.xml
                    |--- index.html
```

## Test the app

To test the application you would now have to build and run it. In former times you would have produced the
packaged app, copy it to your application server and then start it. Thanks to maven this is no longer necessary.
As described in the plugins section please add the [Tomcat Maven plugin](http://tomcat.apache.org/maven-plugin-2.2/)
to the project and run the app with `mvn clean tomcat:run-war`. Then navigate to `localhost:8080XXXX` and check
if the app is showing correctly.