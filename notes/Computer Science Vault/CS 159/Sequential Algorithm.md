## Inherent Sequentiality
## Artificial Sequentiality
- where lines of code don't matter which goes first
	- Ex. x = 0; y = 0; z = 0;
### Lookahead
Hardware stuff

Basically, looking forward for the next instructions
- Ex. hardware only has so many adders, multipliers, subtracts, etc.
	- If the one instruction is an adder, and then looking ahead, the next instruction is an adder, it will "squeeze" the two
		- Can only do this if they are not data dependent
		- There isn't a resource hazard

VLIW: basically talks about how expensive the lookahead is

Single level
## Multi-Operation Instruction
The compiler and "marks" each instruction before the execute.
- Without this, when reading each instruction, will have to designate the instructions during runtime

Was still just as fast as sequential stream of instructions