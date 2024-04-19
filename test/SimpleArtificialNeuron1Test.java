
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleArtificialNeuron1Test {

    private static final int NUM_INPUTS = 3;

    @Test
    public void testActivate() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double[] weights = { 0.1, 0.2, 0.3 };
        double bias = 0.5;
        neuron.setWeights(weights);
        neuron.setBias(bias);
        double[] inputs = { 1.0, 2.0, 3.0 };
        neuron.activate(inputs);

        // Assuming you have a getWeightedSum() method
        assertEquals(1.4, neuron.getWeightedSum(), 0.0001);
    }

    @Test
    public void testSetWeights() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double[] weights = { 0.5, 0.6, 0.7 };
        neuron.setWeights(weights);

        // Assuming you have a getWeights() method that returns a copy
        assertArrayEquals(weights, neuron.getWeights(), 0.0001);
    }

    @Test
    public void testSetBias() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double bias = 0.8;
        neuron.setBias(bias);

        // Assuming you have a getBias() method
        assertEquals(bias, neuron.getBias(), 0.0001);
    }

    @Test
    public void testApplyActivationFunction() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double weightedSum = 1.0; // Assuming sigmoid activation

        // Set weightedSum internally (you might need to add a method for this)
        // neuron.setWeightedSum(weightedSum);

        double expectedOutput = 1.0 / (1.0 + Math.exp(-weightedSum));
        assertEquals(expectedOutput, neuron.applyActivationFunction(), 0.0001);
    }

    @Test
    public void testNumberOfInputs() {
        SimpleArtificialNeuron1 neuron = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        assertEquals(NUM_INPUTS, neuron.numberOfInputs());
    }
}