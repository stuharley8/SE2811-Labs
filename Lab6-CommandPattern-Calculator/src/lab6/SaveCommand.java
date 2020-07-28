/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public class SaveCommand extends CalculatorCommand {

    private String memory;
    private String accumulator;

    public SaveCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        memory = calculator.getMemory();
        accumulator = calculator.getAccumulator();
        calculator.saveToMemory();
    }

    public void unexecute() {
        calculator.setMemory(memory);
        calculator.setAccumulator(accumulator);
        calculator.setReadyForNewNumber(true);
    }
}
