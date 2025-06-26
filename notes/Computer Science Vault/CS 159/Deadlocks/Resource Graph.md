For Deadlock Detection

**Directed** graph with **2 types of nodes**:
1. Square Nodes *(Resources)*
2. Circle Nodes *(Processes)*
- Put letter in those nodes for a unique name

If:
1. Square Node points to Circle Node
	1. Resource is **held** by Process
2. Circle Node Points to Square Node
	2. Resource is being **requested** by Process
- Cannot have Square points Square or Circle points Circle

If a **cycle occurs**, then there is a **deadlock present**