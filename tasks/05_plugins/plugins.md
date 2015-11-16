# Plugins

So far we have seen how to overwrite properties, add dependencies and how the integration with tests works.
One other large aspect of maven is the versatility of the ecosystem. For the most basic java projects the knowledge
you accumulated so far might be sufficient. But most of our projects are not basic... To build them we have to

## Modify the build

To change or extend the way maven is building your project you can add plugins to the build. Plugins are also
identified like artifacts (groupId, artifactId, version) but instead of just adding code to your classpath
maven will execute them according to their configuration.

## Plugin categories
Configuration wise plugins split into two groups.

### Adding capabilities
Adding capabilities is dead easy, just add the plugin to the build tag. The prime example here is the
[Tomcat Maven plugin](http://tomcat.apache.org/maven-plugin.html). It is used to add a tomcat webserver to your
project that you can fire up and deploy your application to with just one command.

If you just add this plugin to your build like this
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.tomcat.maven</groupId>
      <artifactId>tomcat6-maven-plugin</artifactId>
      <version>2.3-SNAPSHOT</version>
    </plugin>
  </plugins>
</build>
```
It will do nothing on its own but give you access to the plugin specific goals like `mvn tomcat:run-war`.

### Changing the behaviour of the build
The second category of plugins are the ones that actually modify the way the build behaves. The prime example
for this category is the [Maven failsafe plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) which
is used to run your integration test. The configuration for using this plugin looks like this:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-failsafe-plugin</artifactId>
      <version>2.19</version>
      <executions>
        <execution>
          <phase>integration-test>
          <goals>
            <goal>verify</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

This configuration binds to the `integration-test` phase and tells maven to call the `verify` goal of the plugin.
With this mechanism you can now change all kinds of things, be it running SQL scripts against databases, compile C code,
generate documentation websites etc.

## Task

To complete this task you will have to make the same change as in the [properties](../03_properties/properties.md) task;
change the java version to java 8. But this time it should be done by adding the
[Maven Compiler plugin](https://maven.apache.org/plugins/maven-compiler-plugin/). If you are ready just run
`mvn clean verify -Ptask5` as always.