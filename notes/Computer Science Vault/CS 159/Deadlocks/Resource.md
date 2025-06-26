---
alias: Resources
---

Operating system uses resources.
- Finite amount
- Processes uses these resources

Processes uses these resource by:
1. **Request** the resource
	1. If not available, must wait *(hangs)*
2. **Use** the resource
3. **Release** the resource

For deadlocks, Process A is **using** Resource X, **requests** for Resource Y, but Resource Y is not available, so Process A waits and **never releases** Resource X until Resource Y is available.