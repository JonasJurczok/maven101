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