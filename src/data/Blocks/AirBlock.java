package data.Blocks;

public class AirBlock extends AbstractBlock implements Block {
    public AirBlock() {
        this.content = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
        this.blockName = "Air";
    }
}


//'▢'