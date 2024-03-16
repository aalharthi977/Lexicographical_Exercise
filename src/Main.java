import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[] alphabetOrder = getRandomAlphabetOrder();
        // Print the shuffled array
        System.out.print("Alphabet Order is: ");
        System.out.println(Arrays.toString(alphabetOrder));
        String [] randomWords = generateRandomWords(5);
        System.out.print("List of words are: ");
        System.out.println(Arrays.toString(randomWords));



    }

    private static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    private static char[] getRandomAlphabetOrder() {
        // Your array of characters
        char[] charArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // Convert the array to a list
        Character[] charObjArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            charObjArray[i] = charArray[i];
        }

        // Shuffle the list
        Collections.shuffle(Arrays.asList(charObjArray));

        // Convert the shuffled list back to an array
        for (int i = 0; i < charObjArray.length; i++) {
            charArray[i] = charObjArray[i];
        }
        return charArray;
    }
}