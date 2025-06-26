Are **mutable**
Key-Value pairs!
1. Keys are unique
2. Key must be **immutable** and **hash-able**
3. Values can be anything!
## Constructor
`{key_0: value_0, key_1: value_2, ..., key_n: value_n}`
## Retrieving Data from A Dictionary
`dictionary[key]` will return the `value`
`dictionary.get(key, key_has_no_value)` will either return:
- The `value` of the `key` if it exists in the `dictionary`
- `key_has_no_value` if the `key` does not exist in the `dictionary`
## Dictionary Operations
![[Screenshot 2024-08-29 at 10.00.38 AM.png]]
## Comprehension
Kinda like **lambda** expressions but for creating new Dictionaries
`{ KEY:VALUE for LIST_ITEM in LIST if condition }`
- Ex. `{ x:x*x for x in LIST if x >= 0 }` will return a dictionary of only positive numbers, where:
- Key is `x`
- Value is `x` squared (`x**2`)
### Generator Expressions
Similar to **Comprehension** but uses `()` instead of `{}`
- The new Dictionary is not created in memory
- **CANNOT BE INDEXED OR CASTED TO DATA STRUCTURES**
- After being iterated, will **end on the tail**!