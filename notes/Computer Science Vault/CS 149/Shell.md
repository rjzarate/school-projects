Reads commands you want to execute and tells the [[Operating System]] to execute your given commands
- Written in C!
- 
## `|` operator
[[Pipes]]
Connects two processes together
- Can connect multiple process with multiple `|`
## `./program_name`
Runs a program in the **current** directory
## `~/program_name`
Runs a program in the **home** directory
## `ps`
Shows what programs (processes) are running
- Many would be kernel level
## `echo $?`
Returns exit code of the last process that ran
## `kill -9 ProcessID`
Kills the process with the given `ProcessID`
Cannot kill other user's processes (unless your a super user) or `root` processes
## `cut`
Reads input (standard input) and outputs it
- Can also read files