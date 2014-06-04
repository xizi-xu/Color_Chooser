import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;

/**
* This class represents the panel object for color chooser
* It contains two private classes in addtion to constructor
* One private class for button listener
* Another one for text field listener
* Constructor creates different components and organizes
* them within the panel
* @author Liuxizi Xu
* @version 1.0
*/

public class ColorChooserPanel extends JPanel {
	private JLabel rl, gl, bl;
	private JButton randomcolor;
   	private JPanel colorbox;
	private JTextField rt, gt, bt;
	private int r = 0, g = 0, b = 0;

	public ColorChooserPanel() {
		//create a button with listener
		randomcolor = new JButton("Random Color");
		randomcolor.addActionListener(new BL());

		//create 3 text fields with listener
		TL listener = new TL();
		rt = new JTextField("0", 3);
		rt.addActionListener(listener);
		gt = new JTextField("0", 3);
		gt.addActionListener(listener);
		bt = new JTextField("0", 3);
		bt.addActionListener(listener);

		//create 3 labels
		rl = new JLabel("Red");
		gl = new JLabel("Green");
		bl = new JLabel("Blue");

		//create another panel to represent the color
		//generated by user or random
      		colorbox = new JPanel();
      		colorbox.setPreferredSize(new Dimension(100, 100));
     		colorbox.setBackground(new Color(r, g, b));

     		//add all the components in order
		add(rl);
		add(rt);
		add(gl);
		add(gt);
		add(bl);
		add(bt);
		add(randomcolor);
      		add(colorbox);

      	//set default size
		setPreferredSize(new Dimension(470, 170));
	}

	/**
	* This class creates the listener to the button
	* it generates random RGB values and
	* display the color
	*/

	private class BL implements ActionListener {

		/**
		* This method generates random RGB values
		* and it updates the color
		* @param event(button is pressed)
		* @return none
		*/

		public void actionPerformed(ActionEvent event) {
			Random rand = new Random();
			r = rand.nextInt(256);
         		rt.setText(Integer.toString(r));
			g = rand.nextInt(256);
         		gt.setText(Integer.toString(g));
			b = rand.nextInt(256);
         		bt.setText(Integer.toString(b));
         		//update the color
         		colorbox.setBackground(new Color(r, g, b));
		}
	}

	/**
	* This class creates the listener to the texitfield
	* it takes user's input of RGB values and
	* display the color
	*/

	private class TL implements ActionListener {

		/**
		* This method check with which textfield is entered
		* with value and it updates the color when RGB
		* values are in the valid range
		* @param event(enter key is pressed)
		* @return none
		*/

		public void actionPerformed(ActionEvent event) {
         		int temp;
			if (event.getSource() == rt) {
				//convert entered value to int
				temp = Integer.parseInt(rt.getText());
				//update value if it is valid
            			if (temp >= 0 && temp <= 255) {
               				r = temp;
            			}
			}
			if (event.getSource() == gt) {
				temp = Integer.parseInt(gt.getText());
            			if (temp >= 0 && temp <= 255) {
               				g = temp;
            			}
			}
			if (event.getSource() == bt) {
				temp = Integer.parseInt(bt.getText());
            			if (temp >= 0 && temp <= 255) {
               				b = temp;
            			}
			}
        		colorbox.setBackground(new Color(r, g, b));
		}
	}
}
