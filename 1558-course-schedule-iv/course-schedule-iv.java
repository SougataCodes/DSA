class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private Set<Integer>[] dependentCourses;
    
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }
        
        visited = new boolean[numCourses];
        dependentCourses = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dependentCourses[i] = new HashSet<>();
        }
        
        Set<Integer> roots = getRoots(numCourses, prerequisites);
        for (int from : roots) {
            if (!visited[from]) {
                dfs(from);
            }
        }
        
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(dependentCourses[query[0]].contains(query[1]));
        }
        
        return result;
    }
    
    private Set<Integer> dfs(int from) {
        visited[from] = true;
        Set<Integer> current = new HashSet<>();
        current.add(from);
        
        for (int to : graph.get(from)) {
            if (!visited[to]) {
                current.addAll(dfs(to));
            } else {
                Set<Integer> toAdd = new HashSet<>(dependentCourses[to]);
                toAdd.add(to);
                current.addAll(toAdd);
            }
            dependentCourses[from].addAll(current);
        }
        
        return current;
    }
    
    private Set<Integer> getRoots(int numCourses, int[][] prerequisites) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            result.add(i);
        }
        
        for (int[] prereq : prerequisites) {
            result.remove(prereq[1]);
        }
        
        return result;
    }
}