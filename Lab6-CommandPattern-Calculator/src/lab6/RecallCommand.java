/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public class RecallCommand extends CalculatorCommand {

    private String display;

    public RecallCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        display = calculator.getDisplay();
        calculator.recallFromMemory();
    }

    public void unexecute() {
        calculator.setDisplay(display);
        calculator.setReadyForNewNumber(true);
    }
}
