
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.neuron.SimpleArtificialNeuron;
import components.neuron.SimpleArtificialNeuron1;

public class SimpleArtificialNeuron1Test {

    private static final int NUM_INPUTS = 3;
    private static final double DELTA = 0.0001;

    @Test
    public void testActivate() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs);

        double expectedWeightedSum = 3.6; // (1*0.2) + (2*0.4) + (3*0.6) + 0.8 = 3.6

        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);
    }

    @Test
    public void testActivateWithZeroWeightsAndBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.0, 0.0, 0.0 };
        double bias = 0.0;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs);

        double expectedWeightedSum = 0.0;
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);
    }

    @Test
    public void testActivateWithNegativeWeightsAndBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { -0.1, -0.2, -0.3 };
        double bias = -0.5;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs);

        double expectedWeightedSum = -1.9; // (1*-0.1) + (2*-0.2) + (3*-0.3) + -0.5 = -1.9
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);
    }

    @Test
    public void testSetWeights() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.5, 0.6, 0.7 };
        neuron.setWeights(weights);

        assertArrayEquals(weights, neuron.getWeights(), DELTA);
    }

    @Test
    public void testSetWeightsWithEmptyArray() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(0); // 0 inputs
        double[] weights = {};
        neuron.setWeights(weights);

        assertArrayEquals(weights, neuron.getWeights(), DELTA);
    }

    @Test
    public void testSetBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double bias = 0.8;
        neuron.setBias(bias);

        assertEquals(bias, neuron.getBias(), DELTA);
    }

    @Test
    public void testApplyActivationFunction() {
        int numInputs = 3;
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(numInputs);

        // Set weights and bias (example values, adjust as needed)
        double[] weights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(weights);
        neuron.setBias(0.8);

        // Provide input values (ensure length matches numInputs)
        double[] inputs = { 1.0, 2.0, 3.0 };
        neuron.activate(inputs);

        // Calculate expected weighted sum (based on example values)
        double expectedWeightedSum = 3.6; // (1*0.2) + (2*0.4) + (3*0.6) + 0.8
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), 0.0001);

        double output = neuron.applyActivationFunction();

        // Verify output based on the activation function used
        // (Assuming sigmoid activation)
        double expectedOutput = 1.0 / (1.0 + Math.exp(-expectedWeightedSum));
        assertEquals(expectedOutput, output, 0.001);
    }

    @Test
    public void testApplyActivationFunctionWithDifferentWeightedSums() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);

        // Test with a positive weighted sum
        neuron.activate(new double[] { 1.0, 2.0, 3.0 });
        double output1 = neuron.applyActivationFunction();
        // Assert output is between 0 and 1 (assuming sigmoid)

        // Test with a negative weighted sum
        neuron.activate(new double[] { -1.0, -2.0, -3.0 });
        double output2 = neuron.applyActivationFunction();
        // Assert output is between 0 and 1 (assuming sigmoid)

        // Test with a weighted sum of 0
        neuron.activate(new double[] { 0.0, 0.0, 0.0 });
        double output3 = neuron.applyActivationFunction();
        assertEquals(0.5, output3, DELTA); // Sigmoid output for 0 input
    }

    @Test
    public void testNumberOfInputs() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        assertEquals(NUM_INPUTS, neuron.numberOfInputs());
    }

    @Test
    public void testNumberOfInputsEmpty() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(0);
        assertEquals(0, neuron.numberOfInputs());
    }
}