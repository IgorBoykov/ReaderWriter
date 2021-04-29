package ua.lviv.ib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

	public static void main(String[] args) throws IOException {
		if (args.length < 2 || args.length > 3) {
			throw new IllegalArgumentException("Must be two or three arguments with one space between them");
		}

		String input = args[0];
		String output = args[1];
		String chosenfile = null;

		if (args.length == 3) {
			chosenfile = args[2];

		}

		// C:\\Users\\testusr\\Desktop\\4Test\\simple\\scheduler_debug.log
		// C:\\Users\\testusr\\Desktop\\4Test\\simple\\transport_debug.log

		try {

		File file = new File(input);
		LinePart lp = new LinePart();

		Map<String, BufferedWriter> map = new HashMap<>();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		File directory = new File(output);
		if (!directory.exists())
			directory.mkdir();

		while ((line = reader.readLine()) != null) {

			if (!lp.transformToObject(lp, line, chosenfile))
				continue;

			BufferedWriter writer = map.get(lp.getFileName());
			if (writer == null) {
				if (chosenfile != null) {
					File fileq = new File(directory + "\\" + LinePart.escSymbols(chosenfile));
					writer = new BufferedWriter(new FileWriter(fileq.getAbsoluteFile()));
				} else {
					File fileq = new File(directory + "\\" + LinePart.escSymbols(lp.getFileName()));
					writer = new BufferedWriter(new FileWriter(fileq.getAbsoluteFile()));
				}

				map.put(lp.getFileName(), writer);
			}

			writer.write(lp.toString() + "\n");

		}

		for (BufferedWriter writer : map.values()) {
			writer.close();
		}

		reader.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("File doesnt exist");
		}
	}

}
