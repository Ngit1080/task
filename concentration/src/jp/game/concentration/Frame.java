package jp.game.concentration;

import javax.swing.JFrame;


public class Frame extends JFrame  {

	/*
	 *フレーム作成、神経衰弱という文字列をコンストラクタに渡す
	 * setVisibleメソッドの引数にtrueを指定する→Windowを表示
	 */

	public static void main(String[] args) {
		Screen screen = new Screen("神経衰弱");
		screen.setPanel();
		screen.setVisible(true);

	}
}
