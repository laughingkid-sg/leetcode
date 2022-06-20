import java.util.Arrays;
import java.util.HashSet;

class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> s = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                s.remove(word.substring(i));
            }
        }
        
        int result = 0;
        
        for (String word : s) {
            result += word.length() + 1; 
        }
        
        return result; 
    }
}