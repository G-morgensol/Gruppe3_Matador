package Model;

public class Die {
    private final int minEye;
    private final int maxEye;

    /**
     * @param minEye lowest eye value of die
     * @param maxEye highest eye value of die
     */
    public Die(int minEye,int maxEye) {
        this.minEye = minEye;
        this.maxEye = maxEye;

    }

    public int rollDie(){
        return (int) (Math.random()*maxEye+minEye);
    }

}
