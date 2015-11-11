# Tests

One of the main tasks of a build system is to ensure that all your testa are passing. If we go back to the
[Maven lifecycle](../theory.md#maven-lifecycle) you can see two phases covering tests:

* test
* integration-test

By default the test phase will run your JUnit unit tests (if there is a JUnit dependency in your project).
The `integration-test` phase is used by plugins like the `failsafe-plugin` to run more complex tests that
usually involve deploying the artifact to an application server or starting up a database.