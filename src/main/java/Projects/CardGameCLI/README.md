# BlackJack Cli game

## Playing Card

### Attributes

- value: int
- suit: Suit

### Methods

- constructor
- getters
- toString

## Shoe

### Attributes

- cards: List<PlayingCard>

### Methods

- constructor
- shuffle
- draw

## Hand

### Attributes

- hand: List<PlayingCard>

### Methods

- constructor
- calculateScore

## BlackJack

### Attributes

- gamestate: Boolean
- dealerhand: Hand
- playerhands: Map(playerhand: Hand, bet: int)

### Methods

- constructor
- hit
- stay
- doubledown
- split

## Player

### Attributes

- chips: int
- hands: Map(cards: Hand, bet: int)

## Dealer

### Attributes

- hand: Hand




####
Blackjack object concepts

- **player** arrives at table
- **player** has money
- table has **Dealer** and **player**
- **dealer** has **shoe**
- **shoe** has **cards**
- **dealer** and **player** play **blackjack**
- **dealer** deals **hands** to **dealer** and **player**
- **player** can *hit* and *stay*

json to pass

message
cards
pot
status