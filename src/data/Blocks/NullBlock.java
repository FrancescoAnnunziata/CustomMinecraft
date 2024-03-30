package data.Blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
