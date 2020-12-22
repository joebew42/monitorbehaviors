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
- A simple backend API written in Elixir that allows to:
    - Create a TODO (POST `/todos/`)
    - Get a TODO (GET `/todos/<ID>`)
    - List the TODOs (GET `/todos/`)
- A simple web UI that uses the backend API
- A simple CLI that uses the backend API

# How to run

```bash
gradle cucumber
```


