## Row v. Column Major Order
Initializing a matrix by rows first vs column first.
- Row Major Order is a lot faster
	- Memory technology lags cpu b/c of physics
		- Basically, capped at speed of light; so making memory bigger will increase distance speed of light has to travel
```
// Row Major
for i
	for j
		array[i][j]

// Column Major
for j
	for i
		array[i][j]
```
## CPU Hierarchy
1. Cache *(7ns)*
2. RAM *(70ns)* *(usually 10x slower than cache)*
3. Disk *(ms)*
### Cache Line
Basically a line *(bucket)* of n units of data.
**Cache Hit**: when cpu needs a certain part of data and it is in the cache
**Cache Miss**: it isn't in the cache, has to use RAM
- Cache line will update, and will change and pick up n amount of data that the cpu assumes that it will use
	- Spatial Locality of Reference
#### Spatial Locality of Reference
Next item needed will be close in address to the current used item
- It's why Row Major is usually faster
	- C uses Row Major, but Fortran uses Column Major

Most **compilers** uses this; software *(code)* has to adapt to this
- Fortran doesn't do this
## Memory Cell Types
### Static
when you have power, when you flip it (active flip flop gates), it stays that way
- Cache

Big
### Dynamic
simpler and cheaper, but can "change/disappear"; **dynamic**, **volatile**, and **destructive**
- RAM

Uses capacitors that are filled with electrons to represent 0s and 1s; since electrons will basically disappear and stuff *(volatile)*, you would have to refill the electrons *(dynamic)*.

**Destructive Read Out:** When reading, it **removes all the electrons**. Thus, has to refill the electrons again
- Creates a **wait period**:
	- **Cycle Time** = **Access Time + Wait Time**
	- When the cpu prepares the memory it wants to access, it will take **Access Time** to receive the data . For the cpu use the memory again, it will have to wait an additional **Wait Time** *(overhead)*
#### Solution *(For Instructions)*
Parallel processing ✨; N-Way Interleaved
Make memory like modules, so that when there is a **Wait Period**, it makes the modules wait rather than all of the RAM

**Cycle Time** = **Access Time + Wait Time**
#### Solution *(For Data 4x4 matrix)*
Same for instructions, but requires some "arrangement" for storing the data in the different modules

"Straight" Arrangement: puts it like a "matrix"
- makes Row and Diagonal order good, but, column order bad

"Skewed" Storage Arrangement: puts it like a "matrix", but shifts each row by 1 *(will wrap)*
- Good with Row and Column order, but diagonal order has some overlap

"Two's Skewing" Storage Arrangement: puts it like a "matrix", but now add a 5th module, then shift row by 2. Will have empty data
- Good will the common orders, but wasted memory cells