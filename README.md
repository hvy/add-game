# The Add Game

## About
This is an implementation of a game inspired by the Add-1 Game explained in the Book [Thinking, Fast and Slow by Daniel Kahneman](https://en.wikipedia.org/wiki/Thinking,_Fast_and_Slow) in the section PART I. Two Systems - 2. Attention and Effort. Daniel Kahneman is a psychologist in the field decision making and received the Nobel Memorial Prize in Economic Sciences in 2002. The book itself was written in 2011.

### Rules
The game is round based an the goal is to survive as many rounds as possible. In the beginning of each round, four digits are displayed on the screen x<sub>i</sub>, i = 1,2,3,4. The player needs to quickly, within a few seconds enter a new sequence of digits x'<sub>i</sub> where x'<sub>i</sub> = x<sub>i</sub> + X mod 10 where X = 1 in the Add-1 game but could be changed to any positive number.

## Installation
### Prerequisites
* [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven](https://maven.apache.org) *Tested with Maven 3.3.9*

### Installation
Run the following commands to clone the repository and install the game in the current working directory.
```
git clone https://github.com/hvy/add-game.git
cd add-game
mvn install
```

### Run
Assuming that the installation was successful, run the following commands to start the game.
```
cd target
java -jar add-game-1.0-SNAPSHOT.jar
```
