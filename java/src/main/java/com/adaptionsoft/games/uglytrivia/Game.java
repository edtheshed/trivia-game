package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
    final Players players = new Players();

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (players.howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {

		players.addPlayer(playerName);

		print(playerName + " was added");
		print("They are player number " + players.howManyPlayers());
		return true;
    }

	public void playTurn(int roll) {
		print(players.getPlayerName() + " is the current player");
		print("They have rolled a " + roll);

		if (players.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

				print(players.getPlayerName() + " is getting out of the penalty box");
				players.movePlayerBy(roll);

                System.out.println(players.getPlayerName()
                        + "'s new location is "
                        + players.getCurrentPlayerPlace());
				print("The category is " + currentCategory());
				askQuestion();
            } else {
				print(players.getPlayerName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
            }

        } else {

            players.movePlayerBy(roll);

            System.out.println(players.getPlayerName()
                    + "'s new location is "
                    + players.getCurrentPlayerPlace());
			print("The category is " + currentCategory());
			askQuestion();
        }

    }

	private void print(String output) {
		System.out.println(output);
	}

	private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (players.getCurrentPlayerPlace() == 0) return "Pop";
        if (players.getCurrentPlayerPlace() == 4) return "Pop";
        if (players.getCurrentPlayerPlace() == 8) return "Pop";
        if (players.getCurrentPlayerPlace() == 1) return "Science";
        if (players.getCurrentPlayerPlace() == 5) return "Science";
        if (players.getCurrentPlayerPlace() == 9) return "Science";
        if (players.getCurrentPlayerPlace() == 2) return "Sports";
        if (players.getCurrentPlayerPlace() == 6) return "Sports";
        if (players.getCurrentPlayerPlace() == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (players.isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
				print("Answer was correct!!!!");
				players.gainCoin();
                System.out.println(players.getPlayerName()
                        + " now has "
                        + players.getPurseAmount()
                        + " Gold Coins.");

                boolean winner = players.didPlayerWin();
                players.nextPlayer();
                return winner;
            } else {
                players.nextPlayer();
                return true;
            }


        } else {

			print("Answer was corrent!!!!");
			players.gainCoin();
            System.out.println(players.getPlayerName()
                    + " now has "
                    + players.getPurseAmount()
                    + " Gold Coins.");

            boolean winner = players.didPlayerWin();
            players.nextPlayer();

            return winner;
        }
    }

	public boolean wrongAnswer() {
		print("Question was incorrectly answered");
		print(players.getPlayerName() + " was sent to the penalty box");
		players.penalizePlayer();

        players.nextPlayer();
        return true;
    }

}
