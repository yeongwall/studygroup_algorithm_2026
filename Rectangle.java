public class Rectangle {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isSquare() {
        return width == height;
    }

    public boolean contains(Rectangle r) {
        return r.x >= x && r.y >= y
            && r.x + r.width <= x + width
            && r.y + r.height <= y + height;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 3, 6, 6);
        Rectangle b = new Rectangle(4, 4, 2, 3);

        a.show();
        if (a.isSquare()) System.out.println("a는 정사각형입니다.");
        else System.out.println("a는 직사각형입니다.");
        if (a.contains(b)) System.out.println("a는 b를 포함합니다.");
    }
}