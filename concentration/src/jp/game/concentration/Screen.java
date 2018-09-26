package jp.game.concentration;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Screen extends JFrame implements ActionListener {

	JButton[] button = new JButton[20];  //カード
	int[] card = new int[20];           //パネルの配列
	int click1;
	int click2;
	int count = 0;
	boolean state;
	int openCount;


	public void setPanel() {

		 //iが10未満だったらlist変数にiの値を追加
		 //2回追加することでペアを作成

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
			list.add(i);

		//リスト内の数字をシャッフル
		Collections.shuffle(list);
		}


		for(int i = 0; i < 20; i++) {
			card[i] = list.get(i);
		}
	}



	 //フレームの大きさ、表示位置の設定
	 //アプリケーション終了をクローズ処理にする

	Screen(String title){
		super(title);
		setSize(1000, 600);
		setBounds(230,120,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		 //指定した行と列の数によって領域を均等に分割するレイアウトマネージャー
		 //rows 行数
		 //cols 列数
		setLayout(new GridLayout(4,5,30,40));

		for(int i = 0; i < 20; i++){
			button[i] = new JButton();
			button[i].addActionListener(this);
			add(button[i]);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 20; i++) {
			if(e.getSource() == button[i]) {
				if(openCount > 0){
					if(click1 == i){
						button[click1].setText("");
						openCount--;
					}else if(click2 == i){
						button[click2].setText("");
						openCount--;
					}
				}else{
				if(state == false){
					click1 = i;
					button[click1].setText(String.valueOf(card[click1]));
					state = true;
				}else if(state == true){
					click2 = i;
					button[click2].setText(String.valueOf(card[click2]));
					state = false;
						if(((state == false) && (card[click1] == card[click2]) && (click1 != click2))) {
							button[click1].setEnabled(false);
							button[click2].setEnabled(false);
//							click2 = click1;
						}else if((state == false) && (card[click1] != card[click2])){
							openCount = 2;
						}
				}
				}
			}
		}
	}

}

