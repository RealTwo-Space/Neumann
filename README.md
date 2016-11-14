# Project - Neumann 
This project includes: (libraries)

| Approssi | Bravoplot | Congraph | DrDeep | Evaris |
| :------: | :-------: | :------: | :----: | :----: |
| Numerical Calculation | Graphics | Data Flow Graph | Machine Learning | Algebra |

## Build Status

| master | dev |
|:------:|:---:|
| [![Build Status](https://travis-ci.org/RealTwo-Space/Neumann.svg?branch=master)](https://travis-ci.org/RealTwo-Space/Neumann) |  [![Build Status](https://travis-ci.org/RealTwo-Space/Neumann.svg?branch=dev)](https://travis-ci.org/RealTwo-Space/Neumann)   |

Compatible with Java7 and Java8
## Test Environment
- Travis CI
- JUnit 4.12

## Update Flow

### Develop
1. create your branch from dev. (branch name - dev/branchname)
2. develop on the branch.
3. push your branch.
4. create pull request to dev branch with reviewer.
5. if through test case and code review, udpate is done.

### Release
1. create a release branch from dev.
2. fix, refactor, and adjust for release.
3. test and code review, then push.
4. create pull request to dev and master branch with reviewer.
5. if through test case and code review, update is done.

### When Push
1. Check your branch latest version.
2. Check your checked out branch correct.

## Construct Development Environment
When we develop this project, we are using IDE - [IntelliJ](https://www.jetbrains.com/idea/). 
We recommend you to use IntelliJ if you collaborate with us.
Of course, you can use the other IDE like Eclipse.

Here, how to construct environment with IntelliJ
- download and unzip this [zip](https://github.com/RealTwo-Space/Neumann/archive/dev.zip) or in terminal,

```
$ git clone https://github.com/RealTwo-Space/Neumann.git
```

- boot IntelliJ

- click File \-\> Open on the menu.

- select Neumann folder

- click file \-\> Project Structure...

- Project Settings \-\> Project \-\> Project SDK \-\> select java SDK (We are using jdk 1.8)

- Project settings \-\> Module \-\> Dependencies \-\> add new library and includes jUnit4 and hamcrest-core in the lib folder to the library.

[more information](https://github.com/RealTwo-Space/Information)
