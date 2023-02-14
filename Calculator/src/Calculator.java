import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[11];
	JButton divButton, mulButton, subButton, addButton, sqrButton;
	JButton decButton, equButton, delButton, clrButton, negButton, perButton;
	JPanel panel;

	Font myFont = new Font("Kokila", Font.BOLD, 30);
	Font myFontFrame = new Font("Kokila", Font.BOLD, 60);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 647);
		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(31, 15, 325, 125);
		textfield.setFont(myFontFrame);
		textfield.setEditable(false);

		divButton = new JButton("/");
		mulButton = new JButton("*");
		subButton = new JButton("-");
		addButton = new JButton("+");
		decButton = new JButton(".");
		negButton = new JButton("+/-");
		delButton = new JButton("Del");
		clrButton = new JButton("C");
		equButton = new JButton("=");
		sqrButton = new JButton("R");
		perButton = new JButton("%");

		functionButtons[0] = divButton;
		functionButtons[1] = mulButton;
		functionButtons[2] = subButton;
		functionButtons[3] = addButton;
		functionButtons[4] = decButton;
		functionButtons[5] = negButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = equButton;
		functionButtons[9] = sqrButton;
		functionButtons[10] = perButton;

		for (int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		equButton.setBounds(31, 510, 325, 75);

		panel = new JPanel();
		panel.setBounds(31, 150, 325, 350);
		panel.setLayout(new GridLayout(5, 4, 10, 10));

		panel.add(functionButtons[6]);
		panel.add(functionButtons[7]);
		panel.add(functionButtons[9]);
		panel.add(functionButtons[5]);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(functionButtons[0]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(functionButtons[1]);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(functionButtons[2]);
		panel.add(numberButtons[0]);
		panel.add(functionButtons[4]);
		panel.add(functionButtons[10]);
		panel.add(functionButtons[3]);

		frame.add(panel);
		frame.add(equButton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");

		}
		if (e.getSource() == perButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");

		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case '%':
				result = num1 / 100 * num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		if (e.getSource() == sqrButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = Math.sqrt(temp);
			textfield.setText(String.valueOf(temp));

		}
	}
}
