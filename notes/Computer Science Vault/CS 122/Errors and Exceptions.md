## Error Types
### Intrinsic
1. Syntax
	1. **Cannot** run the program
2. Wrong Data Type / Function / Variable Name
	1. **Will** run the program, but stops when it hits this error
3. Bugs
	1. **Will** run the program, but doesn't do what you want it to do
### Extrinsic (Exceptions)
1. Files isn't found
## Exception Handling
### `try/except` Block
Basically a try/catch block
#### Syntax
```
try:
	# Do stuff that may cause an exception
except:
	# This block will run if an exception happens
else: # optional
	# This block will run if no exceptions were found
finally: # optional
	# This block will run guarenteed w/ or w/out exceptions
```
With Exception Types `Exception`
```
try:
	# Do stuff that may cause an exception
except IOError:
	# This block will run if an IOError exception happens
except Exception:
	# This block will run if an exception happens that weren't the previous ones
else: # optional
	# This block will run if no exceptions were found
finally: # optional
	# This block will run guarenteed w/ or w/out exceptions
```
With Exception Type Objects `as e`
```
try:
	# Do stuff that may cause an exception
except Exception as e:
	# This block will run if an exception happens that weren't the previous ones
else: # optional
	# This block will run if no exceptions were found
finally: # optional
	# This block will run guarenteed w/ or w/out exceptions
```
### Exception Object
Some exceptions have specific values that give information about the exception
#### `e.strerror`
String description of the exception
- *ValueNotFound* exception does not have this!!!
#### `e.args[i]`
Gives details of the exception
### Raising Exceptions `raise`
Basically throwing exceptions
#### Syntax
```
raise ValueError("Some custom error message")
```
Custom Exception
```
class CustomError(Exception)
	pass
```
- You `pass` because you can rely on the constructor from the Exception superclass
## Assertion
Basically `assert`
### Syntax
```
assert condition, message
```
In `try/except` block
```
try:
	# stuff
	assert condition, message
except AssertError as e:
	# can print assertion with print(e)
```