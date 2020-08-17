public class Calculator implements java.io.Serializable {

    private double operandOne;
    private double operandTwo;
    private double result;
    private String operation;

    public Calculator(){
    }

    public Calculator(double operandOne, double operandTwo){
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
    }

    public void setOperandOne(double operandOne){
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo){
        this.operandTwo = operandTwo;
    }

    public void setOperation(String operation){
        this.operation = operation;
    }

    public void performOperation(){
        if (operation.equals("+")){
             result = operandOne + operandTwo;
        } else if (operation.equals("-")){
             result = operandOne - operandTwo;
        }
    }
    public void getResults(){
        System.out.println(String.format("The result is: " + this.result));
    }
}