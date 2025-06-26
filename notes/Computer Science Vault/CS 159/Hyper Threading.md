Intel Technique to Accelerate context switching via extra HW and Significant SW (run-time) overhead for swapping processes in and out of Run
## Job Cycle (States)
1. User **Submits**
2. Job is on **Hold**
3. Job is now **Ready**
4. Job **Runs**
5. Job either **Ready**, **Waits** or is **Complete**
	1. When **Complete**, sent back to the user
	2. When **Waiting**, can become **Ready** again to **Run**
	3. When **Ready**, can **Run**

Can have more than 1 job that is Ready
### Scheduler
The **Ready**, **Run**, and **Wait** States
Lots of overhead when swapping between Jobs that go from **Ready** and **Run** and vice versa
- Ex. Job A is Ready, Job B is Running, Job A will swap with Job B
#### Solution
Two **Architectural States** for one CPU *(core)*
- Will not run twice as fast; instead allows the cpu to switch between states
