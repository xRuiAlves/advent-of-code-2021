package days.day17;

public record Square(int x1, int x2, int y1, int y2) {
    int width() {
        return x2 - x1;
    }

    int height() {
        return y1 - y2;
    }
}
