package jp.game.concentration;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LayoutTestBorder2 extends JFrame {

  public LayoutTestBorder2(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,300);

    setLayout(new BorderLayout(10,5));
    Container contentPane = getContentPane();
//    contentPane.add(
//      new JButton("1 - North"),
//      BorderLayout.NORTH);
    contentPane.add(
      new JButton("2 - South"),
      BorderLayout.SOUTH);
    contentPane.add(
      new JButton("3 - West"),
      BorderLayout.WEST);
    contentPane.add(
      new JButton("4 - East"),
      BorderLayout.EAST);
    contentPane.add(
      new JButton("5 - Center"),
      BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        createAndShowGUI();
      }
    });
  }

  protected static void createAndShowGUI() {
    LayoutTestBorder2 frame = new LayoutTestBorder2();
    frame.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    frame.setVisible(true);
  }
}