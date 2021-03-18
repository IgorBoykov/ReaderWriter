package ua.lviv.ib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file directory");
		// C:\\Users\\testusr\\Desktop\\4Test\\simple\\scheduler_debug.log
		String directory = sc.nextLine();

		File file = new File(directory);
		LinePart lp = new LinePart();

		Map<String, BufferedWriter> map = new HashMap<>();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = reader.readLine()) != null) {

			// System.out.println(line);
			lp = new LinePart();
			// String[] dividedLine = line.split(" ", 3);
			lp.setTime(line.substring(0, 23));
			lp.setLogName(line.substring(line.indexOf("["), line.indexOf("]") + 1));
			lp.setMessage(line.substring(line.indexOf("]") + 2));
			System.out.println(lp);

			BufferedWriter writer = new BufferedWriter(new FileWriter(lp.getLogName()));

			map.put(lp.getLogName(), writer);

		}
		reader.close();
		sc.close();

//		for (LinePart l : list) {
//			System.out.println(l);
//		}

//		BufferedWriter writter = new BufferedWriter(new FileWriter(lp.getLogName()));
//		while (list.iterator().hasNext()) {
//		
//			if (lp.getLogName().equalsIgnoreCase(lp.getLogName())) {
//				for (LinePart l : list) {
//					writter.write(l + "\n");
//				}
//			}
//
//		}
	}

}
