package ProjectGame.save;

public class MainMain {

	public static void main(String[] args) {
		Save mysave = new Save("amir", 100, 20, 100, 2, 1000, "colt");
		Saver.save(mysave);
	}

}
