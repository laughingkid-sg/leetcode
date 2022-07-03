class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int result = 0;
        HashSet<Integer> f = new HashSet<>();
        for (int i : map.values()) {
            if (f.contains(i)) {
                while (i - 1 >= 0) {
                    if (!f.contains(i - 1)){
                        f.add(i-1);
                        result++;
                        break;
                    } else {
                        i--;
                        result++;
                    }
                }
            } else {
                f.add(i);
            }
        }
        return result;
    }
}