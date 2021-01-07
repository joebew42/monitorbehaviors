# Monitor Behaviors Example

:warning: **This is still a Work In Progress** :warning:

Hello everyone, this repository contains a reference a implementation for the concept exposed in this blog
[Monitor behaviours, not states](https://joebew42.github.io/2020/11/26/monitor-behaviours-not-states/).

The overall idea is to _describe a feature once and run different configurations of it_, with the aim to reduce the
duplication across the several test suite.

This repository contains:

- A set of acceptance tests and their various configurations:
  - For the backend API
  - For the web UI
  - For the CLI
  - For the performance test
  - For synthetic monitoring
- A simple backend API written in NodeJS that allows to:
    - Create a TODO (POST `/todos/`)
    - Get a TODO (GET `/todos/<ID>`)
    - List the TODOs (GET `/todos/`)
- A simple web UI that uses the backend API
- A simple CLI that uses the backend API

# How to run

```bash
gradle cucumber
```

It will run with a Fake client implementation.

## How to run a different client implementation

You can set the environment variable `CLIENT_IMPLEMENTATION` to choose which client to run:

- choose `fake` (default value), to run the fake implementation
- choose `restapi`, to run the Rest API client implementation

```
CLIENT_IMPLEMENTATION=restapi gradle cucumber
```

## TODO

- Create a web UI using a JavaScript framework (React, AngularJS, other)
  - The WebUI should then consume the RestAPI Backend
- Create a NodeJS application to expose the RestAPI as documented [here](https://todolist1.docs.apiary.io/).
- How it will look like when integrate [Gatling](https://gatling.io/) for load/performance test?
- [R] Review the names used to describe the `i_can_read_a_todo.feature`
- [R] Can I refactor the acceptance test to accept a list of TODO instead of using two different steps?
    - See the `i_can_list_all_the_todos.feature`
- Understand how to implement a client for Synthetic monitoring
