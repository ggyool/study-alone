package a411_anonymous_class_axample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        EventHandler eventHandler = new EventHandler();
        // 익명 클래스 미사용
//        button.addActionListener(new EventHandler());

        // 익명 클래스 사용
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    static class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

