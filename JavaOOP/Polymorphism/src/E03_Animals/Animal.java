package E03_Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal (String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    protected String getFavouriteFood() {
        return favouriteFood;
    }

    public abstract String explainSelf();
}
