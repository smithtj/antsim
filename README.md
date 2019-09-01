# World War of Ants - Antsim

This is a simple simulation of an anthill, for the purposes of demonstrating the implementation of the observer pattern in a multithreaded environment.

Run with: 
```bash
mvn clean package exec:java
```

Here's the brief: 

( Disclaimer: don't take the logic and biology behind this example seriously. :D Also, feel totally free to play with the numbers, they very likely aren't well thought of in the first place.)

You, the ant General, have to implement a simulation about ant war and greed. Your army consists of:
* Warrior ants, which kill others and and raid enemy nests. 
* Worker ants, which place the remains and eggs in their designated chambers.
* Queen ants, which devour the aquired resources.

The warriors go out in the battlefield, and they bring back to their own nest either enemy remains, eggs, or vegetation. You are in charge of 10 warriors. Capacity per warrior for each kind of food is 2 remains, 3 eggs, and 4 vegetation. Each warrior takes 3 seconds to gather 1 food of any random kind. Once the warrior has gathered 5 in total, they go back to their nest, to drop the food off at the food pile, so the workers can take care of it.

The food pile has a capacity of 40 food. Meaning, if the capacity is reached, the warriors have to wait at the pile until there is enough space for them to drop off their food! Once they do, they go back to war and gathering.

You are in charge of 6 worker ants. Their job is to take food from the pile, and move it to either the remains chamber, eggs chamber, or vegetation chamber, depending on the kind of food that it is. If the food pile is empty, the ants will have to wait for the warriors to bring more! It takes a worker 3 seconds to move remains, 2 seconds to move eggs, and 1 second to move vegetation. 

Each chamber has a capacity of 20. If a chamber is full, the worker has to wait until there is space in it, so they can move the food!

Your nest has 3 Queens. Each queen devours between 1 to 3 food every second, from a random chamber. If there is no food in that chamber, the Queen will have to wait too!