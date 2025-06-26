Simple model :(
## Understanding Example
1. Imagine points on a graph, where there are Blue Points & Red Points
2. For a **given new point** without Blue or Red, the model should be able to:
	1. **Classify whether that new point is Blue or Red**
3. Model will create a Linear function that separates the Blue and Red Points

1. Imagine points on a graph with it's:
	1. x-axis as the Input
	2. y-axis as the Output
2. For a **given Input (x-value)**, the model should be able to:
	1. **Give the best approximate Output**
3. Model will create a Linear function that has the points close to each other

## Problem
Sometimes is impossible to separate with the given points
**Solution**: Add curves and make the function non-linear and more complicated!

## Classic Linear Model
### Math Representation
`f(x) = xa + b`
- `x` is the input
- `a` is the coefficient of x
- `b`is the intercept
### Machine Learning Representation
`f(x) = xw + b`
- `x` is the input
- `w` is the coefficient (**weight**) of x
- `b`is the **bias**
#### Representation with Multiple Inputs (Single Output)
`f(x) = xw + b`
- `x` is the input **vector** (1-by-n) (Horizontal Vector)
- `w` is the coefficient **vector**  (n-by-1) (Vertical Vector)
- `b`is the intercept **vector** (1-by-1)
- n is how many inputs (features)

Now, you can multiply:
Ex.
- For 2 Inputs:
	- `f(x) = x_1 * w_1 + x_2 * w_2 + b`

#### Representation with Multiple Inputs AND Outputs
`f(x) = xw + b`
- `x` is the input **vector** (1-by-n) (Horizontal Vector)
- `w` is the coefficient **vector**  (n-by-m) (2d matrix)
- `b`is the intercept **vector** (1-by-m)
- n is how many inputs (features)
- m is how many outputs

Now, you can multiply:
Ex.
- For 2 Inputs and outputs:
	- `f(x)_1 = x_1 * w_11 + x_2 * w_21 + b_1`
	- `f(x)_2 = x_1 * w_12 + x_2 * w_22 + b_2`
	- `f(x)_1` & `f(x)_2` would **create different linear lines**
### Weights `w`
