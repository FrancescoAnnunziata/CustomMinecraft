package data.Blocks;

public class WaterBlock extends AbstractBlock{
    public WaterBlock() {
        this.content = '≋';
        this.falls_with_gravity = true;
        this.fall_through = true;
        this.blockName = "Water";
    }
}
