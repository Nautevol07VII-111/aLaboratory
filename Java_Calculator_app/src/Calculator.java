import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {
    
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[15]; 
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton, negButton;
    
   
    JButton sinButton, cosButton, tanButton, 
            logButton, lnButton, powerButton, sqrtButton, expButton, piButton;
    
    JPanel panel;
    JPanel scientificPanel;

    Font myFont = new Font("Arial", Font.BOLD, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Decimal formatting for clean output
    DecimalFormat df = new DecimalFormat("#.########");

    Calculator() {
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 700); 
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 400, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);

        // Basic function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        lnButton = new JButton("ln");
        powerButton = new JButton("^");
        sqrtButton = new JButton("√");
        expButton = new JButton("exp");
        piButton = new JButton("π");

        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        
       
        functionButtons[9] = sinButton;
        functionButtons[10] = cosButton;
        functionButtons[11] = tanButton;
        functionButtons[12] = logButton;
        functionButtons[13] = lnButton;
        functionButtons[14] = powerButton;

       
        for(int i = 0; i < functionButtons.length; i++) {
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(myFont);
           functionButtons[i].setFocusable(false);
        }

        
        for(int i = 0; i < 10; i++) {
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].addActionListener(this);
           numberButtons[i].setFont(myFont);
           numberButtons[i].setFocusable(false);
        }
         
        
        negButton.setBounds(50, 530, 100, 50);
        delButton.setBounds(150, 530, 100, 50);
        clrButton.setBounds(250, 530, 100, 50);

       
        panel = new JPanel();
        panel.setBounds(50, 100, 400, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.WHITE);

        
        scientificPanel = new JPanel();
        scientificPanel.setBounds(50, 400, 400, 130);
        scientificPanel.setLayout(new GridLayout(2,5,5,5));
        scientificPanel.add(sinButton);
        scientificPanel.add(cosButton);
        scientificPanel.add(tanButton);
        scientificPanel.add(logButton);
        scientificPanel.add(lnButton);
        scientificPanel.add(powerButton);
        scientificPanel.add(sqrtButton);
        scientificPanel.add(expButton);
        scientificPanel.add(piButton);

        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        
        frame.add(panel);
        frame.add(scientificPanel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        
        if(e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

       
        if(e.getSource() == sinButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.sin(Math.toRadians(num1));
            textfield.setText(df.format(result));
        }

        if(e.getSource() == cosButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.cos(Math.toRadians(num1));
            textfield.setText(df.format(result));
        }

        if(e.getSource() == tanButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.tan(Math.toRadians(num1));
            textfield.setText(df.format(result));
        }

        if(e.getSource() == logButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.log10(num1);
            textfield.setText(df.format(result));
        }

        if(e.getSource() == lnButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.log(num1);
            textfield.setText(df.format(result));
        }

        if(e.getSource() == powerButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '^';
            textfield.setText("");
        }

        if(e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.sqrt(num1);
            textfield.setText(df.format(result));
        }

        if(e.getSource() == expButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = Math.exp(num1);
            textfield.setText(df.format(result));
        }

        if(e.getSource() == piButton) {
            textfield.setText(String.valueOf(Math.PI));
        }

        
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
               case'+':
               result = num1 + num2; 
               break;
               case'-':
               result = num1 - num2; 
               break;
               case'*':
               result = num1 * num2; 
               break;
               case'/':
               result = num1 / num2; 
               break;
               case'^':
               result = Math.pow(num1, num2);
               break;
            }
            textfield.setText(df.format(result));
            num1 = result;
        }

        
        if(e.getSource() == clrButton) {
            textfield.setText("");
        }

        if(e.getSource() == delButton) {
            String deleter = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < deleter.length() - 1; i++) {
                textfield.setText(textfield.getText()+deleter.charAt(i));
            }
        }

        
        if(e.getSource() == negButton) {
          double temp = Double.parseDouble(textfield.getText());
          temp *= -1;
            textfield.setText(df.format(temp));
        }
    }
}