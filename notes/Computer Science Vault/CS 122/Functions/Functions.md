## Syntax
```
def function_name(parameter1, parameter2, ...):
	body
```
- Optional to `return`; returning nothing gives None
## Higher Order Functions
Functions that **take another function** in it's parameter
## Pure Functions
Most functions should be pure functions!
1. **Always** return the same value with the same arguments
2. No side effects
	1. Doesn't change mutable arguments
## Argument Options
### Positional Arguments
Calling the function based on the **position** of the arguments

Ex.
- `def function_name(x, y, z): ...`
	- `function_name(1, 2, 3)` will default:
		- `x` = 1
		- `y` = 2
		- `z` = 3
### Keyword Arguments
Calling the function based on the **explicitly assigned parameter variable name**

Ex.
- `def function_name(x, y, z): ...`
	- `function_name(z=1, y=2, x=3)` will default:
		- `x` = 3
		- `y` = 2
		- `z` = 1
#### Combining Positional & Keyword Arguments
1. Positional **must be first**; Keyword Arguments cannot come before Positional
2. Keyword Arguments cannot override Positional
	- Will throw an error for "multiple values" for one argument
### Default Value for Arguments
When defining a function, can have **parameters have a default value** when it's called and the parameter is not defined

Ex.
- `def function_name(x, y, z=3): ...`
	- `function_name(1, 2)` will default:
		- `x` = 1
		- `y` = 2
		- `z` = 3

Follow rules for [[CS 122/Functions/Functions#Combining Positional & Keyword Arguments]] when merging together
### Variable Number of Arguments `*`
Prefixing the **LAST argument** with a `*` causes:
1. All excess **non-keyword** arguments are wrapped in a [[Tuples|Tuple]]
#### Variable Number of Keyword Arguments `**`
Prefixing the **LAST argument** with `**` causes:
1. All excess **keyword** arguments are wrapped in a [[Dictionaries|Dictionary]]
## Lambda Function `lambda`
Also known as anonymous function
Can take **any number of arguments**, but can **only 1 expression**
- `lambda arguments : expression`
	- Literally write `lambda` :skull:
## Generator Functions
Declare a function that is like a iterator to be used for loops
- Will return a [[Generators|Generator]] object
### `yield`
Similar to `return`, but **WILL NOT exit the function**
## Pre-Built Functions
### `zip(list1, list2)` *(Packing)*
For combining two [[Lists]] / [[Tuples]] and returns a **Zip** *(list of tuples when casted to list)*.
- Ends on the shortest list (will remove extra items)
- For packing dictionaries, will **only use the keys**
### `map(function, iterable)`
Returns a map object that **applies the function in each element in the iterable object**
### `filter(function, iterable)`
Returns a filter object that **applies the function in each element in the iterable object, and only adds the elements that succeeds the function**
- `function` should return a boolean!