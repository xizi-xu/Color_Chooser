import javax.swing.JFrame;

/**
* This class the driver of color chooser program
* It allows user to set RGB values to see what color it would be
* It also has a feature to generate random color
* @author Liuxizi Xu
* @version 1.0
*/

public class ColorChooser {
	public static void main(String[] args) {
		//create a frame
		JFrame f = new JFrame("Color Chooser");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create the desired panel
		ColorChooserPanel panel = new ColorChooserPanel();
		//add the panel to the frame
		f.getContentPane().add(panel);
		f.pack();
		f.setVisible(true);
	}
}