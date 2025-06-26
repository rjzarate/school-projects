**Four conditions** for deadlocks to occurs:
1. **Mutual Exclusion**
2. **Hold and Wait**
3. **No Preemption**
4. **Circular Wait**
### Mutual Exclusion Condition
Only **one process** for **one particular resource**

Process must **wait** if particular resource is being used until it is released
### Hold and Wait Condition
A **process can hold resources** *(granted earlier)* and **request for new resources**

Process will continue to **wait** and **hold its resource(s)**
### No Preemption Condition
Resources can only be **released voluntarily by the process**
### Circular Wait Condition
There is a **wait chain of two or more processes**

Each process is waiting for a **resource held by the next process of the chain**