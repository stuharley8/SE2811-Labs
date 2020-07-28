/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public class EnterCommand extends CalculatorCommand {

    private String accumulator;

    public EnterCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        accumulator = calculator.getAccumulator();
        calculator.enter();
    }

    public void unexecute() {
        calculator.setAccumulator(accumulator);
        calculator.setReadyForNewNumber(true);
    }
}
