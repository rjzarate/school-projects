**A program that is currently executing becoming a process**
- Also known as **task**
- A program can have **multiple processes** (i.e. tabs/multiple windows for Chrome takes more processes)
	- PROGRAM IS IN **DISK**, PROCESS IS IN **MEMORY**
- Executes on the CPU and loaded into Memory

## Contains
Personal:
1. Address space & global variables
2. Open files
	- When [[Forking (Creating) a New Process]], is a **subset** of open files of the parent process
3. Alarms, signals and signal handlers

Shared:
1. **Mmap memory space**
## Modes
User mode: what the users use
Kernel Mode: creating files
Real Mode
1. BIOS uses Real Mode for Boot Loader program
2. Accessing all the memory that existed
3. 1 MB, 20-bit address bus
### Protected Mode
1. Process to run in their own allocated memory
2. **4 GB, 32-bit address bus** (4 Bytes)
For multitasking ✨

## Process Control
### `exec`
When called, replaces the "Text" portion of the [[Address Allocation#Text]]
- Replaces the current program with a new one
- Means that the **next lines of code will not run**
	- Will only run if an error occurs in `exec()`
#### `execvp`
Passes parameters in an array
- Array should end in NULL
- Each item in the array is put in the terminal, like:
- `$ args[0] args[1] args[2]...`
	- Basically each element puts a space
#### `execlp`
Passes list of parameters
### `wait(...)`
Waits for at least one child process to complete the process
Returns the terminated child [[Process Identifier (PID)]], or negative if there is no child
#### `wait(NULL)`
Doesn't need the status
### `wait(&status)`
Basically an out parameter that gives status (exit code), which can be used for stuff like exit or signals
Status is used for macros (i.e. `WIFEXITED(status)`, `WEXITSTATUS(status)`)
#### `waitpid(pid)`
Waits for a specific process with the given [[Process Identifier (PID)]]

Using negatives uses absolute value
Using -1 uses any child process
Using 0 uses any child process whose process group ID is equal to that of the calling process
Using positives waits for the child who's process value ID equal to 
### `exit`
To **completely** terminate a process so it doesn't execute
- Good for terminating in **subfunctions** (i.e. not in main)

## During Termination (Exit)
1. Deallocate memory (physical and virtual) 
2. Close open files 
3. Notify its parent process

## Process Errors
### Zombie Process
When a process's [[Process Control Block (PC)]] still exists in memory
- "Dead" process that terminated but still has memory
- Parent can call `wait()` on the child process to avoid this
	- Parent can use SIGCHILD signal to know that one of the child processes have finished (must call `wait()`)
All processes are zombie processes for a short period of time
### Orphan Process
When the **parent process is terminated**, but the **child process has not**
- OS sets their parent to PID 1 (Init Process) that will terminate
	- Init Process will terminate the child process when it finishes

## Running Processes in the Background
In the terminal, add ` &` at the end of the program
- Allows you to keep using the terminal
- Ex. `./process &`

Can do other stuff like put background processes in the foreground