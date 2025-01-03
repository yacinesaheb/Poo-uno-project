# POO -1- PROJECT : Developing a Text-Based UNO Game
-----------------------------------------------------------------------------------------------------------------------------------

## PROJECT STRUCTURE :

### Game rules we followed to make our project :
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
- Mother class Card has three daughter classes ColoredCard WildCard and WildDrawFourCard. ColoredCard has four daughter classes RegularCard ReverseCard SkipCard DrawTwoCard.
- Every daughter Card has it's own DisplayCard method. The general formula is "Color-Characteristic" as even the wild cards has a color which is the chosen color.
- Regular Card is characterized by it's number that goes from 0 to 9.
- Reverse Card is characterized by it's method reverse. It switches the way that the game goes by, by changing the boolean variable that determines it in the game class. If there are only two players in the game , it becomes a skip card.
- DrawTwo Card is characterized by it's method drawTwo. It makes the nextPlayer call the drawCard method from the Player Class and it skips it's turn.
- Skip Card is characterized by it's method skip. It makes the nextPlayer's skip's attribute to true so that he passes his turn. The skip value is returned to false in the Player class itself.
- Wild Card is characterized by it's method chooseColor. It makes the player choose the color of his card so that the next player must follow it. It differs between human (asks to choose the color) , easy robot (chooses the color randomly) and medium robot (chooses the color according to his hand).
- WildDrawFour Card is characterized by it's method drawFourCards. It calls the chooseColor method to choose a color (obviously) and it calls the drawCard method from the player class to make the nextPlayer draw 4 cards. It also calls the skip method to skip the nextplayer's turn.

#### Pile class :
- Attribute cards : An array list for all the cards of the Pile.
- Attribute numberOfCards : Int that stocks the number of Cards in the Pile.
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
- Mother class Player divides into two daughter classes Human and robot. Robot's hand is not displayed. Player is asked what card he plays but robot plays the first playable card.
- Robot can be easy difficulty or medium. The difference between them is in the Wild cards , as the easy one chooses the color randomly whereas the medium one chooses after checking the cards in his hand and finding the color that repeats the most in his hand. If the first player to play is a robot, the easy one can play the wild card if it's the first one in his hand , but the medium one will choose not to and play a regular card instead.
- Attribute Hand : Every player has a hand that contains all his cards. He can only play cards from this hand.
- Attribute NbrCards : Number of cards in the hand.
- Attribute name : The name of the player that will be set in the game class.
- Attribute skip : This here stocks a boolean value initially set as false that can be changed to true by the previous player if he plays a skip card. What it does is it makes the player not play in this turn than it's reset to false.
- playCard method : Whenever a player plays a card,he will loose a card from his hand and add it to the discard pile. We have to rearrange the hand to fill the gap that the lost card left.
- checkPlayableCards method : This method checks if there are any playable card in the player's hand .
- isWildFourPlayable method : This method checks if the Wild Draw Four Card is playable or not. A player can play a wild draw four card only if it's the only playable card in the hand.
- drawCard method : This method draws a card from the deck. If the deck was empty , it copies the values of the discard pile (except the top card) in the deck then reset's the discardPile value, then re-add the top card to it.
- displayHand method : This here is only for human player. It displays his hand on the interface so he can choose a card to play.
- playProcess method : This method manages the whole playing process by using all the methods below. It differs between humans and robots as the player chooses his card to play whereas the robot plays the first playable card in his hand except if it's a WildDrawFour it checks before if there's another playable card. It also manages the case of the first ever played card in the game.

#### Game class :



## MEMBERS AND CONTRIBUTIONS : 
- CHETTAB Abderrahmane 			  : Full Deck class.
- RIZOU Adem 					  : Full Card class.
- SAHEB Yacine 					  : Full Game class + Main class + testing and fixing bugs.
- BELABDELOUAHAB Farouk Benyoucef : Full Player class + some fixes & supervision in the Card & previously named Deck class + testing and fixing bugs + Writing the report.

## Reflections : *(short or not so short reflection on challenges encountered during development and how they were overcome)* 
- In the beginning we had some attributes of outsider classes as arguments in methods for a specific class. We after this removed those attributes as arguments and used the setters and getters directly in the method itself.
- The yelling UNO mechanic was not possible for us to do because everything is in a text interface. We can't have two entry from two players or + to make the concerned player click on an UNO button. Also, everybody knows whenever a player is at one card left because his hand is displayed.
- The Wild Draw Four card mechanic is also impossible in a textual interface,because the hands of the players are displayed. (The wild four card mechanic is that if the player plays his wild four card even if it's not his only playable card , the next player can suspect him of that and if he's right , the player whom played the card must draw cards himself).
- We wanted to add even a Hard difficulty robot that would analyze the hand of the other players to choose his color (even if that's not intuitively correct because players are not supposed to see others hands, but players can think and robots can't so this inconvenience was just meant to be an advantage to the robot). But we didn't because it would take us a lot of time to apply the overloading to the playProcess method depending on the number of players in the game. We thought about initializing 4 players even if we had only 2 that played but in the end we preferred to stick to our code and lose any more time because exams approached.
- We even wanted to add a very Hard robot that kept tracking every drawing process from every other player and choose his color depending on the least present color in the hands of the players , but that too was too much time taking.
- In the player class , we're aware that in the playProcess method , there are some repetitions in the code regarding the checking procedure (comparing colors and numbers etc) , but unfortunately we couldn't make one unique method to this because it differed from a case to another (first playable card / normal play / play drawn card) and from humans to robots and even between robots of different difficulties.
