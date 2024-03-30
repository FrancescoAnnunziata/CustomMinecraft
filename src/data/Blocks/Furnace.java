package data.Blocks;

public class Furnace {
    private SmeltableBlock input;
    private Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void display_on_out() {
        System.out.println("|| "
                +this.input.display()
                +" --> "
                +this.output.display()
                +" ||");
    }

    public void smelt() {
        output = input.smelt();
        input = new NullBlock();
    }

    public void setInput(SmeltableBlock s) {
        input = s;
    }
}
