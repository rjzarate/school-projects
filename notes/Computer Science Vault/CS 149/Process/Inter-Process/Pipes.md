Like a **buffer FIFO queue**
**Uni-directional**
- One process can only read, and other can only write
- Not Bi-directional

Maintained by the **kernel** space
- Need to be **system calls**
## Terminal Usage `|`
Use `|` in the terminal
- Can connect multiple processes with multiple `|`

## C Usage `pipe(pfds)`
Initialized `pfds` to be the "pipe"
- `pfds` is an int array of size 2
- `pfds[0]` is for **reading** at the END of the pipe **READONLY**
- `pfds[1]` is for **writing** at the END of the pipe **WRITEONLY**
### Reading `read(pfds[0], buffer, byteAmount)`
- `pfds[0]` is where it will get the string
	- READONLY flag
- `buffer` is where it will store the string
- `byteAmount` is how many bytes are in the `string` (amount of characters + 1 *(NULL terminator*)

**Will not read until there is data in it** *(someone writes)*
### Writing `write(pfds[1], string, byteAmount)`
- `pfds[1]` is where it will store the string
	- WRITEONLY flag
- `string` is the string being stored
- `byteAmount` is how many bytes are in the `string` that was written (amount of characters + 1 *(NULL terminator*)
## Parent & Child Process Communication
When [[Forking (Creating) a New Process]]:
1. Parent CANNOT **WRITE**, ONLY READ
2. Child CANNOT **READ**, ONLY WRITE
![[Screenshot 2024-09-18 at 12.53.45 PM.png]]

Can `close` the parent's write-end and the child's read-end to avoid bugs