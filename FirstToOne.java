package pmaiamod4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FirstToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many faces on the die? ");
		int die = scan.nextInt();
		
		System.out.println("How many players? ");
		int people = scan.nextInt();
		
		Player[] players = new Player[people];
		
		loadPlayers(players, people);
		int i = 1;
		
		while(gameInPlay(players)) {
			takeTurn(players, i, die);
			i++;
		}
		determineWinner(players);

	}
	
	public static void loadPlayers(Player[] players, int person) {
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < person; i++) {
			System.out.println("Name of player #" + (i+1));
			String name = scan.nextLine();
			players[i] = new Player(name,50);
		}
	}
	
	public static int roll(int die) {
		Random r = new Random();
		return 1 + r.nextInt(die);
	}
	
	public static boolean gameInPlay(Player[] players) {
		for (Player player: players)
			if (player.getPoints() == 1)
				return false;
		return true;
	}
	
	public static void takeTurn(Player[] players, int i, int dice) {
		for(Player player: players) {
			int diceRoll = roll(dice);
			System.out.print(player + "Roll: " + diceRoll);
			
			if (player.getPoints() - diceRoll < 1) {
				System.out.print(" ADDING...\t\t\t");
				player.setPoints(player.getPoints() + diceRoll);
			}
			else {
				System.out.print(" SUBTRACTING...\t\t");
				player.setPoints(player.getPoints() - diceRoll);
			}
			System.out.println("New points: " + player.getPoints());
		}
		System.out.println();
	}
	
	public static void determineWinner(Player[] players) {
		ArrayList<Player> winners = new ArrayList<Player>();
		for (Player player: players) {
			if(player.getPoints() == 1)
				winners.add(player);
		}
		String result = "The game was won by ";
		
		if (winners.size() == 1)
			result = result + winners.get(0).getName();
		else {
			for(int i = 0; i < winners.size(); i++) {
				result = result + winners.get(i).getName();
				
				if (i == winners.size() - 2)
					result = result + " and ";
				else if (i < winners.size() - 1)
					result = result + ", ";
			}
		}
		System.out.println(result);
	}

	


}
