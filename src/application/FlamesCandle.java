package application;

import java.util.*;

public class FlamesCandle {

    // This FLAMES CANDLE program enables the user to determine the two inputted
    // names' distinctive letters.
    // The amount of distinct letters is counted among the letters of acrostic poem
    // "FLAMES CANDLE", after which it eliminates the letter that the final number
    // lands on.
    // After eliminating a letter, the counting will start again form the first
    // letter of acrostic poem and repeats until only 1 remains.
    // The result will be the meaning of the only letter in the acrostic poem that
    // remains.

    private static ArrayList<Character> userNameLetters = new ArrayList<>();
    private static ArrayList<Character> crushNameLetters = new ArrayList<>();

    private static ArrayList<Character> uniqueLetters;
    private static ArrayList<String> FLAMES = new ArrayList<String>(
            List.of("FRIENDS",
                    "LOVERS",
                    "ADMIRERS",
                    "MARRIAGE",
                    "ENEMIES",
                    "SOULMATES",
                    "CRUSH",
                    "AFFECTION",
                    "NEVER",
                    "DARLING",
                    "LOVE OF MY LIFE",
                    "ENEMIES"));

    public static String runFlames(String userNameInput, String crushNameInput) {

        getUserNameLetters(userNameInput.replaceAll(" ", "").toLowerCase(), userNameLetters);
        getCrushNameLetters(crushNameInput.replaceAll(" ", "").toLowerCase(), crushNameLetters);
        getUniqueLetters(userNameLetters, crushNameLetters);

        System.out.println("The Distinct Letters are: " + uniqueLetters);
        System.out.println("The Number of Distinct Letters is: " + uniqueLetters.size());

        return getFlameLetter(uniqueLetters.size(), FLAMES).get(0);

    }

    private static ArrayList<Character> getLetters(String name, ArrayList<Character> nameLetters) {

        // Iterates over each letter of name and checks if it is in ArrayList
        // Letter is appended if it is not in ArrayList.

        for (char letter : name.toCharArray()) {
            if (!(nameLetters.contains(letter)))
                nameLetters.add(letter);
        }
        return nameLetters;

    }

    private static void getUserNameLetters(String name, ArrayList<Character> nameLetters) {
        userNameLetters = getLetters(name, nameLetters);
    }

    private static void getCrushNameLetters(String name, ArrayList<Character> nameLetters) {
        crushNameLetters = getLetters(name, nameLetters);
    }

    private static void getUniqueLetters(ArrayList<Character> userNameLetters,
            ArrayList<Character> crushNameLetters) {

        // Adds all unique letters from array 2 to array 1 and removes identical
        // letters.
        // Method saves memory by utilizing existing ArrayLists for comparison and
        // storage.

        for (char letter : crushNameLetters) {
            if (userNameLetters.contains(letter))
                userNameLetters.remove(userNameLetters.indexOf(letter));
            else
                userNameLetters.add(letter);
        }

        uniqueLetters = userNameLetters;
    }

    private static ArrayList<String> getFlameLetter(int iteration, ArrayList<String> FLAMES) {

        // returns the word once the array FLAMES has only one word.
        if (FLAMES.size() == 1)
            return FLAMES;

        // iterates over the FLAMES array and removes the word at the given index.
        int wordIndex = iteration % FLAMES.size();

        // prevents indexOutOfBoundsError.
        if (wordIndex != 0)
            wordIndex -= 1;
        else
            wordIndex = FLAMES.size() - 1;

        FLAMES.remove(wordIndex);

        return getFlameLetter(iteration, FLAMES);
    }
}
