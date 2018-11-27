package homework3;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class ChercheCityDistance {

	private ArrayList<String> cityList = new ArrayList<String>();
	private HashMap<String, String> cityDistance = new HashMap<String, String>();

	public static void main(String[] args) {

		new ChercheCityDistance();

	}

	public ChercheCityDistance() {

		Scanner in = new Scanner(System.in);
		int Ntotal = Integer.MAX_VALUE, Ncity = 0, count = 0;
		while (count < Ntotal) {
			String value = in.next();
			if (value.equals("###")) {
				Ncity = cityList.size();
				Ntotal = Ncity + Ncity * Ncity + 3;
				;
			}
			cityList.add(value);
			count++;
		}
		String[] D = new String[Ntotal];
		cityList.toArray(D);
		for (int i = 0; i < Ncity; i++) {
			for (int j = 0; j < Ncity; j++) {
				cityDistance.put(D[i] + "-" + D[j], D[Ncity + 1 + j + i]);
			}
		}
		String key = D[Ntotal - 2] + "-" + D[Ntotal - 1];
		if (cityDistance.keySet().contains(key)) {
			System.out.println(cityDistance.get(key));
		}

	}

}
