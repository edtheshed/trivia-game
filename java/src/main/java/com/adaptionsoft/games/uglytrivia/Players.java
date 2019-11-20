package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
}

public class Players {
    LinkedList<Player> playersList = new LinkedList<>();
    ArrayList<String> players = new ArrayList<>();
    int[] amountOfCoins = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    int currentPlayer = 0;


    private ArrayList<String> getPlayers() {
        return players;
    }

    private int[] getAmountOfCoins() {
        return amountOfCoins;
    }

    private boolean[] getInPenaltyBox() {
        return inPenaltyBox;
    }

    boolean isInPenaltyBox() {
        return getInPenaltyBox()[currentPlayer];
    }

    Object getPlayerName() {
        return getPlayers().get(currentPlayer);
    }

    void movePlayerByRoll(int roll) {
        setPlayerPosition(roll);
    }

    private void setPlayerPosition(int roll) {
        playersList.get(currentPlayer).boardPosition += roll;
    }

    void wrapAroundPlayer() {
        if (getPositionOfCurrentPlayer() > 11) {
            setPlayerPosition(-12);
        }
    }

    private int getPositionOfCurrentPlayer() {
        return playersList.get(currentPlayer).boardPosition;
    }

    int getCurrentPlayerPlace() {
        return getPositionOfCurrentPlayer();
    }

    int getPurseAmount() {
        return getAmountOfCoins()[currentPlayer];
    }

    int gainCoin() {
        return getAmountOfCoins()[currentPlayer]++;
    }

    void penalizePlayer() {
        getInPenaltyBox()[currentPlayer] = true;
    }

    boolean didPlayerWin() {
        return !(getPurseAmount() == 6);
    }

    void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == getPlayers().size()) {
            currentPlayer = 0;
        }
    }

    void addPlayer(String playerName) {
        playersList.add(new Player(playerName));
        getPlayers().add(playerName);
        getAmountOfCoins()[howManyPlayers()] = 0;
        getInPenaltyBox()[howManyPlayers()] = false;
    }

    public int howManyPlayers() {
return getPlayers().size();
}
}