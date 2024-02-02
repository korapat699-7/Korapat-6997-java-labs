package seedamart.korapat.lab7;

public class TestGuessNumberGameVer4 {
    public static void main(String[] args) {
        GuessNumberGameVer4 game1 = new GuessNumberGameVer4(1, 10, 3);
        GuessNumberGameVer4 game2 = new GuessNumberGameVer4(1, 10, 5);
        GuessNumberGameVer4 game3 = new GuessNumberGameVer4(1, 5, 5);

        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
    }
}
