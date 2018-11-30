package org.academiadecodigo.bootcamp.Objects;

public class DestoyableAbstract extends GameObject implements Destroyable {

    boolean destroyed;

    public DestoyableAbstract(int row, int col, String img) {
        super(row, col, img);
        destroyed = false;
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
