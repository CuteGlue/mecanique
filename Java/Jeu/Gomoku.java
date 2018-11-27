import java.util.Scanner;

public class Gomoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gomoku().run();

	}

	public void run() {

		Scanner in = new Scanner(System.in);
		System.out.println("Entrer nom de noir echec : ");
		String P_black = in.nextLine();
		System.out.println("Entrer nom de blance echec : ");
		String P_white = in.nextLine();

		int size = 15;
		int[][] table = new int[size][size];

		int win = 0;
		int currentPlayer = 0;
		do {
			printTable(table, size);
			String playerName = currentPlayer == 0 ? P_black : P_white;
			System.out.println(playerName + " apprend un échec : ");

			int x, y;
			boolean canPlace = true;
			do {
				if (!canPlace) {
					System.out.println("error! entrer autre svp : ");
				}

				String code = in.nextLine();
				x = Integer.valueOf(code.substring(1)) - 1;
				y = code.charAt(0) - 'A';
				canPlace = true;
				canPlace = canPlace && x >= 0 && x < size;
				canPlace = canPlace && y >= 0 && y < size;
				canPlace = canPlace && table[y][x] == 0;

			} while (!canPlace);
			table[y][x] = currentPlayer == 0 ? 1 : 2;
			currentPlayer++;
			currentPlayer %= 2;
			win = check(table, x, y);

			

		} while (win == 0);
		
		if (win == 1) {
			System.out.println(P_black + " win !");
		} else if (win == 2) {
			System.out.println(P_white + " win !");
		} else {
			System.out.println("God win !");
		}
	}

	public void printTable(int[][] table, int size) {
		System.out.print("   ");
		for (int i = 0; i < size; i++) {
			int value = i + 1;
			System.out.print(value < 10 ? value + "  " : value + " ");
		}
		System.out.println();

		for (int i = 0; i < size; i++) {
			char title = (char) ('A' + i);
			System.out.print(title + "  ");
			for (int j = 0; j < size; j++) {
				int value = table[i][j];
				char c = ' ';
				switch (value) {
				case 0:
					c = '.';
					break;
				case 1:
					c = 'x';
					break;
				case 2:
					c = 'o';
					break;
				}
				System.out.print(c + "  ");
			}
			System.out.println();
		}
	}

	public int check(int[][] table, int x, int y) {
		boolean test = false ;
		test = test || moreThanFive(table,x,y,0, -1) ;
		test = test || moreThanFive(table,x,y,1,0) ;
		test = test || moreThanFive(table,x,y,1, -1) ;
		test = test || moreThanFive(table,x,y,1, 1) ;
		if (test) {
			return table[y][x] ;
		}
		return 0;
	}
	
	public boolean moreThanFive(int[][] table, int x, int y, int dx, int dy) {
		int count = 0 ;
		count += count(table,x,y,dx,dy);
		count += count(table,x,y,-dx,-dy) ;
		count -= 1 ;
		return count>=5;
	}
	
	
	
	
	
	public int count(int[][] table, int originX, int originY, int dx, int dy) {
		int originValue = table[originY][originX] ;
		int count = 0 ;
		int x = originX ;
		int y = originY ;
		int value ;
		do {
			count++ ;
			originX += dx ;
			originY += dy ;
			if(originX < 0 || originY <0 ||originX >=15||originY >= 15) {
				break ;
			}
//			System.out.println(" " + originX + " " + originY + " ");
			value = table[originY][originX] ;
		} while(value == originValue) ;
		return count ;
	}
		

}
