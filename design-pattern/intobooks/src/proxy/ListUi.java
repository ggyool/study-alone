package proxy;

import java.util.List;

public class ListUi {

    private List<Image> images;

    public ListUi(List<Image> images) {
        this.images = images;
    }

    public void onScroll(int start, int end) {
        for (int i = start; i < end; i++) {
            images.get(i).draw();
        }
    }
}
