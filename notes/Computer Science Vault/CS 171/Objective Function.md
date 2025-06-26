## Loss & Reward
Can be put into two categories:
1. Loss
2. Reward
### Loss Functions
Also know as **Cost**
When the model gets closer, the output gets smaller
Used in **Supervised** Learning (See [[Machine Learning Types]])
Common Loss Functions:
1. **L2-norm Loss**
2. **Cross-Entropy Loss**
#### L2-norm Loss
$\sum_{i} (y_i - t_i)^2$
**Vector Norm (Euclidian Distance)**
- Lower the error, lower the Loss
- Squared to:
	1. Remove negative
	2. Model will change more if the distance is big
**The 2 in L2 represents the exponent**
- L3-norm Loss would be cubed (make sure to remove negative!)
- L2 is most popular due to the problem
**ONLY FOR REGRESSION PROBLEMS**
#### Cross-Entropy Loss
$L(y,t) = -\sum_it_iln(y_i)$
**ONLY FOR CLASSIFICATION PROBLEMS**
##### Example
1. Imagine 3 items that it has to match
	1. Item 1: [1, 0, 0]
	2. Item 2: [0, 1, 0]
	3. Item 3: [0, 0, 1]
	4. Total of the vector values is how confident what that item is
	5. These item values are `t`
2. When checking some item during [[Training]], the Model will would give a vector `y` [a, b, c] where `a + b + c = 1.0`\
	1. If the output is [0.2, 0.4, 0.4] for Item 2, then the model is confused
		1. 20% believes it's Item 1, and 40% believes it's Item 2 and 3
	2. Thus, to calculate the Cross-Entropy:
		1. `-(0 * ln(0.2) + 1 * ln(0.4) + 0 * ln(0.4)) = 0.916`

##### Problem
Decimal values are more lenient due to exponents
- **This is why we use L2 instead of L3 or L4**

### Reward Functions
Positive reinforcement
- When the model gets closer, the output gets bigger