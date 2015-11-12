# Tests

One of the main tasks of a build system is to ensure that all your testa are passing. If we go back to the
[Maven lifecycle](../theory.md#maven-lifecycle) you can see two phases covering tests:

* test
* integration-test

By default the test phase will run your JUnit unit tests (if there is a JUnit dependency in your project).
The `integration-test` phase is used by plugins like the `failsafe-plugin` to run more complex tests that
usually involve deploying the artifact to an application server or starting up a database.

The interesting aspect of this is that your build will fail if your tests fail, thus preventing you from
receiving an artifact in the end. This way you cannot (even by accident or thorugh an automated pipeline) deploy
something that has failing tests. **This of course only works if your tests cover all your use cases ;)**

Again, the task is to make the project build work using `mvn clean verify -Ptask4`.
Also verify that you see why it is failing in the first place and also check the target folder
to see what it looks like when the build stops at some point.

## Further reading

If you want to enhance your knowledge on this topic we highly recommend to start reading about the
[Maven surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/) and the
[Maven failsafe plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) as they are the basis for
all extended testing.