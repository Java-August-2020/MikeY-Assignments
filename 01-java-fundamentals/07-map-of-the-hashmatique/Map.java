
import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Shine on your Crazy Diamond", "Remember when you were young");
        tracklist.put("Have a Cigar", "You're gonna go far");
        tracklist.put("Wish you were here", "Two lost souls");
        tracklist.put("Eclipse", "No Dark side of the moon");

        String pinkFloyd = tracklist.get("Wish you were here");
        System.out.println(pinkFloyd);

        for (String key : tracklist.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, tracklist.get(key)));
        }
    }
}