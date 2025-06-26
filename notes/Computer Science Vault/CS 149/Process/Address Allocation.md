Starting from the top (high) address:
1. Command-line & environment variables
2. **Stack**
3. **Heap**
4. Uninitialized Data (bss (Block Starting Symbol i.e. **global/static var**))
5. Initialized Data (ds (Data Segment))
6. Text (Program Counter)
## Stack and Heap
Very big chunk of the address!
Heap keeps dynamic data
Stack keeps locally scoped variables (main function)
### Stack
Locally scoped items (temporary data)
1. Function parameters data (parameter ≠ argument)
2. Return addresses
3. Local variables
## Uninitialized and Initialized Data
Where the global/static variables live
- **Where it lives depends on whether its initialized or not**
When global/static/const variables are initialized: Lives is BSS
## Text
Where certain assembly instructions, the program counter, and other 
Ex.
- `i *= 10`
	- `i` is stored in the Stack (local variable)
	- `*=` is an **assembly instruction**
		- `10` is a value connected with the assembly instruction (multiple with immediate!)
		- Assembly Instruction: `mul addr(i) 10`
## Files
Files are NOT stored in the **address space process**
Files are stored in the **kernel** (different data structure)