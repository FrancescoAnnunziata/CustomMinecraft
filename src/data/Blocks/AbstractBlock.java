package data.Blocks;

public class AbstractBlock implements Block{
    public char content;
    public boolean falls_with_gravity;
    public boolean fall_through;
    public String blockName;

    @Override
    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    @Override
    public boolean isFall_through() {
        return fall_through;
    }

    @Override
    public char display() {
        return content;
    }

    @Override
    public String toString() {
        return blockName;
    }
}
