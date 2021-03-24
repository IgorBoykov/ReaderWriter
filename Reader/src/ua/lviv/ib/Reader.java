package ua.lviv.ib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

	public static void main(String[] args) throws IOException {

		String input = args[0];
		String output = args[1];
		String chosenfile = null;

		if (args.length == 3) {
			chosenfile = args[2];
		}

		// C:\\Users\\testusr\\Desktop\\4Test\\simple\\scheduler_debug.log

		File file = new File(input);
		LinePart lp = new LinePart();

		Map<String, BufferedWriter> map = new HashMap<>();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = reader.readLine()) != null) {

			lp = new LinePart();
			lp.setTime(line.substring(0, 23));
			lp.setLogName(line.substring(line.indexOf("["), line.indexOf("]") + 1).replace(":", "_").replace("/", "_")
					.replace(".", "_").replace(",", "_"));
			lp.setMessage(line.substring(line.indexOf("]") + 2));

			BufferedWriter writer = map.get(lp.getLogName());
			if (writer == null) {
				if (chosenfile == null) {
					writer = new BufferedWriter(new FileWriter(output + "\\" + lp.getLogName()));
				} else {
					writer = new BufferedWriter(new FileWriter(output + "\\" + chosenfile));
				}

				map.put(lp.getLogName(), writer);
			}

			writer.write(lp.toString() + "\n");

			// System.out.println(lp);

		}

		for (BufferedWriter writer : map.values()) {
			writer.close();
		}

		reader.close();
	}

}
