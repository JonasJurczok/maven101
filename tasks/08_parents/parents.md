# Parents

As already described before maven has defaults for everything. This is partially achieved by having poms
inherit from each other. This works the same way as inheritance in Java. If you do not specify a parent
explicitly your pom will automatically inherit from the maven internal super pom. Exactly the same way as
your Java objects inherit from Object.

## Speficy a parent

Parents are also identiefied by `groupId`, `artifactId` and `version`. Additionally you should provide a
`relativePath` attribute which can be used to tell maven where to find the parent. If your parent is not
in the same folder structure it should just be left empty. The parent can be specified anywhere in the
`project` tag of your pom.

## The task

The task is again to get the maven build to modify this page and mark it as completed. The logic to do this
 is in the `pom.xml` in the root of the project. As in the last task the properties needed to modify the
 page are in the file `/tasks/08_parents/pom.xml`. To get the task done add the pom from the root of the
 project as a parent to the pom from the task. Then execute a `mvn clean verify` in the **task folder**.
 If everything has been set up right the website should show the green checkmark again.

## Dependency- and Pluginmanagement

There are two special tags for parents that you should be aware of `dependencyManagement` and `pluginManagement`.

They change the way maven inherits from your parent.

If you just add dependencies in your parent with the `dependencies` tag they will automatically be included
into your child project. This will lead to a lot of bloat. In contrast to that the `dependencyManagement`
just **offers** dependencies to your child. You still have to specify them as usual and just can omit info
already provided in the parent (like the version).

The same thing is true for plugins. If you just use the `plugins` tag they will be executed for all childs.
If you use `pluginManagement` they are just offered.