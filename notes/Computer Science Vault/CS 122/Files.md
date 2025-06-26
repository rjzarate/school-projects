For reading and writing files on the computer
## File Object
## `open(path, mode, encoding)`
- Returns a `file` object
	- `path` where the file is located
	- `mode` is optional, defaulted as `r` (reading)
	- `encoding` is optional, unicode mapping
### `mode` Types
**Can be combined!!**
`r`: reading
`w`: writing
`x`: creating a new file
- Error if it exists
`a`: open for writing, then append at the end of a file
- i.e. logs
`b`: binary mode
`t`: text mode (default)
`+` open a file for reading and writing
- `r+`: Read and Write Mode
	1. File MUST exist
	2. Will start at the beginning, but REPLACE (override) existing data
- `w+`: Write and Read Mode
	1. Will DELETE (truncate) existing File if it exists
	2. Will start at the beginning
## `file.close()`
File should be **closed**, especially after writing!
### `with`
Using `with` with `file.open()` will **automatically close the file**
#### Syntax
```
with open('file_name.txt', 'r') as file_object:
	# do stuff with file_object
```
## `file.write(string)`
Will append string without adding `\n` (new line) at the end
### `file.writeLines(list[string])`
Will write multiple lines of strings, appending `\n` to the end
## `file.readLine()`
Reads one line
### `file.readLines()`
Bad, because imagine a file with a lot of lines
## Best Practice For Reading Files
Using a [[Loops#`for` loop|For Loop]] on the file would have it read one line at a time without loading all the lines in memory.
### Syntax
```
with open('file_name.txt', 'r') as file_object:
	for line in file_object:
		# Do stuff with line
```
