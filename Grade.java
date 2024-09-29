/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codsoft.java;

/**
 *
 * @author Jayalakshmi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grade{
  JFrame frame;
  JLabel subject1, subject2, subject3, subject4, subject5, subject6;
  JTextField mark1, mark2, mark3, mark4, mark5, mark6;
  JButton grade;
  JLabel total_display, avg_display, grade_display;

  Grade() {
    frame = new JFrame("Grade Calculator");

    subject1 = new JLabel("Subject 1");
    subject2 = new JLabel("Subject 2");
    subject3 = new JLabel("Subject 3");
    subject4 = new JLabel("Subject 4");
    subject5 = new JLabel("Subject 5");
    subject6 = new JLabel("Subject 6");

    mark1 = new JTextField(30);
    mark2 = new JTextField(30);
    mark3 = new JTextField(30);
    mark4 = new JTextField(30);
    mark5 = new JTextField(30);
    mark6 = new JTextField(30);

    grade = new JButton("Calculate grade");

    frame.add(subject1);
    frame.add(mark1);
    frame.add(subject2);
    frame.add(mark2);
    frame.add(subject3);
    frame.add(mark3);
    frame.add(subject4);
    frame.add(mark4);
    frame.add(subject5);
    frame.add(mark5);
    frame.add(subject6);
    frame.add(mark6);
    frame.add(grade);

    total_display = new JLabel("");
    avg_display = new JLabel("");
    grade_display = new JLabel("");

    frame.add(total_display);
    frame.add(avg_display);
    frame.add(grade_display);

    frame.setSize(250, 250);
    frame.setLayout(new GridLayout(9,1));
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    grade.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int marks1 = Integer.parseInt(mark1.getText());
        int marks2 = Integer.parseInt(mark2.getText());
        int marks3 = Integer.parseInt(mark3.getText());
        int marks4 = Integer.parseInt(mark4.getText());
        int marks5 = Integer.parseInt(mark5.getText());
        int marks6 = Integer.parseInt(mark6.getText());
        int total = marks1 + marks2 + marks3 + marks4 + marks5 + marks6;
        int avg = total / 6;
        total_display.setText("Total marks: " + String.valueOf(total));
        avg_display.setText("Average marks: " + String.valueOf(avg));

        if (avg >= 90)
          grade_display.setText("Grade: O");
        else if (avg >= 80)
          grade_display.setText("Grade: A+");
        else if (avg >= 70)
          grade_display.setText("Grade: A");
        else if (avg >= 60)
          grade_display.setText("Grade: B+");
        else if (avg >= 50)
          grade_display.setText("Grade: B");
        else if (avg >= 40)
          grade_display.setText("Grade: C");
        else
          grade_display.setText("Grade: F");

        Timer reset = new Timer(10000, new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            mark1.setText("");
            mark2.setText("");
            mark3.setText("");
            mark4.setText("");
            mark5.setText("");
            mark6.setText("");
            total_display.setText("");
            avg_display.setText("");
            grade_display.setText("");

          }

        });

        reset.setRepeats(false);
        reset.start();
      }
    });

  }

  public static void main(String[] args) {
    new Grade();
  }

}