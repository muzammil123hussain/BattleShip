import java.util.Scanner;

public class Battleship {


	public static final char SHIP = '@';
	public static final char BLANK_SPACE = '_';
	public static final char DESTROY_SHIP = 'X';
	public static final char MISSING_SHIP = 'O';
	public static final Integer SHIP_LIMIT = 5;
	public static final String PLAYER_A = "Jibran";
	public static final String PLAYER_B = "Muzammil";
	public static Integer TURNS = 0;
	public static Integer DESTROY_COUNT_A = 0;
	public static Integer DESTROY_COUNT_B = 0;


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		

		char[][] A = new char[5][5];
		char[][] B = new char[5][5];

		placeBattleShip(A, Battleship.PLAYER_A, input);
		placeBattleShip(B, Battleship.PLAYER_B, input);

		// printBattleShip(A, Battleship.PLAYER_A);
		// printBattleShip(B, Battleship.PLAYER_B);


		while(TURNS<=10 && Battleship.DESTROY_COUNT_A != 5 && Battleship.DESTROY_COUNT_B != 5 )
		{
		for_hit_turn_A(B, Battleship.PLAYER_A, input);
		for_hit_turn_B(A, Battleship.PLAYER_B, input);
		}

		if(Battleship.DESTROY_COUNT_A > Battleship.DESTROY_COUNT_B){
			System.out.println("congratulations Champion: " + PLAYER_A + " You WIN.!!");
		}
		else
		{
			System.out.println("congratulations Champion: " + PLAYER_B + " You WIN.!!");
		}


		printBattleShip(A, Battleship.PLAYER_A);
		printBattleShip(B, Battleship.PLAYER_B);

		input.close();

	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player, String name) {
		System.out.println("Player : " + name + " Board");
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					if (player[row][column] == Battleship.SHIP || player[row][column] == Battleship.DESTROY_SHIP || player[row][column] == Battleship.MISSING_SHIP)
					{
						System.out.print(player[row][column]+ " ");
					}
					else{
						player[row][column] = Battleship.BLANK_SPACE;
						System.out.print(player[row][column]+ " ");
					}
				}
			}
			System.out.println("");
		}
	}

	// Use this method to take input from user for game boards to the console.
	private static void placeBattleShip(char[][] player, String name, Scanner input) {
		Integer ship = 1;
		System.out.println("Player : " + name + " Board");
		while (ship <= Battleship.SHIP_LIMIT) {

			System.out.println("Place you Ship No : " + ship + " Coordinates");
			String coordinatesInput = input.nextLine();
			String[] coordinatesArray = coordinatesInput.split(" "); 
			Integer row = Integer.parseInt(coordinatesArray[0]);
			Integer col = Integer.parseInt(coordinatesArray[1]);
			player[row][col] = Battleship.SHIP;
			ship++;
		}
	}

	// Use this method to hit the PLAYER_B board to the console.
	public static void for_hit_turn_A(char[][] player, String name, Scanner input) 
	{
			System.out.println("Player : " + name + " Turn.");

			System.out.println("Enter Coordinates for hit: " + PLAYER_B + "'s Ship");
			String coordinatesInput = input.nextLine();
			String[] coordinatesArray = coordinatesInput.split(" "); 
			Integer row = Integer.parseInt(coordinatesArray[0]);
			Integer col = Integer.parseInt(coordinatesArray[1]);
			if (player[row][col] == Battleship.SHIP){
				player[row][col] = Battleship.DESTROY_SHIP;
				System.out.println("Wow! you hit : " + PLAYER_B + "'s Ship.");
				Battleship.DESTROY_COUNT_A++;

			}
			else{
				player[row][col] = Battleship.MISSING_SHIP;
				System.out.println("Oops! you missed : " + PLAYER_B + "'s Ship.");
			}

			Battleship.TURNS++;
	}

	// Use this method to hit the PLAYER_A board to the console.
	public static void for_hit_turn_B(char[][] player, String name, Scanner input) 
	{
			System.out.println("Player : " + name + " Turn.");

			System.out.println("Enter Coordinates for hit: " + PLAYER_A + "'s Ship");
			String coordinatesInput = input.nextLine();
			String[] coordinatesArray = coordinatesInput.split(" "); 
			Integer row = Integer.parseInt(coordinatesArray[0]);
			Integer col = Integer.parseInt(coordinatesArray[1]);
			if (player[row][col] == Battleship.SHIP){
				player[row][col] = Battleship.DESTROY_SHIP;
				System.out.println("Wow! you hit : " + PLAYER_A + "'s Ship.");
				Battleship.DESTROY_COUNT_B++;
			}
			else{
				player[row][col] = Battleship.MISSING_SHIP;
				System.out.println("Oops! you missed : " + PLAYER_A + "'s Ship.");
			}

			Battleship.TURNS++;

	}

	// Use this method shuffle the turn to the console.
	public static void for_hit_turn_shuffle(char[][] player, String name, Scanner input) 
	{
		if(Battleship.TURNS<=10){
			for_hit_turn_A(player, name, input);
			for_hit_turn_B(player, name, input);
		}
	}

}