# Welcome to Maven 101

Welcome to the Maven 101 training course. This course will teach you the basics of maven and how we use it.

## Goal

The goal of this course is to give you an overview over the most important topics when using maven.
These topics are:

* Basic project setup
* Overriding properties
* Adding dependencies
* Modifying the build

## Prerequisites

To successfully complete this session you need to have the following software installed and up and running:

* [Maven](https://maven.apache.org/install.html)
* [Java8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

## Instructions

To complete this session please read the [theoretical introduction](theory.md) first.
After doing so you can find the description of the individual tasks in the tasks menu at the top.

Every single task will deal with one specific aspect of maven.
In the repository you checked out there is a folder named `tasks` that contains folders for the individual tasks
themselves.
If you think the task is completed just run a `mvn clean verify -PtaskX` in the **root** of the checked out project.
If everything goes well the corresponding task page (as well as the maven build) will give you feedback.

Also you will find a couple of `*.md` files in the task directories. They are used to generate this website so just
ignore them.

