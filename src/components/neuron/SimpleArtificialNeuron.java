package components.neuron;

/**
 * Models a basic artificial neuron, a fundamental component in artificial
 * neural networks.
 *
 * @author Zeyad Mansour
 */
public interface SimpleArtificialNeuron extends SimpleArtificialNeuronKernel {

    /**
     * Updates the weights of the neuron using the provided learning rate and
     * error signal.
     *
     * @param learningRate
     *            The learning rate to apply.
     * @param error
     *            The error signal to use for weight adjustment.
     * @param inputs
     *            The input values used for the last activation.
     * @requires inputs.length == this.numberOfInputs()
     * @ensures this.weights are updated according to the learning rule.
     */
    void updateWeights(double learningRate, double error, double[] inputs);
}
