public class Robot implements Action {
    private int speed;
    private int maxJump ;

    public Robot (int speed, int maxJump) {
        this.speed = speed;
        this.maxJump = maxJump;
    }
    public int getSpeed( ) {
        return speed;
    }
    public int getMaxJump( ){
        return maxJump;
    }
    @Override
    public boolean run(int Distance) {
        if (getSpeed() > Distance) {
            System.out.println("Робот пробежал");
            return true;
        } else {
            System.out.println("Робот не смог пробежать");
            return false;
        }
    }
    @Override
    public boolean jump(int height) {
        if (getMaxJump() > height) {
            System.out.println("Робот смог перепрыгнуть");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть");
            return false;
        }
    }
}
