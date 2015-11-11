# Properties and Defaults

As described [earlier](../theory.md#convention-over-configuration) Maven has defaults for everything.

If you try to build this project by executing `mvn clean verify -Ptask3` you will notice that these defaults are
sometimes not the best.

Luckily that is easy to fix. As explained in the theoretical background you can overwrite the properties from
the parent and the defaults by specifying them again. The way to do it is described
[here](https://maven.apache.org/pom.html#Properties).

The properties in question are `maven.compiler.source` and `maven.compiler.target` which tell the maven
system which Java version to assume for the source code and the output jar.

The task now is again to make the project build.