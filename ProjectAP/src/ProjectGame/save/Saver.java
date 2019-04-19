package ProjectGame.save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Saver {
	private static File f = new File("game.data.txt");

	public static void save(Save save) {
		String st = new Gson().toJson(save);
//		System.out.println(st);
		PrintWriter pw;
		try {
			PrintStream ps = new PrintStream(f);
			ps.print(st);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			pw = new PrintWriter(f);
//			pw.print(st);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

	}

	public static Save load(String player) {
		Save newSave = new Save(player);
		ArrayList<Save> al = new ArrayList<Save>();
		Scanner in;
		String ind = null;
		try {
			in = new Scanner(f);
			ind = in.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.lang.reflect.Type collectionType = new TypeToken<ArrayList<Save>>() {
		}.getType();
		al = new Gson().fromJson(ind, collectionType);
		for (int i = al.size() - 1; i >= 0; i--) {
			if (al.get(i).User.equals(player)) {
				newSave = al.get(i);
				break;
			}
		}
		return newSave;
	}
}
