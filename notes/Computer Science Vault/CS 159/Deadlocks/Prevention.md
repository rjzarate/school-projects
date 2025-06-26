Prevent [[Deadlock|Deadlocks]] by **removing at least 1 of the 4 [[Conditions]]**
### Mutual Exclusion Condition
Hard since [[Resource|Resources]] are **non-sharable** *(card-readers, writable file)*
### Hold and Wait Condition
Use **preallocation**. Process will **request ALL required resources**.

Easy to implement, but:
1. Not very efficient
	1. Process might just need the resource at the very end of execution
		1. Resource is held for the entire execution
		2. Resource is now inaccessible for other processes
2. Wasteful
	1. Process may not even use the resource
3. "Difficult to formulate and predict full (and contingent) resource requirements before execution starts."????
### No Preemption Condition
Process preempties its resources if it is requested by another process
- Will eventually need to request the resource later
	- Too expensive

Task switching other resources is generally not feasible
### Circular Wait Condition
Imposing an order of resource types
- **Standard Allocation Pattern (SAP)** or **Hierarchic Allocation Resources (HAR)**
- Each resource has a "level" in a hierarchy

Resource allocation requests are made in **ascending order**
- Ex. process has resource k, it can only request resources at **level > k** *(resources above k)*

Pros:
1. Just require resources in a **certain order** rather **all at once**
2. Doesn't need maximum needs to advance???

Cons:
1. More costly than full preallocation *(Hold and Wait Condtion fix)*
2. Hard for programmer
	1. Constraint is imposed on the **natural order** of resource requests
		1. Order can't really be changed and is set
	2. Hard to find ordering that satisfies processes
3. Order can differ than the hierarchy
	1. Process needs Tape & Plotter
		1. Plotter is used early and throughout execution
		2. Tape is used at end of execution
	2. Tape Level < Plotter Level
	3. Tape must be preallocated early for Plotter to be allocated
	4. Thus, Tape is idle until the very end :(