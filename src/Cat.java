public class Cat implements Action {
    private int speed;
    private int maxJump ;

    public Cat (int speed, int maxJump) {
        this.speed = speed;
        this.maxJump = maxJump;
    }
    public int getSpeed ( ) {
        return speed;
    }
    public int getMaxJump ( ) {
        return maxJump;
    }
     @Override
    public boolean run (int Distance) {
        if (getSpeed() > Distance) {
            System.out.println("Кот пробежал");
            return true;
        } else {
            System.out.println("Кот не смог пробежать");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (getMaxJump() > height) {
            System.out.println( "Кот смог перепрыгнуть" );
            return true;
        } else {
            System.out.println( "Кот не смог перепрыгнуть" );
            return false;
        }
    }
}
