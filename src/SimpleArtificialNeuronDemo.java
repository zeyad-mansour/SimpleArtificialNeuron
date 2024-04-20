import components.neuron.SimpleArtificialNeuron;
import components.neuron.SimpleArtificialNeuron1;

public class SimpleArtificialNeuronDemo {
    public static void main(String[] args) {
        // Create a SimpleArtificialNeuron with 3 inputs
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(3);

        // Set weights and bias
        double[] weights = { 0.1, 0.2, 0.3 };
        neuron.setWeights(weights);
        neuron.setBias(0.5);

        // Provide input values
        double[] inputs = { 1.0, 2.0, 3.0 };

        // Activate the neuron
        neuron.activate(inputs);

        // Apply the activation function and get the output
        double output = neuron.applyActivationFunction();

        // Print the output
        System.out.println("Neuron output: " + output);

        // Example of weight update
        double learningRate = 0.1;
        double error = 0.5;
        neuron.updateWeights(learningRate, error, inputs);

        System.out.println("Updated neuron: " + neuron);
    }
}
