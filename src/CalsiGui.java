import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalsGui extends Frame implements ActionListener /*implements ActionListener*/ {
    private Frame frame;
    private Button plusButton,MinusButton,multiButton,divButton,perButton,equButton;
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonZero;
    private TextField inputOne;

    /*            Color color;
            color = Color.RED;
            inputOne.setBackground(color);*/
    CalsGui(){
        frame=new Frame("Calculator");

        plusButton =new Button("+");
        MinusButton=new Button("-");
        multiButton=new Button("x");
        divButton  =new Button("/");
        perButton  =new Button("%");
        equButton  =new Button("=");

        buttonOne  =new Button("1");
        buttonTwo  =new Button("2");
        buttonThree=new Button("3");
        buttonFour =new Button("4");
        buttonFive =new Button("5");
        buttonSix  =new Button("6");
        buttonSeven=new Button("7");
        buttonEight=new Button("8");
        buttonNine =new Button("9");
        buttonZero =new Button("0");
        inputOne   =new TextField();

        frame.setSize(400,600);
        inputOne.setBounds(50,100,300,65);        //
        plusButton.setBounds(300,185,40,50);      // +
        MinusButton.setBounds(300,255,40,50);     // -
        multiButton.setBounds(300,325,40,50);     // *
        divButton.setBounds(300,395,40,50);       // /
        perButton.setBounds(205,395,40,50);       // %
        equButton.setBounds(55,395,65,50);        // =

        buttonOne.setBounds(60,185,50,50);        // 1
        buttonTwo.setBounds(130,185,50,50);       // 2
        buttonThree.setBounds(200,185,50,50);     // 3

        buttonFour.setBounds(60,255,50,50);       // 4
        buttonFive.setBounds(130,255,50,50);      // 5
        buttonSix.setBounds(200,255,50,50);       // 6

        buttonSeven.setBounds(60,325,50,50);      // 7
        buttonEight.setBounds(130,325,50,50);     // 8
        buttonNine.setBounds(200,325,50,50);      // 9
        buttonZero.setBounds(130,395,50,50);       // 0

        frame.add(plusButton);
        frame.add(MinusButton);
        frame.add(multiButton);
        frame.add(divButton);
        frame.add(perButton);
        frame.add(equButton);
        frame.add(inputOne);

        frame.add(buttonOne);
        frame.add(buttonTwo);
        frame.add(buttonThree);
        frame.add(buttonFour);
        frame.add(buttonFive);
        frame.add(buttonSix);
        frame.add(buttonSeven);
        frame.add(buttonEight);
        frame.add(buttonNine);
        frame.add(buttonZero);

        plusButton.addActionListener(this);
        equButton.addActionListener(this);

        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonZero.addActionListener(this);

        frame.setLayout(null);
        frame.setVisible(true);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
    static int index;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonOne) {
            inputOne.setText(inputOne.getText() + "1");
        } else if (e.getSource() == buttonTwo) {
            inputOne.setText(inputOne.getText() + "2");
        } else if (e.getSource() == buttonThree) {
            inputOne.setText(inputOne.getText() + "3");
        } else if (e.getSource() == buttonFour) {
            inputOne.setText(inputOne.getText() + "4");
        } else if (e.getSource() == buttonFive) {
            inputOne.setText(inputOne.getText() + "5");
        } else if (e.getSource() == buttonSix) {
            inputOne.setText(inputOne.getText() + "6");
        } else if (e.getSource() == buttonSeven) {
            inputOne.setText(inputOne.getText() + "7");
        } else if (e.getSource() == buttonEight) {
            inputOne.setText(inputOne.getText() + "8");
        } else if (e.getSource() == buttonNine) {
            inputOne.setText(inputOne.getText() + "9");
        } else if (e.getSource() == buttonZero) {
            inputOne.setText(inputOne.getText() + "0");
        } else if (e.getSource() == plusButton) {
            inputOne.setText(inputOne.getText() + "+");
        } else if (e.getSource() == MinusButton) {
            inputOne.setText(inputOne.getText() + "-");
        }
        if (e.getSource() == equButton) {
            String  expression= inputOne.getText();

            System.out.println(expression);
            calsWorking calsWorking=new calsWorking();
            calsWorking obj =new calsWorking(expression);
            double totalNumber= calsWorking.totalCalculation;
            inputOne.setText(String.valueOf(totalNumber));
        }
    }

    public static void main(String[] args) {
        new CalsGui();
    }
}

//the problem is that:
//        the after overwriting the array the second number index is taking
//        the + operator index is taken by previous
//        and also i tried to put the operator array to null but after the
