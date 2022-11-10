import java.util.Stack;

class calsWorking {
    private Stack<Character> symbols;
    private Stack<Double> operands;
    public static double totalCalculation;
    calsWorking(){
        System.out.println("object created");
    }

    public calsWorking(String expression){
        symbols = new Stack<Character>();
        operands=new Stack<Double>();
        double sum=0;
        int i,j;
        char charCurVal;
        int expressionLength=expression.length();
        for ( i=0;i<expression.length();i++) {
            charCurVal=expression.charAt(i);

            if(Character.isDigit(charCurVal)){
                for( j=i;j<expressionLength && Character.isDigit(expression.charAt(j));j++){
                    if(j>0){
                        sum=sum*10.0;
                    }
                    System.out.println("converting:"+Double.parseDouble(String.valueOf(expression.charAt(j))));
                    sum=sum+Double.parseDouble(String.valueOf(expression.charAt(j)));
                    System.out.println(sum);
                }
                operands.push(sum);
                System.out.println("total sum "+sum);
                sum=0;
                i=j;
            }
            if(i>=expressionLength) {  break;  }

            charCurVal=expression.charAt(i);
            System.out.println(charCurVal);
            if(isOperator(charCurVal) && symbols.empty()){
                symbols.push(charCurVal);
            } else
                if (isOperator(charCurVal) && checkPrecedence(symbols.peek())<checkPrecedence(charCurVal)) {
                symbols.push(charCurVal);
            }
            else
                if(isOperator(charCurVal) && checkPrecedence(symbols.peek())>=checkPrecedence(charCurVal)){
                double number=performTask(operands,symbols);
                operands.push(number);
                symbols.push(charCurVal);
            }
        }
        int m=1;
        while (!symbols.empty()){

            double output=performTask(operands,symbols);
            operands.push(output);
            System.out.println(m+" : "+operands.peek());
        }
        System.out.println(operands);
        System.out.println(symbols);
        totalCalculation= operands.peek();
    }
    private static boolean isOperator(char symbol){
        if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/'||symbol=='%')
        return true;
        else
            return false;
    }
    private static int checkPrecedence(char Symbol){
        switch(Symbol){
            case '%':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    private static double performTask(Stack operands,Stack symbols){
        double num1= (double) operands.pop();
        double num2=(double) operands.pop();
        char operator= (char) symbols.pop();

        switch (operator){
            case '%':
                return num2%num1;
            case '/':
                return num2/num1;
            case '*':
                return num2*num1;
            case '+':
                return num2+num1;
            case '-':
                return num2-num1;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        calsWorking obj=new calsWorking();
        calsWorking obj2=new calsWorking("50*50%100/10-100*30");
    }
}
