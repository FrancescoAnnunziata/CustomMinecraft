package data.Blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock{
    public SandBlock() {
        this.content = '▢';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockName = "Sand";
    }

    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}
