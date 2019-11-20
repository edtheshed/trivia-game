package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Players {
    LinkedList<Player> playersList = new LinkedList<>();
    int currentPlayer = 0;


    boolean isInPenaltyBox() {
        return playersList.get(currentPlayer).inPenaltyBox;
    }

    String getPlayerName() {
        return playersList.get(currentPlayer).name;
    }

    void movePlayerBy(int amount) {
        Player player = playersList.get(currentPlayer);
        player.move(amount);
    }


    private int getPositionOfCurrentPlayer() {
        return playersList.get(currentPlayer).boardPosition;
    }

    int getCurrentPlayerPlace() {
        return getPositionOfCurrentPlayer();
    }

    int getPurseAmount() {
        return playersList.get(currentPlayer).amountOfCoins;
    }

    int gainCoin() {
        return playersList.get(currentPlayer).amountOfCoins++;
    }

    void penalizePlayer() {
        playersList.get(currentPlayer).inPenaltyBox = true;
    }

    boolean didPlayerWin() {
        return !(getPurseAmount() == 6);
    }

    void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == playersList.size()) {
            currentPlayer = 0;
        }
    }

    void addPlayer(String playerName) {
        playersList.add(new Player(playerName));
    }

    public int howManyPlayers() {
return playersList.size();
}
}