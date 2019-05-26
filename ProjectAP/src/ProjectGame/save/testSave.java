package ProjectGame.save;

import java.io.IOException;

public class testSave {

	public static void main(String[] args) throws IOException {
//		Save mysave = new Save("amir", "sword" ,100, 7000, 100, 2, 1000, true);
//		Saver.save(mysave);
		Save test = Saver.load("amir");
		
		System.out.println(test.User);
		
	}

}
