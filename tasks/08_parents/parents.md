# Parents

As already described before maven has defaults for everything. This is partially achieved by having poms
inherit from each other. This works the same way as inheritance in Java. If you do not specify a parent
explicitly your pom will automatically inherit from the maven internal super pom. Exactly the same way as
your Java objects inherit from Object.

## Speficy a parent

Parents are also identiefied by `groupId`, `artifactId` and `version`. You can put a parent tag everywhere
 in your project tag.