Also known as **bounded buffer**
## Problem
1. Producer adds to a number (buffer)
	1. Can add an x amount
2. Consumer removes to a number
	2. Can remove a y amount
3. Number has a maximum limit
## Solution
Need **3 semaphores**:
1. EMPTY
	1. Indicates and signals when consumer takes from buffer
2. FULL
	1. Indicates and signals when producer fills buffer
3. MUTEX
	1. to protect the buffer *(protects the critical section)*

Initialization
1. MUTEX is 1
2. FULL is 0 *(no items yet)*
3. EMPTY is equal to **how many can be in the buffer**

Producer Process
1. Must wait (P) for **EMPTY** then **MUTEX**
2. Can now add to buffer
3. Frees (S) **MUTEX** then **FULL**

Consumer Process
1. Must wait (P) for **FULL** then **MUTEX**
2. Can now add to buffer
3. Frees (S) **MUTEX** then **EMPTY**
### Notes
1. This works for only **single consumption and production**, but **idea can still work**