---
aliases:
  - Critical Section
---
Proposed by Dijkstras

A section of a program where **global shared memory** is being accessed
- A process has **exclusive access** to the **shared data** when in the **critical region**
	- Will make **all other processes wait** if they want to access the shared data

Have to be **executed as quickly as possible**
Coded carefully
Has **termination housekeeping**
- When a process in the critical region **aborts**, releases the **mutual exclusion**
