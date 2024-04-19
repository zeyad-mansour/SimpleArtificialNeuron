
/**
 * Abstract class implementing {@code SimpleArtificialNeuron} by extending
 * {@code SimpleArtificialNeuronKernel}.
 *
 * @author Zeyad Mansour
 */
public abstract class SimpleArtificialNeuronSecondary
        implements SimpleArtificialNeuron {
    @Override
    public void updateWeights(double learningRate, double error,
            double[] inputs) {
        assert inputs.length == this
                .numberOfInputs() : "Inputs array length must match number of inputs";

        // Calculate the weight adjustments based on the learning rate, error, and inputs.
        double[] adjustments = new double[this.numberOfInputs()];
        for (int i = 0; i < adjustments.length; i++) {
            adjustments[i] = learningRate * error * inputs[i];
        }

        // Update the weights by adding the adjustments.
        double[] weights = this.getWeights();
        for (int i = 0; i < weights.length; i++) {
            weights[i] += adjustments[i];
        }
        this.setWeights(weights);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleArtificialNeuron: {");
        sb.append("weights: [");
        for (int i = 0; i < this.numberOfInputs(); i++) {
            sb.append(this.getWeights()[i]);
            if (i < this.numberOfInputs() - 1) {
                sb.append(", ");
            }
        }
        sb.append("], bias: ");
        sb.append(this.getBias());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleArtificialNeuron)) {
            return false;
        }
        SimpleArtificialNeuron other = (SimpleArtificialNeuron) obj;

        // Check if the number of inputs is the same.
        if (this.numberOfInputs() != other.numberOfInputs()) {
            return false;
        }

        // Check if the weights and bias are equal.
        for (int i = 0; i < this.numberOfInputs(); i++) {
            if (this.getWeights()[i] != other.getWeights()[i]) {
                return false;
            }
        }
        return this.getBias() == other.getBias();
    }
}