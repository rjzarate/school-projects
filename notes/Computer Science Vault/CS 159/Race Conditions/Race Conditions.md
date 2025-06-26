Multiple processes reading and writing to some shared global variable
- When multiple processes **execute at the same time** in a [[Critical Sections|Critical Section]]

The exact sequence of instruction by instruction is **determined by the OS CPU Scheduler**
- Non deterministic bug
- See which "wins" the race

Ex.
- 2 People using ATM with shared bank account
- **Both** will withdraw
- Balance is not updated until both have is withdrawn

Even the **OS can have Race Condition bugs**
- Ex. Print Spooler
	- Spooler has a Global List that hold the file name
		- Has `IN` and `OUT` global vars
		- `IN`: Points to the **next free slot** in the Global List; the "end of the line"
		- `OUT`: Points to the **current slot to print** in the Global List
	- If two people (processes) want to print at the same time, has the possible to **override** on another
		- ProcessA puts its file in the `IN` location `x` in the Global List, but before incrementing `IN` so that the next processes will put its filename to the "end of the line", ProcessB uses the `x` location rather than `x + 1`
## Solution
**Four**:
1. No two processes can be **inside the [[Critical Sections|Critical Section]]** at the **same time**
2. No need to know the # of CPUs and relative process speeds 
3. No process **stopped outside** its **Critical Section** can **block other processes**
4. No process can be **indefinitely postponed** from **entering its Critical Section**
