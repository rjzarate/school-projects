A data type that returns:
- range(int starting_value_inclusive = 0, int end_value_exclusive, step = 1)
Ex.
- `range(5) (returns range(0, 5)`
## As a List
In essence, a range(starting_value_inclusive, end_value_exclusive) is a list:
- `[starting_value_inclusive, starting_value_inclusive + 1, starting_value_inclusive + 2, ... , end_value_exclusive - 2, end_value_exclusive - 1]`
Useful for [[Loops]]