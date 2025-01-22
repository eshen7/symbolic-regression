# Symbolic Regression Engine

The Symbolic Regression Engine uses genetic algorithms to discover mathematical equations to fit given data. It models equations as a tree-based structure like so:

![image](https://github.com/user-attachments/assets/bf884d2d-55bc-402c-b105-48e2fbfa7cc7)

The engine creates a population of individuals with "genes" that each encode an equation. The population undergoes a series of generations where they experience crossover, mutation, and fitness (natural selection) in order to simulate evolution. When two individuals cross over, they produce two offspring that have the same genes as their parents but with one node switched. Mutation either swaps an operator or generates a mini tree to replace a node. Fitness is evaluated as a combination of least-squares regression and a measure of complexity based on the number of nodes in the tree.

For example, when provided with the data (1, 1), (2, 4), (3, 9), (4, 16), (5, 25), the engine eventually outputs this:

<img width="226" alt="Screenshot 2025-01-21 at 11 27 48 PM" src="https://github.com/user-attachments/assets/83a3cd5f-37d3-4869-a3a5-9cd8a5477260" />

Similarly, with (1, 1), (2, 8), (3, 27), (4, 64), (5, 125), we get this:

<img width="182" alt="Screenshot 2025-01-21 at 11 29 05 PM" src="https://github.com/user-attachments/assets/7c3b87f5-8083-4ccf-bf33-d3e6a32ec6e3" />

The Symbolic Regression Engine is designed in a way that it can operate on different representations for genes. For example, we can model a gene as a string of 1's and 0's. Through abstraction, the representation can be changed with virtually no code changes. The type of data can be changed as well, which can be used to incorporate more variables.
