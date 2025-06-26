## Program Development Cycle
1. Design and Code (.c)
	1. your code
2. Preprocess
3. Compile (.s)
4. Assemble (.o)
5. Linkage (executable)
6. Run & Test
## int main(void) Function
Mandatory to start an execution
Returns an int
- Status code
- **0 is success!**
## \#include<stdio.h>
Means **include header files in code before compilation**
stdio is a predefined standard library of functions under a system path
## \#include ”mylib.h”
Header file is in this directory as "mylib"
## \#define
Gets Preprocessed before Compile
## && vs. ||
&& is HIGHER PRECEDENCE THAN ||
so `x || y && z` evaluates to `x || (y && z)`
## ++i vs. i++
`++i` is **pre**-increment
`i++` is **post**-increment
When doing `j = ++i`, `j` grabs the **new** (incremented) value of `i` (`i + 1`)
When doing `j = i++`, `j` grabs the **old** value of `i`
- `++i` may be faster 

Same for `--i` and `i--`
## New Line `\n` v. NULL `\0`
`\0` defines **when the string should end**
`\n` creates a new line
- For `getline()`

## Array Size Initialization
When defining an array with a predefined array (ex. `(1, 2, 3, 4)`), then you do not need to add the size.
- Compiler can infer the size

For multi-dimensional arrays, only the first array can be undefined
- `array[][x]`
	- `x` is 
- `array[][y][x]`
## Running a C Program
### ./PROGRAM
Look under PROGRAM directory; basically where it is in the terminal

## Static Variables
When declared, cannot be declared again
- Value will not change when calling `static [type] [name] = [value]` again


## String v Character
String has a sequence of **Characters, ending with NULL (value of int 0)**.
- NULL-terminated value is `'\0'`
- A string thats `""` is equivalent to `['\0']`

