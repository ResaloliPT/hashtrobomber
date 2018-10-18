package org.academiadecodigo.bootcamp.Objects;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private Position position;
    private Picture gOImage;

    public GameObject(int col, int row, String imgStr){
        this.position = new Position(col, row);
        gOImage = new Picture(position.getX(), position.getX(), imgStr);
    }

    public void changeImage(String imgSrc) {
        gOImage.load(imgSrc);
    }

    public void deleteImg() {
        gOImage.delete();
    }

    public void growImg(int x, int y) {
        gOImage.grow(x, y);
    }

    public void tanslateImg(int deltaX, int deltaY) {
        gOImage.translate(deltaX, deltaY);
    }

    public int getCol() {
        return position.getCol();
    }

    public int getRow() {
        return position.getRow();
    }

    public void setCol(int col) {
        position.setCol(col);
    }

    public void setRow(int row) {
        position.setRow(row);
    }
}
