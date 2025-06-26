---
aliases:
  - Deadlocks
---

Any two or more processes are forced to wait.
- Possible that waiting processes can **never again become ready**

Is a **non-deterministic** bug

Examples:
1. Process 1 (P1) waits on P2, P2 waits on P3, and P3 waits on P1
2. Two people crossing the river for alternate sides; cannot go around each other