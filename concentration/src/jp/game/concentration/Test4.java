package jp.game.concentration;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Test4 extends Frame
    implements ActionListener  {
        private Thread th;
        private boolean running;

    Label label = new Label("神経衰弱",Label.LEFT);
    Button resetbutton = new Button("リセット");
    Panel flow3 = new Panel(new
FlowLayout(FlowLayout.LEFT,5,5));
    Panel grid2 = new Panel(new
GridLayout(4,4,5,5));
    Panel border1 = new Panel(new
BorderLayout(5,5));

    Button[] button = new Button[16];
    int[] map = new int[16];
    int[] tmp = new int[2];
    ArrayList<Integer> list1 = new
ArrayList<Integer>();
    ArrayList<Integer> list2 = new
ArrayList<Integer>();
    String disp ="";
    int count = 1;
    int clear = 0;

    public Test4() {
        super("test4");
        this.setResizable(true);

this.setBackground(SystemColor.control);

this.setForeground(SystemColor.controlText);

resetbutton.addActionListener(this);
        flow3.add(label);
        flow3.add(resetbutton);
        for(int i=0;i<16;i++){
            button[i] = new Button("");

button[i].addActionListener(this);
            grid2.add(button[i]);
        }
        border1.add("North",flow3);
        border1.add("Center",grid2);
        add("Center",border1);
        pack();
        addWindowListener(new
ClosingWindowListener());
        setSize(500,500);
        setVisible(true);

        for (int i=0;i<8;i++) {
            list1.add(i);
            list2.add(i);
        }
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        for(int i=0;i<8;i++){
            map[i] = list1.get(i);
            map[i+8] = list2.get(i);
        }
    }

    public void actionPerformed(ActionEvent
evt) {
    for(int i=0;i < 16;i++){
        if ( evt.getSource() == button[i])
{
            disp = "" + map[i];
            button[i].setLabel(disp);

            switch(count){
                case 1:
                    tmp[0] =
i;
                    count = 2;

button[i].setEnabled(false);

System.out.println(map[tmp[0]]);
                    break;

                case 2:
                    tmp[1] =
i;

if(map[tmp[0]] == map[tmp[1]]){

button[i].setEnabled(false);

clear++;

label.setText(clear + "組正解");
                    }else{

button[tmp[0]].setLabel("");

button[tmp[1]].setLabel("");

button[tmp[0]].setEnabled(true);

System.out.println(map[tmp[1]]);
                    }if(clear
== 8){

label.setText("Clear");
                    }
                    count = 1;
                    break;
            }
        }if(evt.getSource()==resetbutton){
            Arrays.fill(tmp,0);
            disp = "";
            count = 1;
            clear = 0;
            label.setText("神経衰弱");
            for(int j=0;j < 16;j++){

button[j].setEnabled(true);
            button[j].setLabel("");
            }
        }
    }
}

public static void main(String[] args){
      new Test4();
    }

    class ClosingWindowListener extends
WindowAdapter{
      public void windowClosing(WindowEvent evt){
         System.exit(0);
      }
   }

}