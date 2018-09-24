package jp.game.concentration;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Screen extends JFrame implements ActionListener {

	/*
	 *フレーム作成、神経衰弱という文字列の引数をコンストラクタに渡す
	 * setVisibleメソッドの引数にtrueを指定する→Windowを表示
	 */

	public static void main(String[] args) {
		Screen screen = new Screen("神経衰弱");
		screen.setPanel();
		screen.setVisible(true);
	}


	public void setPanel() {
		/*
		 * iが10未満だったらlist変数にiの値を追加
		 * 2回追加することでペアを作成
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
			list.add(i);
		}

		//リスト内の数字をシャッフル
		Collections.shuffle(list);

		for(int i = 0; i < 20; i++) {
			panel[i] = list.get(i);
		}

	}

	JButton[] button = new JButton[20];  //カード
	int[] panel = new int[20];           //パネルの配列
	int click1;
	int click2 = 1;
	int count = 0;


	/*
	 *フレームの大きさ、表示位置の設定
	 *アプリケーション終了をクローズ処理にする
	 */
	Screen(String title){
		super(title);
		//setTitle(title);
		setSize(1000, 600);
		setBounds(230,120,1000,600);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 指定した行と列の数によって領域を均等に分割するレイアウトマネージャー
		 * public GridLayout(int rows,int cols)
		 * rows 行数
		 * cols 列数
		 *
		 */
		setLayout(new GridLayout(4, 5));

		for(int i = 0; i < 20; i++){
			button[i] = new JButton();
			button[i].addActionListener(this);
			add(button[i]);
		}


		/*
		 * デフォルトのレイアウトマネージャー
		 * 置かれたGUI部品を1つずつ左から右へ配置
		 */
//		setLayout(new FlowLayout());


		//ボタンを作成、位置を指定
//		JButton btn = new JButton("START");
//		add(btn,BorderLayout.NORTH);



		//アイコンの設定
		ImageIcon icon = new ImageIcon("./images/icon.png");
		setIconImage(icon.getImage());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 20; i++) {
			if(e.getSource() == button[i]) {
				click1 = i;
				if(click1 != click2) {
					System.out.println();
					button[i].setText(String.valueOf(panel[i]));
					count++;
					break;
				}
			}
		}

		if(((count % 2) == 0) && (panel[click1] == panel[click2])) {
			button[click1].setEnabled(false);
			button[click2].setEnabled(false);
		}
		click2 = click1;

	}



}
