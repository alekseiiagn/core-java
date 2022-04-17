package corejava.chapter3.additional;

public class Methods {
    private int x;

    static public int Static() {
        return 10;
    }

    public int InstanceClass(int y) {
        return this.x + y;
    }

    /*    static public int InstanceObject(int x){
            return x;
        }*/

    static public boolean isEqual(Integer x, Integer y) {
        return x.equals(y);
    }



}
