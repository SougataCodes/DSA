class Solution {
     public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();
        Map<Character, List<Character>> graph = new HashMap<>();
        // Creating MAP -> for edges, and respective characters
        for(int i=0; i<n; i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Creating StringBuilder which will take min char from all list of resp char
        StringBuilder str = new StringBuilder();
        for(int i=0; i<m; i++){
            char ch = baseStr.charAt(i);
            boolean[] visited = new boolean[26];
            str.append(DFSminChar(graph, ch, visited));
        }

        return str.toString();
    }

    public char DFSminChar(Map<Character, List<Character>> graph, char currCh, boolean[] visited){
        visited[currCh - 'a'] = true;
        char minChar = currCh;

        for(char nbr : graph.getOrDefault(currCh, new ArrayList<>())){
            // check only have not visited on specific char
            if(!visited[nbr - 'a']){
                char nbrMin = DFSminChar(graph, nbr, visited);   // check all neighbours

                if(nbrMin < minChar){
                    minChar = nbrMin;
                }
            }
        }

        return minChar;
    }
}