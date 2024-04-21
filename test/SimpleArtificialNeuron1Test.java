
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.neuron.SimpleArtificialNeuron;
import components.neuron.SimpleArtificialNeuron1;

public class SimpleArtificialNeuron1Test {

    private static final int NUM_INPUTS = 3;
    private static final double DELTA = 0.0001;

    /*
     * Tests for setWeights
     */
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

    @Test(expected = AssertionError.class)
    public void testSetWeightsInvalidLength() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.1, 0.2 }; // Array with wrong length
        neuron.setWeights(weights);
    }

    /*
     * Tests for setBias
     */
    @Test
    public void testSetBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double bias = 0.8;
        neuron.setBias(bias);

        assertEquals(bias, neuron.getBias(), DELTA);
    }

    @Test
    public void testSetBiasZero() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double bias = 0;
        neuron.setBias(bias);

        assertEquals(bias, neuron.getBias(), DELTA);
    }

    /*
     * Tests for activate
     */
    @Test
    public void testActivate() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);

        neuron.activate(inputs);

        double expectedWeightedSum = 3.6;
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);

        // Verify that only the weighted sum changed
        assertArrayEquals(weights, neuron.getWeights(), DELTA);
        assertEquals(bias, neuron.getBias(), DELTA);
    }

    @Test
    public void testActivateWithZeroWeightsAndBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.0, 0.0, 0.0 };
        double bias = 0.0;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);

        // Store initial state
        double[] initialWeights = neuron.getWeights();
        double initialBias = neuron.getBias();

        neuron.activate(inputs);

        double expectedWeightedSum = 0.0;
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);

        // Verify that only the weighted sum changed
        assertArrayEquals(initialWeights, neuron.getWeights(), DELTA);
        assertEquals(initialBias, neuron.getBias(), DELTA);
    }

    @Test
    public void testActivateWithNegativeWeightsAndBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { -0.1, -0.2, -0.3 };
        double bias = -0.5;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);

        // Store initial state
        double[] initialWeights = neuron.getWeights();
        double initialBias = neuron.getBias();

        neuron.activate(inputs);

        double expectedWeightedSum = -1.9; // (1*-0.1) + (2*-0.2) + (3*-0.3) + -0.5 = -1.9
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);

        // Verify that only the weighted sum changed
        assertArrayEquals(initialWeights, neuron.getWeights(), DELTA);
        assertEquals(initialBias, neuron.getBias(), DELTA);
    }

    /*
     * Tests for applyActivationFunction
     */
    @Test
    public void testApplyActivationFunction() {
        int numInputs = 3;
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(numInputs);

        // Set weights and bias
        double[] weights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(weights);
        neuron.setBias(0.8);

        double[] inputs = { 1.0, 2.0, 3.0 };
        neuron.activate(inputs);

        // Calculate expected weighted sum
        double expectedWeightedSum = 3.6; // (1 * 0.2) + (2 * 0.4) + (3 * 0.6) + 0.8
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);

        double output = neuron.applyActivationFunction();

        // Verify output based on the activation function used
        // (This test assumes sigmoid activation)
        double expectedOutput = 1.0 / (1.0 + Math.exp(-expectedWeightedSum));
        assertEquals(expectedOutput, output, DELTA);
    }

    @Test
    public void testApplyActivationFunctionWithDifferentWeightedSums() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);

        // Test with a positive weighted sum
        neuron.activate(new double[] { 1.0, 2.0, 3.0 });
        double output1 = neuron.applyActivationFunction();

        // Assert output is between 0 and 1 (sigmoid)
        assertTrue(output1 > 0.0 && output1 < 1.0);

        // Test with a negative weighted sum
        neuron.activate(new double[] { -1.0, -2.0, -3.0 });
        double output2 = neuron.applyActivationFunction();

        // Assert output is between 0 and 1 (sigmoid)
        assertTrue(output2 > 0.0 && output2 < 1.0);

        // Test with a weighted sum of 0
        neuron.activate(new double[] { 0.0, 0.0, 0.0 });
        double output3 = neuron.applyActivationFunction();
        assertEquals(0.5, output3, DELTA); // Sigmoid output for 0 input
    }

    /*
     * Tests for numberOfInputs
     */
    @Test
    public void testNumberOfInputs() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        assertEquals(NUM_INPUTS, neuron.numberOfInputs());
    }

    @Test
    public void testNumberOfInputsEmpty() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(0);
        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(0);
        neuronCopy.numberOfInputs();

        assertEquals(0, neuron.numberOfInputs());
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    /*
     * Tests for getWeights
     */
    @Test
    public void testGetWeights() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(weights);

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setWeights(weights);

        double[] returnedWeights = neuron.getWeights();
        assertArrayEquals(weights, returnedWeights, DELTA);
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    @Test
    public void testGetWeightsAfterClear() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        neuron.setWeights(weights);
        neuron.clear();

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setWeights(weights);
        neuronCopy.clear();

        double[] returnedWeights = neuron.getWeights();
        double[] expectedWeights = { 0.0, 0.0, 0.0 };
        assertArrayEquals(expectedWeights, returnedWeights, DELTA);
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    /*
     * Tests for getWeightedSum
     */
    @Test
    public void testGetWeightedSum() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs);

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setWeights(weights);
        neuronCopy.setBias(bias);
        neuronCopy.activate(inputs);

        double expectedWeightedSum = 3.6;
        assertEquals(expectedWeightedSum, neuron.getWeightedSum(), DELTA);
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    @Test
    public void testGetWeightedSumAfterClear() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        double[] inputs = { 1.0, 2.0, 3.0 };

        neuron.setWeights(weights);
        neuron.setBias(bias);
        neuron.activate(inputs);
        neuron.clear();

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setWeights(weights);
        neuronCopy.setBias(bias);
        neuronCopy.activate(inputs);
        neuronCopy.clear();

        assertEquals(0, neuron.getWeightedSum(), DELTA);
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    /*
     * Tests for getBias
     */
    @Test
    public void testGetBias() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double bias = 0.8;
        neuron.setBias(bias);

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setBias(bias);

        assertEquals(bias, neuron.getBias(), DELTA);
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    @Test
    public void testGetBiasAfterClear() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double bias = 0.8;
        neuron.setBias(bias);
        neuron.clear();

        SimpleArtificialNeuron neuronCopy = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        neuronCopy.setBias(bias);
        neuronCopy.clear();

        assertEquals(0, neuron.getBias(), DELTA); // Should be reset to 0 after clear
        assertEquals(neuronCopy, neuron); // Verify neuron was properly restored
    }

    /*
     * Tests for other methods inherited from Object
     */
    @Test
    public void testNewInstanceAndTransferFrom() {
        SimpleArtificialNeuron neuron1 = new SimpleArtificialNeuron1(
                NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        neuron1.setWeights(weights);
        neuron1.setBias(bias);

        SimpleArtificialNeuron neuron2 = neuron1.newInstance();
        neuron2.transferFrom(neuron1);

        assertEquals(neuron1, neuron2); // Check if the state was transferred correctly
    }

    @Test
    public void testClear() {
        SimpleArtificialNeuron neuron = new SimpleArtificialNeuron1(NUM_INPUTS);
        double[] weights = { 0.2, 0.4, 0.6 };
        double bias = 0.8;
        neuron.setWeights(weights);
        neuron.setBias(bias);

        neuron.clear();

        // Check if weights and bias are reset
        assertArrayEquals(new double[NUM_INPUTS], neuron.getWeights(), DELTA);
        assertEquals(0.0, neuron.getBias(), DELTA);
    }
}