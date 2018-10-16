package AndreaPractice;

import AndreaPractice.MessageQueue;
import AndreaPractice.Player;


public class PlayerTester {

	
	public static void main(String[] args) {

		Player player1, player2;
		MessageQueue mbox = new MessageQueue();

		player1 = new Player(mbox);
		player2 = new Player(mbox);
	
	}
}
