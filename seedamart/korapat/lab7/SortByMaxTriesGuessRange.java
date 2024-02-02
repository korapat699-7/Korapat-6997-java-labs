package seedamart.korapat.lab7;
import java.util.Comparator;

/* 
 * Class SortByMaxTriesGuessRange:
 * 
 * SortByMaxTriesGuessRange that meets with the criteria that first we consider 
 * the value of the max number of tries. The greater the max number of tries, the greater the object is, 
 * However, if the number of max tries is the same, we want to compare the guess random range. 
 * The smaller the random range is, the greater the object is. Essentially, we want to compare the game objects 
 * by sorting from the most difficult games to the least difficult games. 
 * 
 * 
 * From TestGamesProb2, the output should be:
 * ===== Unsorted games list: =====
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:7)
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:5 ,max tries:5)
 * ===== Sorted games list: =====
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:5 ,max tries:5)
 * GuessNumberGameVer4 (min:1 ,max:10 ,max tries:7)
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

public class SortByMaxTriesGuessRange  implements Comparator<GuessNumberGameVer4> {

    @Override
    public int compare(GuessNumberGameVer4 g1, GuessNumberGameVer4 g2) {
        if (g1.getMaxTries() == g2.getMaxTries()) {
            int range1 = g1.getMaxNum() - g1.getMinNum();
            int range2 = g2.getMaxNum() - g2.getMinNum();
            return range2 - range1; //เรียงจากค่า range มากไปน้อยโดย 
        } else {
            return g1.getMaxTries() - g2.getMaxTries();//เรียงจาก maxTries ที่น้อยที่สุด
        }
    }
}