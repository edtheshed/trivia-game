package com.adaptionsoft.games.uglytrivia;

class Player {
    String name;
    int boardPosition;
    int amountOfCoins;
    boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        boardPosition = 0;
        amountOfCoins = 0;
        inPenaltyBox = false;
    }

    void move(int amount) {
        boardPosition += amount;
        if (boardPosition > 11) {
            this.move(-12);
        }
    }
}
