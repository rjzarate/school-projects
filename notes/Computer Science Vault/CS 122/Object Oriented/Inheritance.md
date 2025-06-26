Has multiple inheritance
## Defining a Subclass
### Syntax
```
class SubclassName(SuperclassName):
	body
```
#### Overriding Existing Superclass Functions
```
def superFunctionName(self, ...):
	body
```
#### Overriding Initialization Function
```
def __init__(self, ..., *args, **kwargs):
	body
	super(SubClass, self).__init__(*args, **kwargs)
```
- `*args` and `**kwargs` allows it such that **when the Superclass `__init__` changes, you don't have to change the Subclass!**
## Multiple Inheritance
```
class SubclassName(SuperclassName, SuperclassName1, ...):
	body
	def __init__(self, ..., *args, **kwargs):
		body
		super(SubclassName, self).__init__(*args, **kwargs)
```
- Order matters for the `Superclass`es!
### `.mro()`
Will get the **"order"** of what it will prioritize for the inherited classes