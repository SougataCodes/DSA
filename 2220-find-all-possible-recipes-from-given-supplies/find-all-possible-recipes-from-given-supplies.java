class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,HashSet<String>>graph=new HashMap<>();
        Map<String,Integer>degree=new HashMap<String,Integer>();
        HashSet<String>recipesData= new HashSet<>(Arrays.asList(recipes));
        //construct graph
        for(int i=0;i<recipes.length;++i){
            for(String ingredient:ingredients.get(i)){
                graph.computeIfAbsent(ingredient,k -> new HashSet<>()).add(recipes[i]);
            }
            degree.put(recipes[i],ingredients.get(i).size());
        }
        //constrcut available ingredients
        Queue<String>q=new LinkedList<String>();
        for(String i:supplies){
            q.add(i);
        }
        //compute result using topo-sort
        List<String>arr=new LinkedList<>();
        while(!q.isEmpty()){
            String data=q.poll();
            if(recipesData.contains(data)) arr.add(data);
            if(graph.containsKey(data)){
                for(String ingredient:graph.get(data)){
                    degree.put(ingredient,degree.get(ingredient)-1);
                    if(degree.get(ingredient)==0){
                        q.add(ingredient);
                    }
                }
            }
        }
        return arr;
    }
}