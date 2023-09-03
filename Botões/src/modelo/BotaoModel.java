package modelo;

public class BotaoModel {
    private int x1, y1=100, x2 = 1, y2 = 400;
    private int l = 5, a = 5, l1 = -5, a1 = -5;

    public void setA(int a) {
        this.a = a;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void updateCoordinates(int width, int height) {
        x1 += l;
        y1 += a;
        x2 += l1;
        y2 += a1;

        if (x1 >= width - 120 || x1 <= 0) {
            l *= -1;
        }

        if (y1 >= height - 90 || y1 <= 0) {
            a *= -1;
        }

        if (x2 >= width - 120 || x2 <= 0) {
            l1 *= -1;
        }

        if (y2 >= height - 90 || y2 <= 0) {
            a1 *= -1;
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getL() {
        return l;
    }

    public int getA() {
        return a;
    }

    public int getL1() {
        return l1;
    }

    public int getA1() {
        return a1;
    }
}
