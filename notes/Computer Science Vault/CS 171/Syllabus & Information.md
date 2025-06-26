## Intro: Artificial Neural Network
Creating the right "function"
- Computers would start with a "simple" function, then will keep adjusting the function to match the right (approximate) function (Training a Model)
	- Function becomes a "black box" where you can't really understand the function just by looking at it
## Machine Learning v. Artificial Intelligence
Machine Learning is a subset (contains) of AI
Deep learning is a subset of machine learning

## [[Training]] a Model
The dataset matters!
- A better dataset trains a model better
### Bias Data
With a poor quality data, it can train the model poorly
- Ex. Model only picking males because the dataset had more males
	- Model believes that males are good

### Training
There's a Real Value and an Output that the model gives. A score (Objective Function Score) is given (higher is worse; shows how far it is from the Real Value).

#### Parameters (Alpha)
Model will start with random Alphas.
Another set of V's are the given features
Model is trying to find the best parameters (Alphas) with the features
#### Training Process
Data -> Model -> Objective Function (Gives Objective Function Score) -> Optimization Algoritm (Smaller Number = Little change to model; Bigger Number = Big change to model) -> Repeat

## [[Machine Learning Types]]
### Trial-and-Error (Brute Force)
Try random parameters until you find the right est
