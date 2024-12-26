# POO -1- PROJECT : Developing a Text-Based UNO Game
-----------------------------------------------------------------------------------------------------------------------------------

## PROJECT STRUCTURE :



## Classes :  *(Brief report explaining the class structure & how key design decisions align with OOP principles )*

#### Card class :

#### Deck class :

#### Player class :
- Mother class Player divides into two daughter classes Human and robot. Robot's hand is not displayed. Player is asked what card he plays but robot plays the first playable card.
- Every player has a hand that contains all his cards. He can only play cards from this hand.
- A player can Play a card that matches the top card of the discard pile in color and number(if not a special card). So he will loose a card from his hand and add it to the pile.
- Whenever a player plays a card, we have to rearrange the hand to fill the gap that the lost card left.
- A player can Draw cards from the deck until he has one that can be played. If he doesn't find a playable card even after the pile is empty (or even if it's empty from the start) , he doesn't play.

#### Game class :



## MEMBERS AND CONTRIBUTIONS : *(whenever yall finish something please add it here besides your name)*
- CHETTAB Abderrahmane 			  : - 
- RIZOU Adem 					  : -
- SAHEB Yacine 					  : -
- BELABDELOUAHAB Farouk Benyoucef : -

## Reflections : *(short reflection on challenges encountered during development and how they were overcome)* 