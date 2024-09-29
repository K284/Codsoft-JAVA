/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codsoft.java;

/**
 *
 * @author Jayalakshmi
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class NumberGame {
  JFrame newFrame;
  JLabel label;
  JTextField entry;
  JButton b;
  JLabel msg;
  int number;
  int score = 100;
  JLabel score_display;
  Random random;

  NumberGame() {
    newFrame = new JFrame("Number Game");
    newFrame.setLayout(new GridLayout(6,1));
    newFrame.setSize(250, 250);
    newFrame.setVisible(true);
    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    label = new JLabel("Guess a number between 1 and 100");
    entry = new JTextField(30);
    newFrame.add(label);
    newFrame.add(entry);

    b = new JButton("Check");
    b.setSize(20, 20);
    newFrame.add(b);

    msg = new JLabel();
    newFrame.add(msg);

    random = new Random();
    number = random.nextInt(1, 100);

    score_display = new JLabel("");
    newFrame.add(score_display);

    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        int guess = Integer.parseInt(entry.getText());
        if (guess == number) {
          msg.setText("Correct");
          score += 20;
          score_display.setText("Score: " + String.valueOf(score));
          Timer resetTimer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              entry.setText("");
              entry.setEnabled(false);
              b.setEnabled(false);
              msg.setText("GAME OVER");
            }
          });
          resetTimer.setRepeats(false);
          resetTimer.start();

        }

        else if (guess > 100 || guess < 1)
          msg.setText("Out of range");

        else if (guess < number) {
          msg.setText("Too low!");
          score -= 10;
          score_display.setText("Score: " + String.valueOf(score));

          if (score < 0) {
            JOptionPane.showMessageDialog(newFrame, "Game Over! Score less than zero!!");
            entry.setText("");
            entry.setEnabled(false);
            b.setEnabled(false);
            msg.setText("GAME OVER");
            score_display.setText("");
          }
        }

        else if (guess > number) {
          msg.setText("Too high!");
          score -= 10;
          score_display.setText("Score: " + String.valueOf(score));

          if (score < 0) {
            JOptionPane.showMessageDialog(newFrame, "Game Over! Score less than zero!!");
            entry.setText("");
            entry.setEnabled(false);
            b.setEnabled(false);
            msg.setText("GAME OVER");
            score_display.setText("");
          }
        }
      }
    });
  }

  public static void main(String[] args) {
    new NumberGame();
  }
}
