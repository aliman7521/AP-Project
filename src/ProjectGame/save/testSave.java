package ProjectGame.save;

import java.io.IOException;

public class testSave {

	public static void main(String[] args) throws IOException {
		Save mysave = new Save("amir");
		Saver.save(mysave);
//		Save test = Saver.load("amir");
//		
//		System.out.println(test.User);
		
	}

}
