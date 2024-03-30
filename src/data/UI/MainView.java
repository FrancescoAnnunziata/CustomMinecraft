package data.UI;
import data.Blocks.*;

public class MainView {
    Map m = new Map();
    Furnace f = new Furnace();

    public void display_on_out() {
       m.display_on_out();
       f.display_on_out();
    }

    public void move_into_furnace(int r, int c) {
        if(m.isSmeltable(r, c)) {
            f.setInput(m.getSmeltable(r, c));
            m.insert_rec(new AirBlock(), r ,c);
        }
    }

    public void smelt() {
        f.smelt();
    }
}
