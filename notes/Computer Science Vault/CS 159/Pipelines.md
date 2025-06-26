## Pipeline Example
Imagine a car
- Has parts: frame, body, engine, seats
- For sequential: will do 1 hour each; so 4 hours
- Will have multiple cars
	- While car #1 has it's seats installed, car #2 has it's engine installed, and car #3 ...
- Technically, is 1 hour per car
## Speedup
old_time (NK) / (time_steps_for_the_first instruction (K) + N - 1)
- N is (N-1) instructions
NK is single parallelism
K is the number of steps to finish an instruction
## Overhead
Stage Imbalance:
- Delayed by the **slowest** broken instruction *(stage)*
- All have the "same master clock"
and inter-stage delay:
- Pick the car up and move it to the next stage; separate the stages
	- Basically going from one step to the other step takes time
## Instructions Stages
Fetch instruction, decode instruction, fetch operand, execute
## Hazards
What slows down your pipe
3 types:
1. Data
2. Control
3. Resource

Requires to **stalls the pipeline**; don't stop the **whole pipeline**, instructions **in front keep going**, instructions **in back stall**.
### Data Hazard
When a statement requires data from previous statement
Ex.
- X = X + 1
- Y = X + 1 *(requires statement 1; data hazard on X)*

Will delay because cannot fetch data until the statement finishes executing *(4th stage)*. Delayed by **1** *(bubble)*.

Can have multiple data hazards.
- Increases chance when K is large
Three types:
1. RAW (Read after Write)
2. WAR (Write after Read) *(for multi-lookahead)*
3. WAW (Write after Write) *(for multi-lookahead)*
#### RAW (Read after Write)
The current instruction requires the previous instruction.
### WAR (Write after Read)
The current instruction is changing when it is used for the previous instruction.

Avoided with buffer.
### WAW (Write after Write)
Previous instruction(s) are changing the same register; indeterministic for what the register will be with multi-lookahead
#### Neutral Instruction
Rearranging instructions
### Control Hazard
When branching, has to finish executing *(until decode instruction?)*, delaying all statements.
- Branching 
- Will flush the uncompleted statements no matter if the branch is true or false
	- If branch is false, will redo the flushed data
	- If branch is true, will make the non branch instructions not run

Penalty is heavy; can make it K times slower
#### Hint Bit
Do Loop with Hint Bit where it will usually go back to the top
- Usually only compiler can do this
## Resource Hazard
Make sure the instruction is in the right "function" *(add, mult, sub, etc.)* and there is **space** for it
- If you only have 1 adder and it is being used, the next instruction has to wait