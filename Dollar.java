public class Dollar extends Coin{
    @Override
    public double getValue() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "dollar";
    }
}
