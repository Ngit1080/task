package jp.game.concentration;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame{
	public static void main(String[] args) {
		Window window = new Window("神経衰弱");
		window.setSize(1000, 600);
		window.setVisible(true);
		//window.getContentPane().add(getDefPanel());

	}

	Window(String title){
		setTitle(title);
		setBounds(230,120,1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//JPanelクラスのインスタンス作成
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		//記憶力トレーニングという文字列の場所、大きさ、フォント指定
		JLabel label = new JLabel("記憶力トレーニング");
		label.setPreferredSize(new Dimension(200,500));
		label.setFont(new Font("Century", Font.ITALIC, 22));

		//STARTという文字列の引数ありのボタン
		JButton btn = new JButton("START");

		//パネルに加える
		panel1.add(btn);
		panel2.add(label);

		//コンテナに加える
		//ボタンと文字のパネルは別にする
		Container contentPane = getContentPane();
		contentPane.add(panel1,BorderLayout.SOUTH);
		contentPane.add(panel2,BorderLayout.CENTER);
	}


//	private static JPanel getDefPanel(){
//		JPanel panel = new JPanel();
//
//		JButton button = new JButton("新規パネルへ");
//		button.setActionCommand("2");
//		button.addActionListener(this);
//		panel.add(new JLabel("初期パネル"));
//		panel.add(button);
//		return panel;
//		}
}




