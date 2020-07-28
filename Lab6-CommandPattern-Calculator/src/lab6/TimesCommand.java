/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public class TimesCommand extends CalculatorCommand {

    private String display;
    private String accumulator;

    public TimesCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        display = calculator.getDisplay();
        accumulator = calculator.getAccumulator();
        calculator.times();
    }

    public void unexecute() {
        calculator.setDisplay(display);
        calculator.setAccumulator(accumulator);
        calculator.setReadyForNewNumber(true);
    }
}
