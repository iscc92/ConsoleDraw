#Console Draw
This is a simple implementation of a Console Drawing command app, using Java8, Maven and Junit library. 
It is possible to visualize a geometric entity at each time. 


## Instructions

Insert the following command on the command line to explore the functionalities provided by Console Drawing app.

### * Canvas * 
Insert ````C h w```` to obtain a Canvas with ```h``` units of height ```w``` units of width.

### * Line *
Insert ````L x1 y1 x2 y2```` to obtain a Line from ```(x1,y1)``` to ```(x2,y2)```, identified by character ```x```.
Not that diagonal lines are not supported in the current version.

### * Rectangle *
Insert ````R x1 y1 x2 y2```` to obtain a Rectangle with Upper Left corner ```(x1,y1)```, and Lower Right corner as  ```(x2,y2)```, 
whose  edge is identified by character ```x```.

### * Quit *
Insert ```Q``` to Quit the program.

## Setup
To build the app, run the following command on command line (this will run the tests automatically:
    ```mvn clean install``` 
    
To only run tests, run the following command on command line:
        ```mvn test``` 
