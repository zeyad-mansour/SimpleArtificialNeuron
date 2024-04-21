
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import components.neuron.SimpleArtificialNeuron;
import components.neuron.SimpleArtificialNeuron1;

public class SimpleArtificialNeuronSecondaryTest {

    private static final int NUM_INPUTS = 3;
    private static final double DELTA = 0.0001;

    /*
     * Tests for updateWeights
     */
    @Test
    public void testUpdateWeights() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        double learningRate = 0.1;
        double error = 0.5;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs); // Calculate weighted sum
        neuron.updateWeights(learningRate, error, inputs);

        // First element: 0.2 + (0.1 * 0.5 * 1.0) = 0.25
        // Second element: 0.4 + (0.1 * 0.5 * 2.0) = 0.5
        // Third element: 0.6 + (0.1 * 0.5 * 3.0) = 0.75
        double[] expectedWeights = { 0.25, 0.5, 0.75 }; // Updated weights
        assertArrayEquals(expectedWeights, neuron.getWeights(), DELTA);
    }

    @Test
    public void testUpdateWeightsWithZeroLearningRate() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] initialWeights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(initialWeights);

        double learningRate = 0.0;
        double error = 0.5;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.updateWeights(learningRate, error, inputs);

        assertArrayEquals(initialWeights, neuron.getWeights(), DELTA); // Weights should remain unchanged
    }

    @Test
    public void testUpdateWeightsWithZeroError() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] initialWeights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(initialWeights);

        double learningRate = 0.1;
        double error = 0.0;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.updateWeights(learningRate, error, inputs);

        assertArrayEquals(initialWeights, neuron.getWeights(), DELTA); // Weights should remain unchanged
    }

    /*
     * Tests for toString
     */
    @Test
    public void testToString() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        neuron.setWeights(weights);
        neuron.setBias(bias);

        String expectedString = "SimpleArtificialNeuron: {weights: [0.2, 0.4, 0.6], bias: 0.8}";
        assertEquals(expectedString, neuron.toString());
    }

    @Test
    public void testToStringZeroInputs() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(0);

        String expectedString = "SimpleArtificialNeuron: {weights: [], bias: 0.0}";
        assertEquals(expectedString, neuron.toString());
    }

    @Test
    public void testToStringAfterClear() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.clear();

        String expectedString = "SimpleArtificialNeuron: {weights: [0.0, 0.0, 0.0], bias: 0.0}";
        assertEquals(expectedString, neuron.toString());
    }

    /*
     * Tests for equals
     */
    @Test
    public void testEquals() {
        SimpleArtificialNeuron1 neuron1 = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        SimpleArtificialNeuron neuron2 = new SimpleArtificialNeuron1(
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

    @Test
    public void testEqualsWithDifferentNumberOfInputs() {
        SimpleArtificialNeuron neuron1 = new SimpleArtificialNeuron1(2); // 2 inputs
        SimpleArtificialNeuron neuron2 = new SimpleArtificialNeuron1(3); // 3 inputs

        assertNotEquals(neuron1, neuron2);
    }
}
