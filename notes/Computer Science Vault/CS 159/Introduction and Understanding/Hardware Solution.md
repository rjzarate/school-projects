## Idea
Imagine a **road**
- Computer Hardware Evolution Highway
Car & Driver = Hardware & Software
- Car/Hardware changes, the driver/software should change
	- Driver should change as in they should drive differently
## Microscopic View
CPUs back in the day (1978):
- Few ten thousand transistors
- Clock frequency was in megahertz
In 2006:
- Millions of transistors
- Clock frequency was in gigahertz
### Moore's Law
**Number of transistors double every 2 years**
### Clock Rate Problem
Reached a limit
More Clock Rate = More Power
- Makes it super hot
	- Heat is **cubed**
#### Clock Rate Solution
Go from single-core to multi-core
- Sequential Processing to Parallel Processing
- For heat, if running at *2f* (frequency)
	- Single core would be (2f)^3 heat
	- Multicore would be (1f)^3 + (1f)^3 heat
#### Other Solutions
Instruction-Level Parallelism
- Limit was reached nvm
Pipelining and Multi-Function Units
## Macroscopic View
Cluster computer
- Local; usually made of weak computers
Grid computer
- Distributed
## Business View
Computer Power & New Applications = Computer Power & New Applications
- Software is like a Gas that "fills" the computer?
### Technology Curve
Makes a U shape
Cost over Performance vs. Performance
- Underutilization
	- Cost over Performance > Performance
		- Time spent learning
- Optimum Utilization
	- Cost over Performance <= Performance
- Over-utilization
	- Cost over Performance >= Performance
		- Both are high
## Implicit Hardware Parallel Processing
- "Implicit:"
	- The hardware doing parallel things *(pipelines)*
	- Future: AI compiler turning sequential code to multi
- Explicit:
	- Have to code from sequential to multi-parallel