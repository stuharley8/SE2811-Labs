/*
 * Course:     SE 2811
 * Term:       Winter 2019-20
 * Assignment: Lab 6: Commanding Calculator
 * Author:     Stuart Harley
 * Date:       2 Feb 2020
 */

package lab6;

public abstract class CalculatorCommand {
    protected Calculator calculator;

    public CalculatorCommand(Calculator c) {
        calculator = c;
    }

    /**
     * Perform operation on calculator.
     */
    public abstract void execute();

    /**
     * Restore calculator to the state before performing this operation.
     */
    public abstract void unexecute();
}
