## Problem
0. Multiple readers to go in, but only one writer
1. When anyone is Reading, want no one Writing
2. When someone is Writing, want no one Reading


## Solution
Needs a **globally shared variable**:
- RC
	- 

Need **2 [[Semaphore|Semaphores]]**:
1. DB
	1. To stop the Reading & Writing at the same time
2. MUTEX
	1. To protect the RC counter

**Initialization**:
1. DB & MUTEX are set to 1
2. RC 

**Reader Process**:
1. Must wait (P) for **MUTEX**
2. Increments **RC**
3. If **RC is 1**, must wait (P) for **DB**
	1. Basically, will lock any writers if there is a reader
4. Frees (V) **MUTEX**
5. Can now read
6. When leaving, must wait (P) for **MUTEX**
7. Deincrements **RC**
8. If **RC is 0**, frees (P) **DB**
	1. Basically, when no more readers, can free DB so a writer can go
9. Frees (V) **MUTEX**

**Writer Process**:
1. Must wait (P) for **DB**
2. Can now write
3. Frees (S) **DB**

### Priority Problem
This solution **prioritizes readers**
- If a writer want to write, readings can keep coming in and as long as there is at least 1, the writer cannot write
