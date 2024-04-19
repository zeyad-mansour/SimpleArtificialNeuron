
import components.standard.Standard;

/**
 * This interface defines the kernel methods for a basic artificial neuron. It
 * includes methods for setting weights and bias, activating the neuron,
 * applying the activation function, and retrieving the weights and bias.
 *
 * @author Zeyad Mansour
 */
public interface SimpleArtificialNeuronKernel
        extends Standard<SimpleArtificialNeuron> {

    /**
     * Sets the weights of the neuron's inputs.
     *
     * @param weights
     *            An array of doubles representing the new weights. The length
     *            of this array must match the number of inputs specified during
     *            construction.
     * @requires weights.length == this.numberOfInputs()
     * @ensures this.weights = weights
     */
    void setWeights(double[] weights);

    /**
     * Sets the bias of the neuron.
     *
     * @param bias
     *            The new bias value.
     * @ensures this.bias = bias
     */
    void setBias(double bias);

    /**
     * Activates the neuron by calculating the weighted sum of inputs and bias.
     * The result is stored internally for use by the activation function.
     *
     * @param inputs
     *            An array of doubles representing the input values. The length
     *            of this array must match the number of inputs specified during
     *            construction.
     * @requires inputs.length == this.numberOfInputs()
     */
    void activate(double[] inputs);

    /**
     * Applies the activation function to the internally calculated weighted sum
     * and bias.
     *
     * @return The output of the neuron after applying the activation function.
     */
    double applyActivationFunction();

    /**
     * Returns the number of inputs expected by the neuron.
     *
     * @return The number of inputs.
     */
    int numberOfInputs();

    /**
     * Returns the current weights of the neuron.
     *
     * @return A copy of the weights array.
     */
    double[] getWeights();

    /**
     * Returns the current weighted sum of inputs and bias.
     *
     * @return The weighted sum.
     */
    double getWeightedSum();

    /**
     * Returns the current bias of the neuron.
     *
     * @return The bias value.
     */
    double getBias();
}
