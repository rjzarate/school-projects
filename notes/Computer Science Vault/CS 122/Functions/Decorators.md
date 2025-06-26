Modifies behavior of a [[CS 149/C/Functions|Function]] or Class
## Syntax
1. Define a function with a function parameter (Higher Order Function/Decorator)
2. Inside that function, define another function (Wrapper Function)
	1. Inside the Wrapper Function, you can call the function parameter
	2. Wrapper Function can have parameters
3. Higher Order Function returns the Wrapper Function
4. In another function, use the `@decorator_name` before defining the function
	1. The parameters of this new function is the Wrapper Function's parameters

Ex.
Code:
```py
# An example of a wrapper function with input arguments
def cs122_decorate(func):
	# This decorate function prints the name of the
	# function it’s wrapping when the function is defined
	print("in decorate function, decorating", func.__name__)
	def wrapper_func(*args):
		print("Running", func.__name__)
		return func(*args)
	return wrapper_func # the decorator returns the wrapped function

# use decorators in a simpler way with the @ symbol, sometimes called
# the "pie" syntax.
@cs122_decorate # mighty_func is decorated using @cs122_decorate
def mighty_func(param):
	print(param)

@cs122_decorate # multi_input_func is decorated using @cs122_decorate
def multi_input_func(*params):
	print(*params)
	#print(params[0],params[1])

#The wrapped function is called after the decorator function has completed
mighty_func('CS122 is the best!')
multi_input_func('One', 'Two', 'Three!')
```
Output:
```
in decorate function, decorating mighty_func
in decorate function, decorating multi_input_func
Running mighty_func
CS122 is the best!
Running multi_input_func
One Two Three!
```