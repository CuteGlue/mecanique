// GPS

public class Java_6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in = new java.util.Scanner(System.in);

		String res = null;
		String str = in.nextLine();
		String strRMC = "error";
		int firstPoint = 0;
		int secondPoint = 0;

		while (!str.equals("END")) {

			firstPoint = str.indexOf(',');
			secondPoint = str.indexOf(',', firstPoint + 1);

			if (str.indexOf("$GPRMC") != -1 && str.charAt(secondPoint + 1) == 'A') {
				int n = str.indexOf('*');
				String dernier = str.substring(str.indexOf('*') + 1);
				int scalaire = str.charAt(1);
				for (int i = 2; i < n; i++) {
					scalaire = scalaire ^ str.charAt(i);
				}
				if (scalaire % 65536 == Integer.parseInt(dernier, 16)) {
					strRMC = str;
					firstPoint = strRMC.indexOf(',');
					secondPoint = strRMC.indexOf(',', firstPoint + 1);
				}
			}
			str = in.nextLine();
		}

		String time = strRMC.substring(firstPoint + 1, strRMC.indexOf('.'));

		int value = Integer.parseInt(time);

		// 字段２不足６位要补足
		time = time.format("%06d", value);

		String h = time.substring(0, 2);
		String m = time.substring(2, 4);
		String s = time.substring(4);
		int hourBJ = Integer.parseInt(h) + 8;
		hourBJ = hourBJ % 24;
		int minuteBJ = Integer.parseInt(m);
		int secondBJ = Integer.parseInt(s);

		res = res.format("%02d:%02d:%02d", hourBJ, minuteBJ, secondBJ);
		System.out.println(res);
	}

}
