# No Man's Sky - Elements Guide

This is a mini-project to support the player in the game [No Man's Sky](https://www.nomanssky.com/). It is part of a suite that together for a player-aid whilst navigating through the game world.

Specifically, it is a API service that surfaces some of the elements and refiner recipes from the game, providing the data through various endpoints and having all the data pulled from a simple database. There is a [sister project for a UI](https://github.com/mike-brown/nms-elements-ui) that consumes this API and displays the data for the player.

## Why does this exist?

I wanted a small project to get to grips with the Spring Boot framework and modern Java (v22) -- whilst also having started playing the game again for the first time in a while, and so needing to remember/reference the refiner recipes for different elements.

Even though this sort of thing exists already on various wikis, it was a good problem to form some learning around.

## How did I build this?

I started simply by following the basic ["REST API in Spring" tutorial](https://spring.io/guides/gs/rest-service), then started down the path of [data persistence in Spring](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa) using [JPA as a basis](https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html) on top of a [H2 embedded database](https://www.h2database.com/html/quickstart.html) for ease.

# What's next?
* Improved README (how to run and interact)
* Tests (now that I'm out of the tech exploration phase)
* More endpoints to show the data in different ways
* Refactoring to tidy up the structure if needed