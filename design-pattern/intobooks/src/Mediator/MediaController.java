package Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediaController {

    private List<ControllerObserver> controllerObservers = new ArrayList<>();

    public MediaController(){
    }

    public void addObserver(ControllerObserver controllerObserver) {
        controllerObservers.add(controllerObserver);
    }

    public void clickPlayStopButton() {
        for (ControllerObserver controllerObserver : controllerObservers) {
            controllerObserver.clickPlayStopButton();
        }
    }

    public void clickNextButton() {
        for (ControllerObserver controllerObserver : controllerObservers) {
            controllerObserver.clickNextButton();
        }
    }

    public void clickPrevButton() {
        for (ControllerObserver controllerObserver : controllerObservers) {
            controllerObserver.clickPrevButton();
        }
    }
}
