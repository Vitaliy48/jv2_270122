import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random r = new Random();

        Route route1 = new Route ();
        Wall wall1 = new Wall ();

        route1.setDistance(r.nextInt(4));
        wall1.setHeight(r.nextInt(5));

        Cat cat1 = new Cat (2,5);
        Human human1 = new Human (1 ,4);
        Robot robot1 = new Robot (4,1);

        Action[] actionArry = new Action[] {cat1, human1, robot1};
        Allow[] allowArry = new Allow[]{route1, wall1};

        for (int i = 1; i < allowArry.length; i ++) {
            for ( int j =  0; j < actionArry.length; j ++) {
                if (!actionArry[j].run(allowArry[i].allow())) {
                    return;
                };
                actionArry[j].jump(allowArry[i].allow());
            }
        }
    }
}
