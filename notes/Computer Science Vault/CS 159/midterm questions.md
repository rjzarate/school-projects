3 states?
- Ready, Run, Wait
how many processors in each state?
- Only 1 in Run; many in Ready & Wait
what overhead do you want to reduce from these states
- Run & Ready
the heat in powerwall?
- Frequency
3 Hazards
- Data: 2nd instruction needs previous instruction
- Control: Branch
	- Solution: flush
- Resource: no function unit space left for the instruction to run
Inherent data dependency
- Even if you add more function units, if you have data hazards the HW can't do anything about it
4 Stages of instruction
- IF Fetch Instruction
- ID Decode: understand the instruction and find the address
- OF Fetch Operand
- EX Execute
Dynamic RAM problems:
- Destructive Read
- Volatility
number k; number of stages in a pipe
- When k large: speed up the system
	- Interstage delay when too large
- Want k small when:
	- Lots of branches; longer it takes to flush
Two types of overhead
- Stage imbalance: have to make the slowest instruction make the other instructions wait
- Interstage delay: inbetween time from moving from one instruction to the next
