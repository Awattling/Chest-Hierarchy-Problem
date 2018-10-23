# Chest-Hierarchy-Problem
Runnig Instructions: 
	- Currently running on Java version 1.8.0_121 but should run on most somewhat recent versons of java. 
	
	- If you do not have java installed on your machine please vist https://www.oracle.com/technetwork/java/javase/overview/index.html 
	and follow the installation instructions. 
	
	- Clone this repository into running directory.
	
	- If you have Java jdk installed run the command to compile (Note that most recent compiled version is avalible in this repository): Javac *.java
	
	- Run program: Java Main
	
Process, decisions and features: 
	- I was given a tree type structure and how it should behave. I decided to implement my own tree structure instead of utilizing some of the premade java libraries
	as it would make the behaviors requested easy to implement. This also served to keep the overall weight and efficiency of the program a little bit better. 

	- I decided to implement the interface with Java swing libraries and gridbaglayout. This made the application a little more interactive than a text only interface. 
	
	- The GUI window operates in a seperate thread from the main program body. This is a choice I made to make future versions of the program more usable. It
	can be adapted to recieve requests from other bodies, perform lengthy calculations etc without interrupting the opertaion of the UI. 
	
	- The UI is independent of the tree. Any changes to the tree structure will be displayed in the UI without need for significant changes.

Other Things: 
	- Here are some ideas I played with and some of the things I learned doing this project. 
	
	- The words indicated have meaning. Lungs, Heart, Chest, etc.. are all things that can be recognized and identified within the human body. The UI does little to
	highlight this meaning. I played with the idea of having 2D pictures overlay eachother to mirror what parts of the body were selected. I branched off and did some
	testing and playing but found the Gridbaglayout and Java Swing in general to behave poorly with images. In the future if I'm going to do this I don't think I would
	choose to do this in Java. I would do some investigation into pythons Tkinter or a web interface to achieve this. There are ways to force Java to behave how I invisioned 
	but I believe there are better ways.

	- In the future I would love to load the tree structure from an external source such as a text file. The UI is built to handle dynamic trees and can even change them during
	runtime. This change would allow the application to potentially serve multiple purposes and refactor quite easily. 
	
	
	