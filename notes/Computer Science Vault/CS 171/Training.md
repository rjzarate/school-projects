## Datasets
Training a model requires a dataset.
The dataset **matters**!
- A better dataset trains a model better
	- A generalized dataset is better
### Bias Data
With a poor quality data, it can train the model poorly
- Ex. Model only picking males because the dataset had more males
	- Model believes that males are good

## Overview
There's a Real Value and an Output that the model gives. A score (Objective Function Score) is given (higher is worse; shows how far it is from the Real Value).

### Parameters (Alpha)
Model will start with random Alphas.
Another set of V's are the given features
Model is trying to find the best parameters (Alphas) with the features
### Training Process
1. Dataset
2. Model Uses Dataset
3. Objective Function (Gives Objective Function Score)
4. Optimization Algoritm (Smaller Number = Little change to model; Bigger Number = Big change to model)
5. Repeat