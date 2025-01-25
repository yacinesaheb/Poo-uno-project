# POO -1- PROJECT : Developing a Text-Based UNO Game
----------------------------------------------------------------------------------------------------------------------------------------------------------------

## PROJECT STRUCTURE :
- Text-Based interface with choice of number/type of players, display of the human players hands, separation between every turn ....
- Card class that manages every Card and its special effect, including Wild cards.
- Pile class that manages the deck and the discard pile with both a unique constructor. Contains every method to interact with both.
- Player class that manages every action a player can do (Human or robot, with easy and medium difficulty for robots). It also manages the whole playing process like the ability or not to play a card, draw a card ....
- Game class that manages adding players, distributing cards in the beginning of the game, turn succession, determining ranking of players depending on when they're out of the game.

## Game rules we followed to make our project :
- The game is for 2-4 players that can be either humans or robots. Robot can be set to easy difficulty or medium.
- The game stops whenever there is only one player left in the game. A player leaves the game as a winner if he has no more cards. There are no points system or whatever.
- The first Card to be played is played by the first player. He can play what he wishes to play except the WildDrawFourCard (yes he can play the wild card although it's not the smartest move but that's up to the player).
- If a player had at least one playable card , he has to play it and has no right to pass his turn.
- The Wild Draw Four card can only be played if it's the only playable hand in the card of the player.
- A player draws only one card if he can't play, and if the drawn card matches the discardPileTopCard , he plays it.
- At any time during the game, if the Draw Pile becomes depleted and no one has yet won the round, we take the discardPile, shuffle it, and turn it over to regenerate a new Deck. 
- For two players , the Reverse card that works as a skip card. 
- The Draw two and draw four cards makes the drawing player skip his turn.

## Classes :  *(Not so brief report explaining the class structure & how key design decisions align with OOP principles )*

#### Card class :
- Mother class Card has 6 daughter classes : ** RegularCard / ReverseCard / SkipCard / DrawTwoCard / WildCard / WildDrawFour**.
- Mother class Card has a **cardMatches** method that compares the color of the played card with the color of the discardPileTopCard and returns true or false. It is redefined in the RegularCard class so that is also compares the number value.
- Every daughter Card has it's own **DisplayCard** method. The general formula is "Color-Characteristic", except for the wild cards, they're displayed as "WC" or "WD4" before choosing the color and normally after.
- Every daughter class has it's own definition of the **specialEvent** method, as it realizes the action that every card is supposed to be. RegularCard and WildCard have an empty specialEvent method because they do not realize any action by themselves.
- Regular Card is characterized by it's number that goes from 0 to 9.
- Reverse Card switches the way that the game goes by, by changing the boolean variable that determines it in the game class. If there are only two players in the game , it becomes a skip card.
- DrawTwo Card makes the nextPlayer call the drawCard (with argument 2) method from the Player Class and it skips it's turn.
- Skip Card makes the nextPlayer's skip's attribute to true so that he passes his turn. The skip value is returned to false in the Player class itself.
- WildDrawFour Card calls the player.chooseColor method to choose a color (obviously) and it calls the player.drawCard method to make the nextPlayer draw 4 cards. It also calls the skip method to skip the nextplayer's turn.

#### Pile class :
- Attribute cards : An array list for all the cards of the Pile.
- Attribute numberOfCards : Integer that stocks the number of Cards in the Pile.
- A constructor that can either construct the Deck that will be called in the beginning of the main to initialize the deck with all the 108 cards in order, or the discard Pile (just an empty pile).
- A constant array colors that stocks all the possible colors for the Cards as strings.
- A constant array numbers that stocks all the possible numbers for the Cards as integers.
- Method shuffle : This one here will be called after the initialization of the deck to shuffle the cards or after taking all the cards from the discard pile after emptying the deck mid-game. We did import this one because the method was quite difficult to make it ourselves with our actual level in OOP and java language.
- Method drawPileCard : This here returns the top card from the deck and removes it from the cards array list.
- Method getTopCard : This here returns the top Card of the deck. (will probably be removed)
- Method addCard : This method adds a card in the top of the pile.
- Method resetPile : This method empties the pile and sets it's number of cards to 0. It is only used to empty the discard pile after copying it's cards to the deck mid-game.
- Method displayDeck : This method gives the number of cards in the deck and displays all of them.

#### Player class :
- Mother class Player divides into two daughter classes Human and robot. Robot's hand is not displayed. Player is asked what card he plays but robot plays the first playable card except if it's a WD4 it checks before playing it.
- Robot can be easy difficulty or medium. The difference between them is in the Wild cards , as the easy one chooses the color randomly whereas the medium one chooses after checking the cards in his hand and finding the color that repeats the most in his hand. If the first player to play is a robot, the easy one can play the wild card if it's the first one in his hand , but the medium one will choose not to and play the next card instead.
- Attribute **Hand** : Every player has a hand that contains all his cards. He can only play cards from this hand.
- Attribute **NbrCards** : Number of cards in the hand.
- Attribute **name** : The name of the player that will be set in the game class.
- Attribute **skip** : This here stocks a boolean value initially set as false that can be changed to true by the previous player if he plays a skip card. What it does is it makes the player not play in this turn than it's reset to false.
- **playCard** method : Whenever a player plays a card,he will loose a card from his hand and add it to the discard pile. We have to rearrange the hand to fill the gap that the lost card left.
- **checkPlayableCards** method : This method checks if there are any playable card in the player's hand .
- **isWildFourPlayable** method : This method checks if the Wild Draw Four Card is playable or not. A player can play a wild draw four card only if it's the only playable card in the hand.
- **drawCard** method : This method draws a card from the deck. If the deck was empty , it copies the values of the discard pile (except the top card) in the deck then reset's the discardPile value, then re-add the top card to it.
- **chooseColor** method : This method makes the player choose a color whenever he plays a Wild Card. It differs from a Human (choose manually), easy robot (chooses randomly) and a medium robot (chooses depending on the color he has the most on his hand).
- **playProcess** method : This method manages the whole playing process by using all the methods below. It differs between humans and robots as the player chooses his card to play whereas the robot plays the first playable card in his hand except if it's a WildDrawFour it checks before if there's another playable card. It also manages the case of the first ever played card in the game, and the case of no available cards to play --> draw card, check if the drawn card is playable, and play it or not.
- **displayHand** method : This here is only for human player. It displays his hand on the interface so he can choose a card to play.
- **chooseCard** method : This here is only for human player. It asks the player to choose which card he wants to play from his hand by entering an integer value that corresponds to the position of the card in the hand.


#### Node class :
- This class defines the structure of the node that will contain every player that is still in the game. Every player points to the next and the previous player.
- **getNext** method : This method returns the next player in the actual game flow and not in the structure. As if we're playing clockwise it will return a different player from if we're playing counterclockwise.
- **addPlayer** method : Initializes a new node of type player (addHuman/addEasyRobot/addMediumRobot).
- **displayPlayers** method : This method displays info about all the players in the game actually and their name.
- **removeNode** method : This method removes a player from the game. It is meant to be called whenever a player reaches a number of cards of 0, so basically when he wins.
- redefinition of some methods from other classes : This was done to cover special cases that can only be took care of in the game flow itself.

#### Turn class :
- This class is basically the structure of the game. It represents a circular doubly linked list of nodes. Each node can store either a human or a robot player.
- **addPlayer** method : Adds a player as a node to the game and make it point to the previous players. (addHumain/addEasyRobot/addMediumRobot)
- **next** method : This method returns the next node in the actual game flow and not in the structure. As As if we're playing clockwise it will return a different node from if we're playing counterclockwise.
- **clear** method : This method clears the whole structure and frees every pointer. It is obviously called at the end of the game.

#### Game class :
- This class implements aspects of the two previous classes (Turn and Node) as they're made for an easier managing of the game class itself.
- **deck** attribute : Represents the deck from where cards will be distributed in the beginning then drawn mid-game.
- **gamedirection** attribute : Boolean value that determines if we're going clockwise or counterclockwise. It is changed by the ReverseCard.
- **turn** attribute : A Turn structure, basically the game structure.
- **tracker** attribute : A Node structure that will represent the current playing player towards the game.
- **discardPile** attribute : A Pile structure that represents the discard pile in which will be stocked played cards.
- **firstPlayedCard** attribute : A boolean table of one value, set to true by default and turned to false directly after the first player plays his card. (this is done by indirect "passage par reference" that is explained in the comments of the player.playProcess method). 
- **numberOfPlayers** attribute : Total number of players that are still in the game.
- **playersnames** attribute : Array to store players names.
- **fillTurn** method : Fills the Turn linked list with players.
- **next** method : When this is called, the tracker points now to the next player (not the "next" player like the one that is pointed as next, but the next player in the game flow).
- **distribution** method : Method that distributes 7 cards to every player. It is called once in the beginning of the game.
- **main** method : Manages every aspect of the game:
					--> Initialization of basic structures such as the game structure itself, deck , discard pile.
					--> Setups essentials : Collects infos about the players. / Puts tracker to the first player / Shuffles the deck / Distributes cards 
					--> Game processing : Manages remaining players, when it drops to 1 the game ends / Manages the display of the textual interface / Calls the playProcess method 										 											that manages every aspect of playing cards from players/ Displays the current card in play in every turn played by a player ....
					--> End of the game : Returns the remaining player in the game as the looser and closes the reader / frees the structure.

## OOP PRINCIPLES :
- Polymorphism : Methods of card class, such as displayCard/specialEvent/cardMatches ; Methods of Player class, such as playProcess and chooseColor.
- Encapsulation : All attributes of all classes are privates and all of them have getters and setters.
- Heritage : Class Card has 6 daughter classes / Player class has 3 daughter classes that uses the mother class public methods.
- Abstraction : Abstract class Card and Player with abstract methods that are redefined in every daughter class. Encapsulation itself is also a form of abstraction.
- We did not have the occasion to use Overload(we actually had one in the constructor of Pile class but we didn't do it we preferred an if-else statement because we did not have an argument that was only viable for deck or pile) or any interface in our project.
- We used downcasting once in RegularCard.cardMatches to use the getNbr method with the discardPileTopCard (initially a Card).
- We used indirect pass by reference in playProcess method. In OOP,every pass is by default by value, but we did a "pass by reference" by defining a boolean value as a table of booleans with initializing first value. When we modify the value in the playProcess method, it also gets modified in the game class itself.
- Everytime we had to reffer to the calling object of a method of this object, we used the prefix this.
- We used a static attribute in the gameclass "gamedirection" to easily modify it from the method of the ReverseCard.
- We made a custom constructor every time we needed to make one.
- We did not redefine methods of the object class such at toString() and equals() but we created methods that does what they're supposed to do so that we know what they does directy when reading the name.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## MEMBERS AND CONTRIBUTIONS : 
- CHETTAB Abderrahmane 			  : Full Deck class.
- RIZOU Adem 					  : Full Card class.
- SAHEB Yacine 					  : Full Game class + Main class + testing and fixing bugs.
- BELABDELOUAHAB Farouk Benyoucef : Full Player class + some fixes & supervision in the Card & previously named Deck class + testing and fixing bugs + Writing the report + recording the explaining video.

## Reflections : *(short or not so short reflection on challenges encountered during development and how they were overcome)* 
- Unfortunately, our project does not manage any kind of exceptions.
- In the beginning we had some attributes of outsider classes as arguments in methods for a specific class. We after this removed those attributes as arguments and used the setters and getters directly in the method itself.
- Before the exams, our project worked well and the game flow was perfect. However, we did not implement every OOP principle as polymorphism was missing in the card Class. We planned to fix this after the exams, but you Sir helped us to find the solution directly by suggesting the usage of a specialEvent method, so we want to thank you very much for this.
- The yelling UNO mechanic was not possible for us to do because everything is in a text interface. We can't have two entry from two players or + to make the concerned player click on an UNO button. Also, everybody knows whenever a player is at one card left because his hand is displayed.
- The Wild Draw Four card mechanic is also impossible in a textual interface,because the hands of the players are displayed. (The wild four card mechanic is that if the player plays his wild four card even if it's not his only playable card , the next player can suspect him of that and if he's right , the player whom played the card must draw cards himself).
- We wanted to add even a Hard difficulty robot that would analyze the hand of the other players to choose his color (even if that's not intuitively correct because players are not supposed to see others hands, but players can think and robots can't so this inconvenience was just meant to be an advantage to the robot). But we didn't because it would take us a lot of time to apply the overloading to the playProcess method depending on the number of players in the game. We thought about initializing 4 players even if we had only 2 that played but in the end we preferred to stick to our code and lose any more time because exams approached.
- We even wanted to add a very Hard robot that kept tracking every drawing process from every other player and choose his color depending on the least present color in the hands of the players , but that too was too much time taking.
