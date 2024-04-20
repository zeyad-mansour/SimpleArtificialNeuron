# SimpleArtificialNeuron - Source Code

This folder contains the source code for the `SimpleArtificialNeuron` component, which implements a basic artificial neuron, a fundamental building block of artificial neural networks.

## Package Structure

The source code is organized into the `components.neuron` package which contains the core interfaces and classes for the `SimpleArtificialNeuron` component.

## Key Files

*   **SimpleArtificialNeuron.java:**  The main interface that defines the functionality of the neuron, including methods for setting weights and bias, activating the neuron, and applying the activation function.
*   **SimpleArtificialNeuronKernel.java:** The kernel interface that defines the minimal set of methods required for the neuron's basic operations.
*   **SimpleArtificialNeuronSecondary.java:** The abstract class that implements the secondary methods of the neuron, building upon the kernel methods.
*   **SimpleArtificialNeuron1.java:** A concrete implementation of the `SimpleArtificialNeuron` interface, providing a specific representation and implementation details.

## Usage Example

See the `SimpleArtificialNeuronDemo.java` file in this folder for an example of how to use the `SimpleArtificialNeuron` component.

## License

This project is licensed under the [MIT License](../LICENSE).