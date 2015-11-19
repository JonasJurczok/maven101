# Profiles

Profiles give you the option to hide specific configuration behind a name. The standard example for this
is the integration-test profile. Usually you don't want to run all your integration tests on every build as they
tend to run long. To avoid this hide all the integration test related config in a profile and only activate
it when it is needed (during CI builds for example).

For more details see the official documentation on profiles
[here](http://maven.apache.org/guides/introduction/introduction-to-profiles.html).

## Task

For this task you will have to modify not the pom in the task folder but the
one in the root. First take a look into it and familiarize yourself with the existing
profiles. You will see that every profile needs three properties to run properly.
In `/tasks/07_profiles/pom.xml` you will find all the needed properties.

To use them you will have to modify the profile below `task6`. It will need
a name so that you can activate it with a command line parameter.
Also it needs a reference to the tasks pom to also load the content and with
it the properties.

If you did this again run `mvn clean verify -Ptask7` in the root of the project.
If everything was done right the build should be successfull and you will see
the green checkmark on the task.

