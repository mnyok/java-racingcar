package racingcar.view;

public class LaneView {
    private final String name;
    private final int position;

    public LaneView(String name, int position) {
        this.name = name;
        this.position = position;
    }

    void print() {
        ResultView.print(name + " : ");
        for (int i = 0; i < position; i++) {
            ResultView.print("-");
        }
        ResultView.println();
    }
}
