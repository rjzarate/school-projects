---
aliases:
  - Semaphores
---

Literally just an **Integer** value
- Is a **Gate**
- Can **only be altered** by **System Calls**
	- Must ask the OS
	- Executed with P or V
		- P: **enter** and **close gate** *(deincrement)*
			- If **gate is closed**, process who **run P must wait**
		- v: **exit** and **reopen gate** *(increment)*

P & V are **atomic**
- Runs them in a **non-interruptable form**
	- OS will **send an interrupt**, which will **temporarily disables the CPU Scheduler**
- The scheduler is **only disabled for P & V**, **not the code in the [[Critical Sections|Critical Section]]**
## P(S)
Two lines:
1. `S--;`
2. `if (S < 0) wait;`

`wait` makes the process **halt** / go to the **Wait State**
## V(S)
Two lines:
1. `S++;`
2. `if (S <= 0) signal;`
	- This will **run if a process is waiting**

`signal` makes the **first process that was waiting** go to the **Ready State**

## Binary Semaphore (MUTEX)
Mutual Exclusion where Semaphore S can either be:
1. 1 *(open)*
2. 0 *(closed & no process is waiting)*
3. -1 *(closed & another process is waiting)*
### Mutual Exclusion
Requires **1 Binary Semaphore** initialized to **1**
### Synchronizing Processes
Requires **2 Binary Semaphores** both initialized to **0**
1. Process 1 and Process 2
	1. Process 1 opens gate V(S1), then requires P(S2)
	2. Process 2 opens gate V(S2), then requires P(S1)
### Parent Waiting for Child Process
Requires **1 Binary Semaphore** initialized to **0**
1. **Child will open gate V(S)**
2. **Parent will require gate to be open to continue P(S)**
## Embedding Semaphores
Is possible, but can lead to deadlock!!