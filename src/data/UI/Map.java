package data.UI;

import data.Blocks.*;

import java.util.Random;

public class Map {
    private AbstractBlock[][] map;
    final int H = 8;
    final int L = 50;

    public Map() {
        this.map = new AbstractBlock[H][L];
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                map[i][j] = new AirBlock();
            }
        }
        addRiver();
        randomBlock();
    }

    public void display_on_out() {
        for(int i = 0; i < H; i++){
            for(int j = 0; j < L; j++){
                System.out.print(map[i][j].display() + " ");
            }
            System.out.println();
        }
    }

    /*public void change_cell(int x, int y) {
        if(x > L || x < 0 || y > H || y < 0) {
            System.out.println("Sei fuori dalla mappa!");
        } else {
            map[x][y].setContent('▣');
        }
    }*/

    private void swap(int r, int c) {
        AbstractBlock tmp = map[r][c];
        map[r][c] = map[r + 1][c];
        map[r + 1][c] = tmp;
    }

    public void insert_rec(AbstractBlock block, int r, int c) {
        map[r][c] = block;
        if(r == H - 1 || !map[r][c].isFalls_with_gravity() || !map[r + 1][c].isFall_through()) {
            return;
        }
        swap(r, c);
        insert_rec(block, r + 1, c);
    }

    public void insert_iter(char content, int r, int c) {
        map[r][c] = new AirBlock();
        while(r < H - 1 && (map[r][c].isFalls_with_gravity() || map[r + 1][c].isFall_through())) {
            swap(r, c);
            r++;
        }
    }

    private void addRowsOfWater() {
        int c = 0;
        while(c < L) {
            insert_rec(new WaterBlock(), 0, c);
            c++;
        }
    }

    public void addRiver() {
        addRowsOfWater();
    }

    public void addSea() {
        for(int i = 0; i < 3; i++) {
            addRowsOfWater();
        }
    }

    public boolean isSmeltable(int r, int c) {
        return map[r][c] instanceof SmeltableBlock;
    }

    public SmeltableBlock getSmeltable(int r, int c) {
        return (SmeltableBlock) map[r][c];
    }

    public void randomBlock() {
        Random rand = new Random();
        for (int i = 0 ; i < 20; i++){
            AbstractBlock b = new SandBlock();
            int row = rand.nextInt(H);
            int col = rand.nextInt(L);
            insert_rec(b, row, col);
        }
    }
}
