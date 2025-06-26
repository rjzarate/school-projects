**Allocated Virtual Memory**

Virtual memory allocates (maps) to your physical memory
- Not the same place

Prevents **external** fragmentation
- Unused outside the allocation

Two Parts:
- Page (Virtual) Address (Column #)
	- Kind of like the index
	- Used in the page table
- Page Offset (Row #)
	- Determined by the **page size**
	- Used in the physical memory
	

## Page Table
Matches the page's [[Frames]] using the Page Address & Offset
1. Use the page address in the Page table
2. Go to that address in the physical memory
3. Add the page offset
Every [[Process]] has a **page table**
- Every process has a **pointer** to the page table