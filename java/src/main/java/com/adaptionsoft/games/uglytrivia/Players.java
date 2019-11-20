package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Players {
    ArrayList<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    int currentPlayer = 0;

    private ArrayList<String> getPlayers() {
        return players;
    }

    private int[] getPlaces() {
        return places;
    }

    private int[] getPurses() {
        return purses;
    }

    private boolean[] getInPenaltyBox() {
        return inPenaltyBox;
    }

    public Players() {
    }


    boolean isInPenaltyBox() {
        return getInPenaltyBox()[currentPlayer];
    }

    Object getPlayerName() {
        return getPlayers().get(currentPlayer);
    }

    void movePlayerByRoll(int roll) {
        getPlaces()[currentPlayer] = getPlaces()[currentPlayer] + roll;
    }

    void wrapAroundPlayer() {
        if (getPlaces()[currentPlayer] > 11) {
            getPlaces()[currentPlayer] = getPlaces()[currentPlayer] - 12;
        }
    }

    int getCurrentPlayerPlace() {
        return getPlaces()[currentPlayer];
    }

    int getPurseAmount() {
        return getPurses()[currentPlayer];
    }

    int gainCoin() {
        return getPurses()[currentPlayer]++;
    }

    void penalizePlayer() {
        getInPenaltyBox()[currentPlayer] = true;
    }

    boolean didPlayerWin() {
        return !(getPurseAmount() == 6);
    }

    void nextPlayer() {
        //todo: change to linkedlist
        currentPlayer++;
        if (currentPlayer == getPlayers().size()) {
            currentPlayer = 0;
        }
    }

    void addPlayer(String playerName) {
        getPlayers().add(playerName);
        getPlaces()[howManyPlayers()] = 0;
        getPurses()[howManyPlayers()] = 0;
        getInPenaltyBox()[howManyPlayers()] = false;
    }

    public int howManyPlayers() {
return getPlayers().size();
}
}