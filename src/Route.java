public class Route implements Allow{
    private int distance;

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }
    @Override
    public int allow() {
        return getDistance();
    }
}
