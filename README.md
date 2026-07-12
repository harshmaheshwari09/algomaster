# AlgoMaster

This repository contains solutions for problems listed on [AlgoMaster](https://algomaster.io/).

The goal is to build a structured collection of problem statements and accepted solutions that can be used for practice, review, and reference.

## Repository Structure

Problems are organized by topic and problem name:

```text
src/main/java/<topic>/<sub_topic>/<problem_name>/
├── README.md
└── Solution.java
```

Example:

```text
src/main/java/math_fundamentals/geometry/valid_square/
├── README.md
└── Solution.java
```

## Adding a Problem

When adding a new problem, start with:

- `README.md` with the source link, problem statement, examples, and constraints.
- `Solution.java` with the source-provided method template.
- A package-safe directory name using lowercase words separated by underscores.

Add solution files separately when implementing the problem.

Keep problem templates and solutions focused, readable, and aligned with the problem categories used by AlgoMaster.
