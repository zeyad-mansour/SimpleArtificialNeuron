package components.neuron;

/**
 * Representation: - An array of doubles (`weights`) stores the weights for each
 * input. - A separate double (`bias`) stores the neuron's bias. - A double
 * (`weightedSum`) stores the calculated weighted sum of inputs and bias.
 *
 * Convention: - The length of the `weights` array corresponds to the number of
 * inputs. - `weights[i]` represents the weight for the i-th input.
 *
 * Correspondence: - A `SimpleArtificialNeuron` object with `n` inputs is
 * represented by an array of `n` doubles and two double values for bias and
 * weighted sum.
 */
public class SimpleArtificialNeuron1 extends SimpleArtificialNeuronSecondary {
    private double[] weights;
    private double bias;
    private double weightedSum; // To store the result of weighted sum and bias

    /**
     * Constructor for SimpleArtificialNeuron1.
     *
     * @param numInputs
     *            The number of inputs for the neuron.
     */
    public SimpleArtificialNeuron1(int numInputs) {
        this.weights = new double[numInputs];
        this.bias = 0.0;
        this.weightedSum = 0.0;
    }

    @Override
    public void setWeights(double[] weights) {
        assert weights.length == this
                .numberOfInputs() : "Weights array length must match number of inputs";
        // Create a copy of the provided array to maintain representation independence
        for (int i = 0; i < weights.length; i++) {
            this.weights[i] = weights[i];
        }
    }

    @Override
    public void setBias(double bias) {
        this.bias = bias;
    }

    @Override
    public void activate(double[] inputs) {
        assert inputs.length == this
                .numberOfInputs() : "Inputs array length must match number of inputs";
        this.weightedSum = 0.0;
        for (int i = 0; i < inputs.length; i++) {
            this.weightedSum += inputs[i] * this.weights[i];
        }
        this.weightedSum += this.bias;
    }

    @Override
    public double applyActivationFunction() {
        // Sigmoid activation function, but this can be changed
        return 1.0 / (1.0 + Math.exp(-this.weightedSum));
    }

    @Override
    public int numberOfInputs() {
        return this.weights.length;
    }

    @Override
    public double[] getWeights() {
        // Create a copy of the weights array to avoid exposing the internal representation
        double[] copy = new double[this.weights.length];
        System.arraycopy(this.weights, 0, copy, 0, this.weights.length);
        return copy;
    }

    @Override
    public double getWeightedSum() {
        return this.weightedSum;
    }

    @Override
    public double getBias() {
        return this.bias;
    }

    @Override
    public SimpleArtificialNeuron newInstance() {
        SimpleArtificialNeuron newNeuron = new SimpleArtificialNeuron1(
                this.numberOfInputs());
        newNeuron.transferFrom(this);
        return newNeuron;
    }

    @Override
    public void transferFrom(SimpleArtificialNeuron source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof SimpleArtificialNeuron1 : ""
                + "Violation of: source is of dynamic type SimpleArtificialNeuron1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type
         * SimpleArtificialNeuron1.
         */
        SimpleArtificialNeuron1 localSource = (SimpleArtificialNeuron1) source;
        this.weights = localSource.getWeights(); // Ensure a copy is made
        this.bias = localSource.getBias();
        this.weightedSum = localSource.weightedSum;
    }

    @Override
    public void clear() {
        // Reset weights and bias to their initial values (e.g., 0.0)
        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] = 0.0;
        }
        this.bias = 0.0;
        this.weightedSum = 0.0;
    }
}