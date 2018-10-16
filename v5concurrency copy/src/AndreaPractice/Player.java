package AndreaPractice;

import AndreaPractice.MessageQueue;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;



public class Player  extends JFrame implements ActionListener {

    private JPanel panel;
 	private JTextArea s_data;
 	private JTextArea r_data;
    private JButton s_button;
    private JButton r_button;
    
    MessageQueue infinite_mbox = new MessageQueue();
    
    public Player (MessageQueue msgq) {

        this.setSize(400, 300);
        this.createGUI();
        this.setVisible(true);
        
        this.infinite_mbox = msgq;
        

    }
    
    private void createGUI() { 

    	setDefaultCloseOperation(EXIT_ON_CLOSE); 

    	Container window = getContentPane(); 
    	window.setLayout(new FlowLayout() );

    	panel = new JPanel();
    	panel.setPreferredSize(new Dimension(300, 200)); 
    	panel.setBackground(Color.white);
    	
    	s_button = new JButton("Send");	
    	s_button.addActionListener(this);
     	r_button = new JButton("Receive");
      	r_button.addActionListener(this);
      	
      	s_data = new JTextArea("msg to send", 1, 10);
    	r_data = new JTextArea("received mgs", 1, 10);
    	
//   	window.add(panel);
    	window.add(s_button);
    	window.add(s_data);
    	window.add(r_button);
    	window.add(r_data);
    		
    }
    
    public void actionPerformed(ActionEvent event) {
    	String tmp_string;
    	
    	//Graphics paper = panel.getGraphics(); 
    
    	if (event.getSource() == s_button) {
    		infinite_mbox.send(s_data.getText().toString());
    	}
    	if (event.getSource() == r_button) {
    		tmp_string = infinite_mbox.receive();
    		if (tmp_string != null) {
    			r_data.setText(tmp_string);}
    		else {
    			r_data.setText("ERROR");
    		}
    	}
        	
    }

	
}
