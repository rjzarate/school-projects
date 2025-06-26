Send tiny bits of information to the OS
- Similar to [[Pipes]] but for smaller info and to the OS
- OS reads the signal and then finds where to send the signal to (i.e. user, process)

Can come from:
- The user
- Processes
- OS

## Signal Handler
A function for when a signal is received, the function runs

## Examples

SIGINT: when you press `Ctrl-C` in the terminal when running a process
SIGQUIT: when you press `Ctrl-\` in the terminal when running a process, will also kill its children
SIGKILL: int code `-9`; kills the running process; cannot be overridden