class FoodRatings {
    // Maps
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<String>> cuisineToFoods;

    // Comparator for sorting foods within a cuisine
    private Comparator<String> foodComparator = (a, b) -> {
        int ratingA = foodToRating.get(a);
        int ratingB = foodToRating.get(b);
        if (ratingA != ratingB) {
            return ratingB - ratingA; // higher rating first
        }
        return a.compareTo(b); // lexicographically smaller first
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(foodComparator));
            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> foodsSet = cuisineToFoods.get(cuisine);

        // Remove the old food entry
        foodsSet.remove(food);

        // Update rating
        foodToRating.put(food, newRating);

        // Reinsert with updated rating
        foodsSet.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
