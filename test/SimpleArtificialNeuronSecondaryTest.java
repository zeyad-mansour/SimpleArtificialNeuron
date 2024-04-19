
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SimpleArtificialNeuronSecondaryTest {

    private static final int NUM_INPUTS = 3;

    @Test
    public void testUpdateWeights() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double[] initialWeights = { 0.1, 0.2, 0.3 };
        double bias = 0.5;
        neuron.setWeights(initialWeights);
        neuron.setBias(bias);

        double learningRate = 0.1;
        double error = 0.5;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.updateWeights(learningRate, error, inputs);

        // Assuming you have a getWeights() method in your abstract class
        double[] expectedWeights = { 0.15, 0.25, 0.35 };
        assertArrayEquals(expectedWeights, neuron.getWeights(), 0.0001);
    }

    @Test
    public void testToString() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        neuron.setWeights(weights);
        neuron.setBias(bias);

        String expectedString = "SimpleArtificialNeuron: {weights: [0.2, 0.4, 0.6], bias: 0.8}";
        assertEquals(expectedString, neuron.toString());
    }

    @Test
    public void testEquals() {
        SimpleArtificialNeuron1 neuron1 = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        SimpleArtificialNeuron1 neuron2 = new SimpleArtificialNeuron1(
                NUM_INPUTS);

        double[] weights1 = { 0.1, 0.2, 0.3 };
        double bias1 = 0.4;
        neuron1.setWeights(weights1);
        neuron1.setBias(bias1);

        double[] weights2 = { 0.1, 0.2, 0.3 };
        double bias2 = 0.4;
        neuron2.setWeights(weights2);
        neuron2.setBias(bias2);

        assertEquals(neuron1, neuron2); // Same weights and bias

        // Modify one of the neurons
        neuron2.setBias(0.5);
        assertNotEquals(neuron1, neuron2); // Different bias
    }
}
