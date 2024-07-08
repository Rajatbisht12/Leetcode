class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        int sLength = s.length();
        
        if (sLength < totalLength) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int left = i, count = 0;
            
            for (int j = i; j <= sLength - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                
                if (wordCount.containsKey(currentWord)) {
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    count++;
                    
                    while (seenWords.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    
                    if (count == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }
        
        return result;
    }
}