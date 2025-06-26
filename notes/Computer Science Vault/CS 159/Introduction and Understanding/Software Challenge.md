PROBLEM: **Cannot extract parallelism without user support**
Goal: Make parallel programming the mainstream method for improving software performance
## Technical View
If hardware (HW) goes parallel, then software (SW) needs to go parallel
- Else, no performance gained

Re-engineering: take old code (sequential) into parallel code
- Don't want to throw away the old code
### Race Condition
**Multiple threads performing concurrent access to the same shared memory location**
- Threads "race" to access the memory
- Non-deterministic behavior
- Most common error

Hard to debug and detect
- Very subtle; no errors shown
- Hard to reproduce

Mutex and semaphores have overhead and makes it "sequential"
### Deadlock
2+ threads are blocked because each are **waiting for a resource held by the other**

Easier than race condition
- System usually freezes, but no errors

### Concurrent vs. Parallel
Concurrent "looks" like it's parallel
- One processor that is super fast
	- Being shared; only one tasked being executed
	- Multi-tasking
- **Is sequential**
### Amdahl's Law
Diminishing marginal rates of returns when increasing the amount of parallelism
- More overhead paralyzing
