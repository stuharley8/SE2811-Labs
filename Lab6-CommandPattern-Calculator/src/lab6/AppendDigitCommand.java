/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public class AppendDigitCommand extends CalculatorCommand {

    private char ch;
    private String display;
    private boolean newNumber;

    public AppendDigitCommand(Calculator c, char ch) {
        super(c);
        this.ch = ch;
    }

    public void execute() {
        display = calculator.getDisplay();
        newNumber = calculator.getNewNumber();
        calculator.appendDigit(ch);
    }

    public void unexecute() {
        calculator.setDisplay(display);
        calculator.setReadyForNewNumber(newNumber);
    }
}
