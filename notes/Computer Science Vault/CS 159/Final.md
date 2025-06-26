## A (Race Conditions & Deadlocks)
**Deadlocks**
1. Mutual Exclusion
2. Hold-and-Wait
3. No Preemption
4. Circular Wait

**Models**
- **Race Conditions**
	1. State Transition Diagrams
- **Deadlocks**
	1. Wait-for Graphs (WFG)
	2. Resource Allocation Graphs *(learned in class)* (RAG)

**Detection**
- **Static** *(Compile Time)*
	1. SPIN
		1. Checks with Linear Temporal Logic (LTL)
		2. Simulate thread interleaving
	2. TLA+
		1. Explores all states of the system
		2. Written abstraction rather than code implementation
			1. Better for algorithm verification
- **Dynamic** *(Runtime)*
	1. ThreadSanitizer
		1. Checks memory access patterns
		2. Uses shadow memory for keeping access history
		3. Big overhead
	2. Helgrind
		1. Reconstructs read and write relations between threads

**Prevention**
- **Race Conditions**
	1. Lock-based Synchronization
		- Semaphores, Mutexes
		- Risks deadlock
	2. Lock-free Programming
		- Atomic Operations
			- Coordinates access to shared memory without blocking
			- Hard
	3. Transactional Memory
		- Atomic Code blocks; avoids explicit locks
- **Deadlocks**
	1. Lock Ordering
		- Threads acquire locks in a predefined order
	2. Resource Hierarchy
	3. Resource Preemption
		1. Not that good for certain devices *(i.e. printers)*
	4. Banker's Algorithm
		1. Checks for "safe states" and "unsafe states"
			1. Checks all resources and requests
		2. During "unsafe states", processes cannot get the resource

**Deadlock Recovery**
1. All process termination instead of just one
2. Pre-empt a resource
3. Rollback

**Formal Verification**
1. Petri Nets
	- Augmented Reachability Graph (ARG)
		- Detect states that deadlock
	- Detects write-write and read-write races

**Real-World Case**
1. Therac-25
	- Race Condition
		- Overdosed radiation
# E (CUDA and Tensor)
**Software**
1. Runtime API *(high-level)*
	1. Handles GPU kernel setup automatically
2. Driver API *(low-level)*
	1. Gives programmer more control
		1. Context switching, processing pipeline

**Hardware**
1. CUDA core
	- For parallel floating point and integer operations
	- More throughput; higher parallel
	- 600-to-1

**Architecture Evolution**
1. Streaming Multiprocessor
	- Context Switching
	- SIMT: warps threads
2. Pascal
	- Different CUDA cores dedicated for int/float
	- Can't do both simultaneously
3. Turing (2000)
	- Can do both int and float simutaneously
	- Raytracing cores: ray-triangle intersection
	- Tensor cores: deep learning
4. Ampere (3000)
	- CUDA core can is both int and float
	- TF32 format for tensor; less precise but faster

**Tensor Cores**
1. Tesla V100
2. AI workloads and matrix multiplication
3. TF32 format for faster but less precise

**Performance Metric**
1. TFLOPS/TOPS *(trillions of operations per second)*
	- Calculated in float point
2. 3000 series have more cuda cores cause ampere cores count as 2

**Rendering**
1. Rasterization
2. Ray tracing

**AI Enhancements**
1. Deep Learning Super Sampling (DLSS)
2. Frame Generation
	- Interpolation: in-between, more fidelity
	- Extrapolation: guess after, less latency

## I (AI & ML)
**AI v. ML**
1. AI
	- Mimics human intelligence
2. ML
	- Subset of AI; no explicit program
	- algorithms and pattern recognition

**Evolution of AI**
1. First AI Boom
	- Alan Turing
	- US Government; lack of progress
		- First AI Winter
2. Second AI Boom
	- Japan robots (walking and moving)
	- LISP failed
		- Second AI Winter
3. Third AI Boom
	- Parallel hardware and deep learning
	- Imagine recognition and smart assistants
4. Future
	1. Quantum, brain chips
	2. Risk of Third AI Winter

**Large Language Models**
1. Uses big data
	- Billions and trillions of parameters
2. Gradient descent
	- Find minimum of a graph/gradient
		- Finds best value
3. Backpropagation
	- Adjusts weights of neural network to reduce error
		- Makes predicted value more to actual value

**Transformer Architecture**
1. Self-attention
	- Words with same spelling, different meaning
	- Picks one word, then picks next words to make the next sentence
## Q (Threading in C)
**C11 Threads**
1. Uses thrd_ and thrd_t
2. Has atomics like atomic_int

**POSIX Threads**
1. More documented
2. Finer control
	- Stack size
	- Thread priority
3. Flexible return types with void*
	- Can return data structures

**Thread v. Processes**
1. Forking makes new process; high overhead
2. Threads avoid IPC
	- Share memory

**Thread Lifecycle**
1. Create
2. Join will wait for return value
3. Detach terminates on its own
4. Remember to use atomics and semaphores

**Results**
1. 50% usually
2. Lower results for varying file sizes

## X (Cloud Computing)
**Cloud Computing**
1. On demand computing Resources
2. Platform, Software, Infrastructure (PSI)
	- Azure, Google Docs, raw VMs
	- Upload code to make website or smth, literally an application, literally a VM
3. Partition physical machines to VMs
	- Customers share same physical machine, but different VM

**Problems**
1. **Load balancing inefficiencies**
2. Provider hardware bottlenecks

**Load Balancing Solutions**
1. VectorDot: dot-product
2. Predictive Scheduling: Genetic algorithms and old data
3. Task Scheduling: Classify VMs
	- Underloaded, balanced, overloaded
4. Active Clustering: dynamically rewire network graph

**Parallelism**
1. Remember pipelining and Amdahl's law
	- yk semaphores

**Cost to Benefit for Cloud Computing** *(BDP)*
1. Base: Power, hardware, maintenance
	- Amortization: cost / time it lasts
		- ex. laptop costs 1200, lasts 3 years, amortization is 400
2. Data Pattern: time and demand analysis
3. Project Specific: project software cost

**Organization Size Cost**
1. Small/Medium: Cloud computing
2. Large: In-house

**Cloud & Parallel Processing**
1. For distributed caching in wireless networks
2. Helped with up/downlink delay and traffic load

# DD (Chess)
**Chess Engine**
1. Move Generation
	- Legal moves (constant)
2. Search Algorithm
	- Evaluate future moves
	- Most expensive
3. Evaluation Function
	- Scores to positions

**Mini-Max**
1. Uses tree graph (DFS)
2. Choosing the worst possible move for the opponent
3. Can also choose best possible move for themself

**Alpha-Beta Pruning**
1. Removes branches
2. Has alpha as best max (lower bound), and beta for best min
3. **Steps**
	1. Parent node is max value
	2. Children nodes are min values
		1. If child node is greater than parent node, change parent node value after prune
	3. Children's children nodes are removed if lower than min value

**Advanced Optimization**
1. Tom Kerrigan's Engine
	- Use transposition hash table with locked buckets
	- Avoids race condition
2. Simplified ABDADA
	- Threads work on same move first
	- Threads will mark if they are currently working on a node so other threads won't work on it
		- Later, threads read from table to get info from the other threads
