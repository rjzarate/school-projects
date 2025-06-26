A **Scheduler** that learns from it's past to predict the future

Has **different queues priorities** *(high, medium, low)*
- Jobs are attached to these queues
- All jobs are ready to run (Ready State)

## Objectives
1. Run jobs without a prior knowledge of job length
	1. (Tries to have shorter jobs complete faster)
2. Minimize **response time for interactive jobs**
3. Optimize **turnaround time for long-running jobs**

## Rules
### Running Jobs
Runs jobs in the highest priorities
- Jobs with the same priority uses round-robin
### Changing Priority
New jobs are **placed in the highest priority**
- Reduced if it takes the entire time slice (fixed number of time interrupts)
- Job stays if it doesn't use all of the time slice
#### Upgrading Priority
Moves all jobs to the top most queue after a certain amount of time
- To avoid [[Multi-Level Feedback Queue#Starvation]]
## Problems
### Starvation
When a job is waiting for the CPU, but it **never gets it's turn**

Occurs when:
- Too many interactive / IO jobs
- Long-running jobs never get executed

Solutions:
- OS knows what jobs/queues have not been ran for a long time, so they upgrade the priority of it
### Game the Scheduler
After running 99% of a time slice, issue an I/O operation to give up CPU
- i.e. raise an I/O operation every 9 milliseconds

Solutions:
- Downgrade priorities that have used a lot of time rather than time slice
### Complex Programs
Processes that changes its behavior overtime

Solutions:
- Lower priorities get higher time slices

## UNIX Priority
### "Niceness"
Ranges from -20 (Highest priority) to 19 (Lowest priority)
- Defaulted to 0
#### Parent v. Child
By default, parent and child would have the same priority
- Both get about 50%/50% cpu