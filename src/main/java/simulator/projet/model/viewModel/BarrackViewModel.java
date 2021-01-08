package simulator.projet.model.viewModel;

import java.io.Serializable;
import java.util.Optional;


public class BarrackViewModel  implements Serializable{

        private int posX;
        private int posY;
        private String name;

        public int getPosX() {
            return posX;
        }

        public void setPosX(int posX) {
            this.posX = posX;
        }

        public int getPosY() {
            return posY;
        }

        public void setPosY(int posY) {
            this.posY = posY;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public BarrackViewModel(int posX, int posY, String name) {
        this.posX = posX;
        this.posY = posY;
        this.name = name;
    }
}
