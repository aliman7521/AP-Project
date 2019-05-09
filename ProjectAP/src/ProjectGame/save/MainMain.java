package ProjectGame.save;

import java.io.IOException;

public class MainMain {

	public static void main(String[] args) throws IOException {
		Save mysave = new Save("amir", "colt" ,100, 20, 100, 2, 1000, false);
		Saver.save(mysave);
	}

}
