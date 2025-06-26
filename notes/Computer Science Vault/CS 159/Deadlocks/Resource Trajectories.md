Graphical method to visualize [[Deadlock|Deadlocks]]
![[Screenshot 2025-03-17 at 6.56.23 PM.png]]
- Axises are Processes 1 & 2
	- x-axis is Process 2
	- y-axis is Process 1
- Numbers are "Instructions" that the Process is currently on
	- Creates "Boxes" for "intersecting" process
- r1 & r2 are resources
	- Process 2 uses r1 for Instruction 1-3
	- Process 2 uses r2 for Instruction 2-4
	- Process 1 uses r1 for Instruction 6-7
	- Process 1 uses r2 for Instruction 5-8
- A, B, and C lines *(dashed/dotted)* is ways the CPU executes the process
	- A & B are fine
	- C is bad

Shows that **IF THE EXECUTION LANDS IN THE BOX** *(1-2, 5-6), **IT'S GGS**