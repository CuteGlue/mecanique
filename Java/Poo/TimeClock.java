package homework2;

public class TimeClock {

	public static void main(String[] args) {

		java.util.Scanner in = new java.util.Scanner(System.in);

		Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());

		clock.tick();

		System.out.println(clock);

		in.close();

	}
}

class Clock {

	private Display H, M, S;

	public Clock(int hour, int minute, int second) {
		this.H = new Display(hour, 24);
		this.M = new Display(minute, 60);
		this.S = new Display(second, 60);
	}

	public void tick() {

		S.increase();
		if (S.getValue() == 0) {
			M.increase();
			if (M.getValue() == 0) {
				H.increase();
			}
		}
	}

	public String toString() {
		String res = String.format("%02d:%02d:%02d",H.getValue(),M.getValue(),S.getValue());
		return res;
	}

}

class Display {
	private int limite;
	private int value;
	private int numberOne;

	public Display(int value, int limite) {
		this.limite = limite;
		this.value = value;
	}

	public int increase() {
		value++;
		if (value == limite) {
			value = 0;
			numberOne++;
		}
		return value;
	}

	public int getValue() {
		return value;
	}
}