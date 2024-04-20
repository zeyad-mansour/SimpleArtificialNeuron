import components.neuron.SimpleArtificialNeuron;
import components.neuron.SimpleArtificialNeuron1;

/**
 * Demonstrates a specific use case of the {@code SimpleArtificialNeuron}
 * component by implementing an AND gate using a single neuron. This demo
 * showcases how to set weights and bias to achieve the desired logic of an AND
 * gate and evaluates the neuron's output for various input combinations. The
 * output is interpreted based on a threshold to simulate a binary output.
 *
 * @author Zeyad Mansour
 */
public class SimpleArtificialNeuronDemo2 {

    /**
     * Main method for running the AND gate demonstration.
     *
     * @param args
     *            Command-line arguments (not used in this demo)
     */
    public static void main(String[] args) {
        // Create a SimpleArtificialNeuron with 2 inputs
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(2);

        // Adjusted weights and bias for AND gate with sigmoid activation
        double[] weights = { 1.0, 1.0 };
        neuron.setWeights(weights);
        neuron.setBias(-1.5);

        // Test cases for AND gate
        double[][] inputs = { { 0.0, 0.0 }, { 0.0, 1.0 }, { 1.0, 0.0 },
                { 1.0, 1.0 } };

        // Output threshold for interpreting the sigmoid output
        double threshold = 0.5;

        // Evaluate the neuron's output for each input case
        for (int i = 0; i < inputs.length; i++) {
            neuron.activate(inputs[i]);
            double output = neuron.applyActivationFunction();
            int binaryOutput = output >= threshold ? 1 : 0; // Interpret output as binary
            System.out.println("Input: [" + inputs[i][0] + ", " + inputs[i][1]
                    + "], " + "Output: " + binaryOutput);
        }
    }
}