All classes inherit from `object`
## Defining Classes
### Syntax
```
class ClassName:
	body
```
- Uses PascalCase
## Creating an Object
To create an **instance of a class:**
`object_name = ClassName()`
- Can have parameters in the initializer
## Initializer
### `def __init__(...): ...`
Runs when a instance of the class is created

## `self`
Equivalent to Java's `this`
Have to add this to **every function** if you want to:
- Access the object's functions, attributes
Ex.
- `def get_attribute(self):`
	- `return attribute`
- `def print_attribute(self):`
	- `print(self.attribute)`

## `@property`
When above a class function with single parameter `self`, can call the function without `()`
Ex.
```
class ClassName:
	@property
	def propertyName(self):
		return x
	@propertyName.setter
	def set_propertyName(self, newVal):
		self.x = newVal
	@propertyName.deleter
	def delete_propertyName(self):
		del self.x

objectName = ClassName()
objectName.propertyName  # will return x
objectName.propertyName = y # allowed with @propertyName.getter

```

You **cannot change the property** without a `@propertyName.setter`
Can return attributes in the class
### `@propertyName.setter`
This function is called when `objectName.propertyName = x` is called
- Takes an additionally parameter of the input
### `@propertyName.deleter
This function is called when `del objectName.propertyName` is called
