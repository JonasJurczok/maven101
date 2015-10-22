# Theoretical introduction

This page will give you a short theoretical overview about maven.
As it is an Apache project there is extensive documentation available
under [https://maven.apache.org/](https://maven.apache.org/).

## What is a build tool?

Maven is basically "just another build tool".
Build tools take care of the more tedious tasks of software development.

### Dependency management
In former times you would download your dependencies yourself, extract them to your project and then modify the classpath manually to use them.
Build tools take care of this for you. You just specify the dependencies and the tool downloads and integrates them.

### Testing
Buildtools also take care of your tests. As soon as you initiate a build the tool will run your tests
for you and then give you feedback if your tests succeeded. If not it will also prevent the creation of a build result
so that you cannot ship a broken application by accident.

### Deployable artifacts

The tool will also give you a deployable artifact in the end. With this mechanism you can take the result of the build
and ship it right away. This is essential for a continuous delivery pipeline.

## Maven specific details


### Identifying artifacts

Maven calls the result of a build an Artifact. This can be anything, from the standard jar over the documentation zip files
up to binaries. The only thing that matters is that it is some file that can be identified.

To identify and share an artifact maven uses three distinct values.

* the groupId
* the artifactId
* the version

#### groupId

The groupId is defining a group of artifacts like package names in Java. They also follow the same conventions of
backwards domains. If you want to build something for the Zalando Mentoring for example, the groupId might be

```
de.zalando.mentoring
```

#### artifactId

The artifactId serves the same function as a Java class name. It is a unique identifier within a group of artifacts.
To stick to the example from above a typical artifactId for the mentoring project could be

```
maven-101
```

### Versioning

The version is actually just a string. So in theory you could put whatever you want here. It is highly recommended
though to stick to a versioning scheme that is easily readable like [semantic versioning](http://semver.org/).

**Important:**

> Versions have to be unique on any given repository. To circumvent that you can append the String '-SNAPSHOT' to your version.
> This will tell maven to treat the version as non unique.

> This has implications though:

> Referencing a snapshot version as a dependency does not guarantee anything! Everything can change from one build to the next!

### Storing and sharing artifacts

We have seen the three identifiers of an artifact now. But how do they play together?

As written before the main reason for using a build tool is to get rid of downloading dependencies manually. To
achieve this maven stores all artifacts in repositories. A repository is basically a server that can be accessed via
HTTP. All artifacts are identified by the triplet described before. The groupId describes the folder, the artifactId
the filename and the version the version suffix of the desired artifact.

The interesting part about this is that the maven server makes sure that versions are unique. If you push `de.zalando
.mentoring:maven-101:0.0.1` to a repository this version is taken and can not be overwritten. This guarantees that
everyone who references this artifact as a dependency will receive the exact same file every single time. Therefore
maven is really reliable (unless the repository is shut down of course :) ).

Of course there are scenarios where this behaviour is not desired. To circumvent the uniqueness of an artifact you can
append `-SNAPSHOT` to your version. This removes the unique constraint and the artifact can be overwritten. This
should be handled with care as a SNAPSHOT dependency can change drastically, possibly breaking contracts, on every
single update!

**Important:**
> Maven uses a local cache in your home/.m2 directory. As this is a local directory which belongs to you, you can do
whatever you want there. If you issue a maven install into your local cache you can overwrite everything, breaking
the uniqueness of your artifact version and therefore potentially diverge your local dependencies from the one in the
 repo. This leads to interesting "works on my machine" situations that you want to avoid!

### Maven lifecycle

In the previous section we briefly mentioned `maven install`. This section will explain the details behind this.

Every maven build follows the so called [maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

To understand the lifecycle we first have to define some words:

* goal
* phase

A `goal` is basically a command that you can issue to maven or one of the plugins used.

A `phase` is one `goal` in the lifecycle; the lifecycle consists of many `phases`.

The full maven lifecycle looks like this:

* `validate` - validate the project is correct and all necessary information is available
* `compile` - compile the source code of the project
* `test` - test the compiled source code using a suitable unit testing framework. These tests should not require the
 code be packaged or deployed
* `package` - take the compiled code and package it in its distributable format, such as a JAR.
* `integration-test` - process and deploy the package if necessary into an environment where integration tests can be run
* `verify` - run any checks to verify the package is valid and meets quality criteria
* `install` - install the package into the local repository, for use as a dependency in other projects locally
* `deploy` - done in an integration or release environment, copies the final package to the remote repository for
sharing with other developers and projects.

One additional command is the `clean` command which just deletes the target directory.

The important part about the lifecycle is that the goals depend on each other. If you issue the `verify` command for
example, maven will issue all commands up to `verify` automatically. Therefore you don't have to take care about the
project being compiled before you verify it. Maven will make sure that you are always doing the intuitive thing.

Also you can chain commands together. E.g. you can type `mvn clean verify` which will first delete all remaining
files from the previous builds and then build and verify the current state of the project.

### Convention over configuration