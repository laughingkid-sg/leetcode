import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products); // lexicographically sort ~ O(nlogn)
        
        TrieNode root = new TrieNode();
        TrieNode curr = root; 
        
        for (int i = 0; i < products.length; i++) {
            for (char ch : products[i].toCharArray()) {
                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new TrieNode();
                }
                curr.child[ch - 'a'].vals.add(i);
                curr = curr.child[ch - 'a'];
            }
            curr = root;
        }
        
        List<List<String>> output = new ArrayList<>();
        
        for (int i = 0; i < searchWord.length(); i++) {
            int index = searchWord.charAt(i) - 'a'; // get char index 0-25
            
            if (curr.child[index] == null) { // no further matches
                while(i < searchWord.length()) {
                    output.add(new ArrayList<>());
                    i++;
                }
                
            } else {
                curr = curr.child[index]; // switch curr to char
                List<String> temp = new ArrayList<>(); // inner string array
                for (int j = 0; j < Math.min(3, curr.vals.size()); j++) {
                    // get first 3 j(s) from vals
                    // add corresponding vals to Array List
                    temp.add(products[curr.vals.get(j)]);
                }
                output.add(temp);
            }
        }
        return output;
    }
}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    List<Integer> vals = new ArrayList<>();
}
















