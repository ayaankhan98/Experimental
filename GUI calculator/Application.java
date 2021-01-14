/**
 * @author ayaankhan98
 *
 * Name: Ayaan Khan
 * Enrollment: GL3134
 * FacultyNumber: 19COB049
 *
 * @brief Calculator GUI application using Java Swing, able to perform
 * basic arithmetic operations
 *
 * Features
 * 1. Themes customization
 * 2. Font Style customization
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.Stack;


/**
 * class for calculator app JFrame
 */
class Calculator extends JFrame {

    // Top menubar
    private final JMenuBar menuBar;

    // input field for expression
    private final JTextField inputField;

    // panel for number pad
    private final JPanel numberPanel;

    // panel for operator pad
    private final JPanel operatorPanel;

    // creating an array for buttons (0 - 9) and +, -, *, /, DEL, = , ( and )
    private final JButton[] buttons;

    Calculator() {

        // setting the frame title
        this.setTitle("Calculator");

        // setting default operation for frame close button to close on click by default this is set to hide
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting relative location of frame so that it will appear near the center of screen if we do not set this
        // then frame will open on top left corner of monitor screen
        this.setLocationRelativeTo(null);

        // setting the size for Frame
        this.setSize(560, 520);

        // not providing resizable facility for frame
        this.setResizable(false);

        // setting the background color of frame
        this.getContentPane().setBackground(new Color(0xdff5e6));

        // setting the layout to null because components are placed using setBound() method on appropriate place on
        // frame. by default layout of JFrame is BorderLayout
        this.setLayout(null);


        // creating Menubar
        menuBar = new JMenuBar();

        // setting background of menubar
        menuBar.setBackground(new Color(0xdff5e6));

        // creating a menu option for menubar
        JMenu customizationMenu = new JMenu("Customize");

        // creating another menu option for menubar
        JMenu moreMenu = new JMenu("More");

        // creating menu items for both menu
        JMenuItem themesMenuItem = new JMenuItem("Theme");
        JMenuItem fontsMenuItem = new JMenuItem("Font");
        JMenuItem helpMenuItem = new JMenuItem("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // adding menu items to their respective menu
        customizationMenu.add(themesMenuItem);
        customizationMenu.add(fontsMenuItem);
        moreMenu.add(helpMenuItem);
        moreMenu.add(aboutMenuItem);
        moreMenu.add(exitMenuItem);

        // adding menu to menubar
        menuBar.add(customizationMenu);
        menuBar.add(moreMenu);

        // creating a text field for taking input of expression
        inputField = new JTextField();

        // placing text filed on frame using setBounds()
        inputField.setBounds(10, 15, 520, 100);

        // setting font for text filed.
        inputField.setFont(new Font("Mv Boli", Font.PLAIN, 45));

        // creating a panel for number pad
        numberPanel = new JPanel();

        // setting background of number pad panel
        numberPanel.setBackground(new Color(0xdff5e6));

        // setting layout to grid layout to form a gird for numbers (0 - 9)
        numberPanel.setLayout(new GridLayout(3, 4, 10, 10));

        // placing the number pad on the frame using setBounds()
        numberPanel.setBounds(10, 140, 300, 300);

        // creating another panel for operators pad
        operatorPanel = new JPanel();

        // setting background color for operator pad panel
        operatorPanel.setBackground(new Color(0xdff5e6));

        // setting layout of operator pad panel to grid layout
        operatorPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // placing the operator panel on frame using setBounds()
        operatorPanel.setBounds(350, 140, 180, 300);

        // initializing button array
        // index 0 to 9 are buttons for number 0 to 9
        buttons = new JButton[18];
        for (int i = 0; i <= 9; i++) {
            buttons[i] = new JButton((i) + "");
        }
        // index 10 to 17 are other buttons for (, ), +, -, *, /, = and DEL
        buttons[10] = new JButton("(");
        buttons[11] = new JButton(")");
        buttons[12] = new JButton("+");
        buttons[13] = new JButton("-");
        buttons[14] = new JButton("*");
        buttons[15] = new JButton("/");
        buttons[16] = new JButton("=");
        buttons[17] = new JButton("DEL");

        // setting background color for all buttons
        setButtonBackgroud(new Color(0xbfd6c3));

        // setting font for all buttons
        setButtonFont(new Font("Mv Boli", Font.PLAIN, 35));

        // setting button on click focusable to false
        setButtonFocusable(false);

        // setting border for all buttons
        setButtonBorder(new Color(0x5c9e71), new Color(0x0a5923));


        // -- Adding action listners to all buttons -- //

        // Number 0
        buttons[0].addActionListener(action -> {
            // setting text on click of 0 button
            inputField.setText(inputField.getText() + "0");
        });

        // Number 1
        buttons[1].addActionListener(action -> {
            // setting text on click of 1 button
            inputField.setText(inputField.getText() + "1");
        });

        // Number 2
        buttons[2].addActionListener(action -> {
            // setting text on click of 2 button
            inputField.setText(inputField.getText() + "2");
        });

        // Number 3
        buttons[3].addActionListener(action -> {
            // setting text on click of 3 button
            inputField.setText(inputField.getText() + "3");
        });

        // Number 4
        buttons[4].addActionListener(action -> {
            // setting text on click of 4 button
            inputField.setText(inputField.getText() + "4");
        });

        // Number 5
        buttons[5].addActionListener(action -> {
            // setting text on click of 5 button
            inputField.setText(inputField.getText() + "5");
        });

        // Number 6
        buttons[6].addActionListener(action -> {
            // setting text on click of 6 button
            inputField.setText(inputField.getText() + "6");
        });

        // Number 7
        buttons[7].addActionListener(action -> {
            // setting text on click of 7 button
            inputField.setText(inputField.getText() + "7");
        });

        // Number 8
        buttons[8].addActionListener(action -> {
            // setting text on click of 8 button
            inputField.setText(inputField.getText() + "8");
        });

        // Number 9
        buttons[9].addActionListener(action -> {
            // setting text on click of 9 button
            inputField.setText(inputField.getText() + "9");
        });

        // Button (
        buttons[10].addActionListener(action -> {
            // setting text on click of ( button
            inputField.setText(inputField.getText() + "(");
        });

        // Button )
        buttons[11].addActionListener(action -> {
            // setting text on click of ) button
            inputField.setText(inputField.getText() + ")");
        });


        // Add Button
        buttons[12].addActionListener(action -> {
            // setting text on click of + button
            inputField.setText(inputField.getText() + "+");
        });

        // Subtraction Button
        buttons[13].addActionListener(action -> {
            // setting text on click of - button
            inputField.setText(inputField.getText() + "-");
        });

        // Multiplication Button
        buttons[14].addActionListener(action -> {
            // setting text on click of * button
            inputField.setText(inputField.getText() + "*");
        });

        // Divide Button
        buttons[15].addActionListener(action -> {
            // setting text on click of / button
            inputField.setText(inputField.getText() + "/");
        });


        // Equal Button
        buttons[16].addActionListener(action -> {

            // if user clicks the = button then first validate the expression
            // if the expression if valid then validateExpression() method will return true
            // and expression is evaluated
            String expression = inputField.getText();
            if (validateExpression(expression)) {
                try {

                    // evaluating the expression
                    int result = evaluateExpression(expression);

                    // setting the returned result to the text field
                    inputField.setText(result + "");
                } catch (Exception e) {
                    // exception may occur in case of divide by zero
                    // thus handling divide by zero exception here
                    inputField.setText("Math Error");
                }
            }
        });

        // DEL button
        buttons[17].addActionListener(action -> {
            // delete button removes the recently pressed key from input
            String expression = inputField.getText();
            if (expression.length() > 0) {
                expression = expression.substring(0, expression.length() - 1);
            }
            inputField.setText(expression);
        });

        // if user clicks on theme menu item
        themesMenuItem.addActionListener(action -> {

            // displaying a color chooser to change the theme for application
            Color themeColor = JColorChooser.showDialog(
                    null,
                    "Choose Theme Color",
                    new Color(0xdff5e6));

            // setting the choosed color by user as the current theme
            this.getContentPane().setBackground(themeColor);
            menuBar.setBackground(themeColor);
            numberPanel.setBackground(themeColor);
            operatorPanel.setBackground(themeColor);

            // buttons background color is not same as completely the theme color thus tweaking it a little bit
            // to give a better effect.
            // taking different RGB values of theme color and tweaking them a little bit by adding 10
            // also normalizing the values because it may be possible that if color value is 253 and +10 would
            // make it out of range.
            try {
                int buttonRedValue = normalizeColorValueRange(themeColor.getRed() + 10);
                int buttonGreenValue = normalizeColorValueRange(themeColor.getGreen() + 10);
                int buttonBlueValue = normalizeColorValueRange(themeColor.getBlue() + 10);

                // setting theme color for buttons
                Color buttonColor = new Color(buttonRedValue, buttonGreenValue, buttonBlueValue);
                setButtonBackgroud(buttonColor);
            } catch (Exception e) {
                System.out.println("Exception:" + e);
            }
        });

        // getting all the available fonts on the system from the graphics environment
        String[] fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        // creating a combobox of font styles
        JComboBox fontStyleBox = new JComboBox(fontStyles);

        // if user clicks on font menu item then...
        fontsMenuItem.addActionListener(action -> {

            fontStyleBox.setSelectedItem("Mv Boli");
            fontStyleBox.setPreferredSize(new Dimension(400, 30));

            // creating another frame for picking up font style
            JFrame fontFrame = new JFrame("Choose Font");
            fontFrame.add(fontStyleBox);

            // setting the frame location relative to the parent JFrame location that is the calulator frame
            fontFrame.setLocationRelativeTo(this);
            fontFrame.setVisible(true);

            // using pack() just to ensure that frame will take only that much space which is required by the component
            // within the frame.
            fontFrame.pack();

        });

        // if user picks up a font from the font style frame then
        fontStyleBox.addActionListener(action -> {
            // setting the newly picked font as the current application font.
            inputField.setFont(new Font((String) fontStyleBox.getSelectedItem(), Font.PLAIN, 45));
            setButtonFont(new Font((String) fontStyleBox.getSelectedItem(), Font.PLAIN, 35));
        });

        // if user clicks on help menu item then show a message dialog.
        helpMenuItem.addActionListener(action -> JOptionPane.showMessageDialog(
                null,
                "Do you really need help for operating such a basic calculator ;D",
                "Help",
                JOptionPane.INFORMATION_MESSAGE
        ));

        // if user click about menu item then show a Message dialog.
        aboutMenuItem.addActionListener(action -> JOptionPane.showMessageDialog(
                null,
                "Calculator Application Version 0.1",
                "About",
                JOptionPane.INFORMATION_MESSAGE
        ));

        // closes the application on Exit click
        exitMenuItem.addActionListener(action -> {
            this.dispose();
            System.exit(0);
        });

        // adding buttons to number panel
        for (int i = 0; i <= 11; i++) {
            numberPanel.add(buttons[i]);
        }

        // adding buttons to operator panel
        for (int i = 12; i < buttons.length; i++) {
            operatorPanel.add(buttons[i]);
        }

        // setting MenuBar
        this.setJMenuBar(menuBar);

        // adding other components to frame
        this.add(inputField);
        this.add(numberPanel);
        this.add(operatorPanel);

        // setting application frame to be visible
        this.setVisible(true);
    }

    // helper function for normalizing color value
    private int normalizeColorValueRange(int colorValue) {
        if (colorValue > 255) {
            colorValue = 254;
        }
        return colorValue;
    }

    // helper function to set backgrond color for all buttons of array
    private void setButtonBackgroud(Color color) {
        for (JButton button : this.buttons) {
            button.setBackground(color);
        }
    }

    // helper function to set font for all buttons of array
    private void setButtonFont(Font font) {
        for (JButton button : this.buttons) {
            button.setFont(font);
        }
    }

    // helper function to set focusable nature of all buttons of array
    private void setButtonFocusable(boolean value) {
        for (JButton button : this.buttons) {
            button.setFocusable(value);
        }
    }

    // helper function to set border of all buttons of array
    private void setButtonBorder(Color borderColor, Color shadowColor) {
        for (JButton button : this.buttons) {
            button.setBorder(BorderFactory.createEtchedBorder(borderColor, shadowColor));
        }
    }

    // helper function for expression evaluation and validation
    private boolean isAnOperator(char c) {
        return (c == '*' || c == '/' || c == '+' || c == '-' || c == '%');
    }

    // helper function for expression evaluation and validation
    private boolean isANumber(char c) {
        return (c >= '0' && c <= '9');
    }

    // function for expression validation
    private boolean validateExpression(String expression) {
        if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length() - 1))) {
            return false;
        }

        int openParenthCount = 0;
        boolean lastWasOp = false;
        boolean lastWasOpen = false;

        for (char c : expression.toCharArray()) {
            if (c == ' ') continue;
            if (c == '(') {
                openParenthCount++;
                lastWasOpen = true;
                continue;
            } else if (c == ')') {
                if (openParenthCount <= 0 || lastWasOp) {
                    return false;
                }
                openParenthCount--;
            } else if (isAnOperator(c)) {
                if (lastWasOp || lastWasOpen) return false;
                lastWasOp = true;
                continue;
            } else if (!isANumber(c)) {
                return false;
            }
            lastWasOp = false;
            lastWasOpen = false;
        }
        if (openParenthCount != 0) return false;
        return !lastWasOp && !lastWasOpen;
    }

    // function for expression evaluation
    // final result will always be integer, double values will be type casted to integer
    // maninly focused on GUI part therefore ignored most of the logical aspects
    private int evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<>();

        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' &&
                    tokens[i] <= '9') {
                StringBuilder sbuf = new
                        StringBuilder();

                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.
                        toString()));
                i--;
            } else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOperator(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                while (!ops.empty() &&
                        hasPrecedence(tokens[i],
                                ops.peek()))
                    values.push(applyOperator(ops.pop(),
                            values.pop(),
                            values.pop()));

                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
            values.push(applyOperator(ops.pop(),
                    values.pop(),
                    values.pop()));

        return values.pop();
    }

    // helper function to get precedence of operators
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') ||
                (op2 != '+' && op2 != '-');
    }

    // helper function for expression evaluation. To apply a operator to two operands
    private int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}

public class Application {
    public static void main(String[] args) {
        // creating a new instance of calculator application.
        new Calculator();
    }
}