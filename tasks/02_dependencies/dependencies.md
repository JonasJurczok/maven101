# Adding Dependencies

One of the core features of Maven is to do dependency management for you. In former times you would
have to download all your dependencies yourself, copy them into your project and then modify the classpath
to actually be able to use them. Maven will take care of all of this for you.

In the folder `02_dependencies` you will find a pom file that just describes a basic project.
To make it compile you will need to add a dependency to the [guava library](https://github.com/google/guava).

If you are ready execute `mvn clean verify -Ptask2` in the root of the project and reload this page.

## Finding dependency definitions

To add a dependency to your project you need to know the three values for `groupId`, `artifactId` and `version` that
you want to use. Usually there are two main ways to find out about these values:

### The project website.
In the case of guava for example the readme actually states these information.

### The maven central index.

You can always navigate to [maven central](http://search.maven.org/) and then search for the artifact you are looking
for. In our case this would be `google guava`. After selecting a version that suits your needs the website will
show you the dependency information to add to your project.
