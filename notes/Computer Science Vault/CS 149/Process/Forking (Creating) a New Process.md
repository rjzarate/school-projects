## `fork()`
Creates a **new clone "child" process** of the current "parent" process
1. Copies file descriptors and memory segments
	- Address space, registers, PC
2. Runs concurrently (parallel) with the parent process
3. Has a new program loaded to it

- Returns:
	- When `fork()` in the Parent Process: [[Process Identifier (PID)]] **of the Child Process**
	- When `fork()` in the Child Process: 0
- In essence, clones EVERYTHING except `fork()` value
## Calling Multiple `fork()`
Each `fork` **doubles** the current amount of processes
### Parallel Processing
When running two process simultaneously, which ever process runs first is random