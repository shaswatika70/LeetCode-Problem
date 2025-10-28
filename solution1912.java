class MovieRentingSystem
{
    private Map<List<Integer>, Integer> priceMap;
    private Map<Integer, TreeSet<int[]>> unrented;
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries)
    {
        priceMap = new HashMap<>();
        unrented = new HashMap<>();

        Comparator<int[]> cmpUnrented = (a, b) -> 
        {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        };

        Comparator<int[]> cmpRented = (a, b) ->
        {
            if (a[0] !=b[0]) return a[0] - b[0];
            if (a[1] !=b[1]) return a[1] - b[1];
            return a[2] - b[2];
        };

        rented = new TreeSet<>(cmpRented);

        for (int[] e : entries)
        {
            int shop =e[0], movie = e[1], price = e[2];
            priceMap.put(Arrays.asList(shop, movie), price);

            unrented.computeIfAbsent(movie, k-> new TreeSet<>(cmpUnrented))
                    .add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie)
    {
        List<Integer> res = new ArrayList<>();
        if(!unrented.containsKey(movie)) return res;

        Iterator<int[]> it = unrented.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5)
        {
            res.add(it.next()[1]);
            count++;
        }
        return res;
    }

    public void rent(int shop, int movie)
    {
        int price = priceMap.get(Arrays.asList(shop, movie));
        unrented.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie)
    {
        int price = priceMap.get(Arrays.asList(shop, movie));
        rented.remove(new int[]{price, shop, movie});
        unrented.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report()
    {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5)
        {
            int[] x = it.next();
            res.add(Arrays.asList(x[1], x[2]));
            count++;
        }
        return res;
    }
}
