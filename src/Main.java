import java.util.*;


public class Main {
    public static void main(String[] args) {
        char[] alphabetOrder = getRandomAlphabetOrder();
        // Print the shuffled array
        System.out.print("Alphabet Order is: ");
        System.out.println(Arrays.toString(alphabetOrder));
        String [] randomWords = generateRandomWords(5);
        System.out.print("List of words are: ");
        System.out.println(Arrays.toString(randomWords));
        while (!isListSorted(alphabetOrder, randomWords)){
            System.out.println("Not Sorted!");
            System.out.println();
            System.out.println();
            System.out.println();
            alphabetOrder = getRandomAlphabetOrder();
            randomWords = generateRandomWords(5);
            System.out.println(Arrays.toString(alphabetOrder));
            System.out.println(Arrays.toString(randomWords));
        }
        System.out.println("WON!");
//        boolean isListSorted = isListSorted(alphabetOrder, randomWords);
//        if (!isListSorted)
//            System.out.println("This given list is not sorted");
//        else
//            System.out.println("This given list is sorted");
//        sortList(alphabetOrder, randomWords);
    }

//    private static String[] sortList(char[] alphabetOrder, String[] randomWords) {
//        Map<Character, Integer> lettersScore = getCharacterIntegerMap(alphabetOrder);
//        ArrayList<Integer> fLetterScoreBoard = getIntegers(randomWords, lettersScore);
//        int index = 0;
//        for(Integer score: fLetterScoreBoard){
//            for(int j=index+1; j <= fLetterScoreBoard.size(); j++){
//                if (score < fLetterScoreBoard.get(j))
//                    break;
//                else if (score == fLetterScoreBoard.get(j)){ // you need to check the second letter of both words.
//                    String fWord = randomWords[index];
//                    String sWord = randomWords[index + 1];
//                    for (int k=1; k<= fWord.length(); k++){
//                        char nextCharFirstWord = fWord.charAt(k);
//                        char nextCharSecondWord = sWord.charAt(k);
//                        if (lettersScore.get(nextCharFirstWord) < lettersScore.get(nextCharSecondWord)){
//                            break;
//                        }else if (lettersScore.get(nextCharFirstWord) > lettersScore.get(nextCharSecondWord)){
//                            return false;
//                        }else if (lettersScore.get(nextCharFirstWord) == lettersScore.get(nextCharSecondWord)){
//                            continue;
//                        }
//                    }
//                }
//                else
//                    return false;
//            } index++;
//        }
//        return new String[0];
//    }

    public static boolean isListSorted(char[] alphabetOrder, String[] randomWords){
        /*
        * Solution
        * Will give each letter a score based on the position of the letter in the alphabet order
        * Will iterate of the word's letter and give each word a score based on the order of the letters it contains
        * Finally will the check score board, if it keeps increasing meaning the list is sorted, otherwise it's not
        * */
        Map<Character, Integer> lettersScore = getCharacterIntegerMap(alphabetOrder);
        ArrayList<Integer> fLetterScoreBoard = getIntegers(randomWords, lettersScore);

        System.out.println("Checking if list is sorted");
        int index = 0;
        for(Integer score: fLetterScoreBoard){
            for(int j=index+1; j < fLetterScoreBoard.size(); j++){
                if (score < fLetterScoreBoard.get(j))
                    break;
                else if (score == fLetterScoreBoard.get(j)){ // you need to check the second letter of both words.
                    String fWord = randomWords[index];
                    String sWord = randomWords[index + 1];
                    for (int k=1; k<= fWord.length(); k++){
                        char nextCharFirstWord = fWord.charAt(k);
                        char nextCharSecondWord = sWord.charAt(k);
                        if (lettersScore.get(nextCharFirstWord) < lettersScore.get(nextCharSecondWord)){
                            break;
                        }else if (lettersScore.get(nextCharFirstWord) > lettersScore.get(nextCharSecondWord)){
                            return false;
                        }else if (lettersScore.get(nextCharFirstWord) == lettersScore.get(nextCharSecondWord)){
                            continue;
                        }
                    }
                }
                else
                    return false;
            } index++;
        }
        return true;
    }

    private static ArrayList<Integer> getIntegers(String[] randomWords, Map<Character, Integer> lettersScore) {
        ArrayList<Integer> fLetterScoreBoard = new ArrayList<>();
        for (String word: randomWords){
            char[] wordsLetterArray = word.toCharArray();
            char firstLetter = wordsLetterArray[0];
            Integer fLetterScore = lettersScore.get(firstLetter);
            fLetterScoreBoard.add(fLetterScore);
        }
        return fLetterScoreBoard;
    }

    private static Map<Character, Integer> getCharacterIntegerMap(char[] alphabetOrder) {
        Map<Character, Integer> lettersScore = new HashMap<>();
        int i = 1;
        for (char letter: alphabetOrder){
            lettersScore.put(letter,i);
            i++;
        }
        System.out.println(lettersScore.toString());
        return lettersScore;
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