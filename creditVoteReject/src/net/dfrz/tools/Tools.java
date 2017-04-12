package net.dfrz.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tools {
	// ÅÐ¶ÏÊÇ·ñ¼ÌÐø...
	public static boolean isContinue() {
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		if (select.equals("y")) {
			return true;
		} else if (select.equals("n")) {
			System.out.println("Press Enter to continue...");
			sc.nextLine();
			return false;
		} else {
			System.out.println("Invalid code! Press Enter to continue...");
			sc.nextLine();
			return false;
		}
	}

	public static void invalidCode() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Invalid code! Press Enter to continue...");
		sc.nextLine();
	}

	public static String getDateYMDHM() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
		return sdf.format(new Date());
	}

	public static String getDateYMD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
}
