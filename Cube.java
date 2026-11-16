public class Cube {
    private int width;
    private int depth;
    private int height;

    public Cube(int w, int d, int h){
        width = w; 
        depth = d; 
        height = h;
    }
    
    public int getVolume() {
        return width*height*depth;
    }

    public void increase(int o, int tw, int th){
        width += o;
        depth += tw;
        height += th;
    }

    public boolean isZero(){
        return getVolume() == 0;
    }

    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1,2,3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if (cube.isZero())
            System.out.println("큐브의 부피는 0");
        else
            System.out.println("큐브의 부피는 0이 아님");
    }
}
