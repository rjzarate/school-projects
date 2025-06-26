`import pandas as pd`
## Objects
1. DataFrame
2. Series
### DataFrame
Usually named as `df`
- Similar to a table
#### Constructor
`pandas.DataFrame(data, index=rowLabel)`
- `data` is a [[Dictionaries|Dictionary]]
	- Keys are strings for the **column names**
	- Values are [[Lists]]
- `rowLabel` is a string [[Lists|List]] equal to the **amount of rows**
	- If not set, row label will default to `0, 1, 2, 3, ...`
### Series
A **sequence** of values
- Similar to a list
#### Constructor
`pandas.Series(data, index=rowLabel, name=stringName, dtype=dType)`
- `data` is a List
- `rowLabel` is a string [[Lists|List]] equal to the **amount of rows**
	- If not set, row label will default to `0, 1, 2, 3, ...`
- `stringName` is the **name of the overall Series**
- `dType` is the type of the elements?
	- Defaults to `object`

## Functions & Attributes
### `pandas.read_csv(fileName)`
Reads data in the `file` *(.csv)*
- Returns a **DataFrame**
- Has a bunch of optional arguments
### `dataFrame[columnName]`
Returns a list?
- Can return a series with `dataFrame[columnName].describe()`
### `dataFrame.shape`
Basically **size**
Returns a 2-Element Tuple:
1. Amount of entries (rows)
2. Amount of columns
### `dataFrame.dtypes`
Get the types of the DataFrame column
Returns a **Series**
- `index` is the column names of the DataFrame
- `data` is the `dtype` of each column
### `dataFrame.info()`
Gives info stuff
### `dataFrame.head(num)` / `dataFrame.tail(num)`
Returns another DataFrame of the first or last elements depending on `num`


