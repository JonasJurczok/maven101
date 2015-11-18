# Welcome to Maven 101

Welcome to the Maven 101 training course. This course will teach you the basics of maven and how we use it.

## Goal

The goal of this course is to give you an overview over the most important topics when using maven.
Every task will deal with one specific aspect of maven.
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

First read the [theoretical introduction](theory.md).

For each task in the upper menu

1. Take a look in the specific task folder `/tasks/task_XX`
2. Modify the content of said folder to solve the task at hand
3. Execute `mvn clean verify -PtaskX` in the **root** of the checked out project
4. Reload the task page to check if the task has been completed.

Also you will find a couple of `*.md` files in the task directories. They are used to generate this website so just
ignore them.

