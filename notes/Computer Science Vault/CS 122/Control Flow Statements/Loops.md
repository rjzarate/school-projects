## `for` loop
### Syntax
`for LIST_ITEM in LIST:`
	`code here`
`else:`
	`no-break-post-loop`
- Similar to enhanced for loop
- `else` block is optional
	- `else` **executes when there has been no** `break`!

`for i in range(max_exclusive):`
	`code here`
- Similar to `for (int i = 0; i < max_exclusive; i++) {..}`
### Unpacking
Can have **multiple** `LIST_ITEM`s
- Separate with commas
- For when the `LIST` contains multiple values (ex. nested list)
- `for a, b, c, ... z in LIST:`
## `while` loop
### Syntax
`while condition:`
	`body`
`else:`
	`no-break-post-loop`
- `else` block is optional
	- `else` **executes when there has been no** `break`!
## Special Statements
### `break`
**Terminate** loop
### `continue`
Moves to **next iteration**
