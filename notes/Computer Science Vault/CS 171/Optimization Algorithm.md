What changes the model
Ways to find the best value for `w` and `b` (weight and bias)
- `w` must be adjusted to find the minimum **Loss** ([[Objective Function#Loss Functions]])
## Motivation
Need a way for the model to know when to **move left** or **move right**; the function is unknown (function of `w` and `Loss`)
- Can use the slope (derivative)
## Optimization
Tweak the model parameters (weights `w`) until the [[Objective Function#Loss & Reward|Loss]] is very low
- Will tweak based on the derivative?
	- Move right if the derivative is negative, left if positive
	- Currently, only works for functions without local mins
- For derivatives of 0 (no slope):
	- Use second derivative to find the curvature of the slope
- For multiple weights, you use the partial derivative
### Gradient Decent
1. Find the derivative
2. Pick a random point `x_0`
4. Update point `x_(i+1)` based on the derivative of `x_i` and the value of `x_i`
	1. Using the derivative may give a large value, so you'd use only a **percentage** (**Oscillation**) of its value
		1. Hard to find a good value :(
#### Equation

#### Oscillation
The percentage multiplier for the derivative difference.
#### When to Stop?
