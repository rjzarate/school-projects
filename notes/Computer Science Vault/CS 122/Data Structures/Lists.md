	## Constructor
`[x_0, x_1, x_2, ..., x_n]`
## Strings v. Lists
Lists are **mutable**, while Strings are **immutable**
## Functions
Most list functions **DO NOT return** anything (void)
### `len(LIST)`
Returns the **number of elements in the list**
- Doesn't count elements in a **nested** list
- Similar to Java's `list.length()`
### `LIST[index]`
Returns the **element** in the list with the given **index**
- Negatives start from the end of the list
- Similar to Java's `list.get(index i)`
### `list.append(element)` v. `list.extend(list1)`
`append` adds a **single object**
`extend` adds a **list**
Ex.
- let:
	- `x = [1,2]`
	- `y = [3,4]`
- `x.append(y)`, `x` returns `[1,2,[3,4]]`
- `x.extend(y)`, `x` returns `[1,2,3,4]`
#### `list1 + list2`
To **NOT** modify the original data, you can use:
- `new_list = list1 + list2`
### `list.sort() v. sorted(list)`
Both sorts a list, but:
1. `list.sort()` **does not** return and modifies `list`
2. `sorted(list)` returns the **sorted list** and **does not** modify the `list`
	- Better to use!
3. `sorted(collections)` works for more than just Lists
#### `reverse=True`
Can to both `list.sort(reverse=True)` and `sorted(list, reverse=True)` to sort in reverse
#### `key=function`
Only for `sorted(list, key=function)`
Sorts with a given function:
- Function takes a single parameter of the **list's element type**
- Function returns a **Integer**


### List of Functions
![[Screenshot 2024-08-29 at 9.17.54 AM.png]]
## Splicing
Read [[String#Splicing]]
## Comprehension
Kinda like **lambda** expressions but for creating new Lists
`{ NEW_ELEMENT_LIST for LIST_ITEM in LIST if condition }`
- Ex. `{ x for x in LIST if x >= 0 }` will return a list of only positive numbers
### Generator Expressions
Similar to **Comprehension** but uses `()` instead of `{}`
- The new List is not created in memory
- **CANNOT BE INDEXED OR CASTED TO DATA STRUCTURES**
- After being iterated, will **end on the tail**!
	- Must define the generator again