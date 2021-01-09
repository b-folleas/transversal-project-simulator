package simulator.projet.model;

import java.io.Serializable;

public class MapItem implements Serializable {
    private Long id;
    private Integer posX;
    private Integer posY;
    private Ground ground;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "id='" + id + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                ", ground=" + ground +
                '}';
    }
}
