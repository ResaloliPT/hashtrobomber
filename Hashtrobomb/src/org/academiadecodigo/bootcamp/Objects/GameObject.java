package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Position.Position;

public abstract class GameObject {
    protected Position position;
    protected boolean destroyed;

    public boolean checkCollision(){
        return false;
    }

    public Position getPosition(){
        return position;
    }
}
