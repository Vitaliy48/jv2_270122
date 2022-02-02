public class Wall implements Allow {
    private int height;

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    @Override
    public int allow() {
        return getHeight();
    }
}