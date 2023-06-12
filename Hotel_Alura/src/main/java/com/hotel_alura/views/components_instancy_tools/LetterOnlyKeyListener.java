package com.hotel_alura.views.components_instancy_tools;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LetterOnlyKeyListener implements KeyListener {
    private JTextField textFieldContent;

    public LetterOnlyKeyListener(JTextField textFieldContent) {
        this.textFieldContent = textFieldContent;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!isValidCharacter(c)) {
            e.consume();
        }
    }
    private boolean isValidCharacter(char c) {
        return Character.isLetter(c);
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
