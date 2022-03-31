
public abstract class Coin {
    public abstract double getValue();
    public abstract String getName();

    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
