Python module 
## Import
`import re`
## `match` Object
What is returned when doing `re` functions
### `start()`
Returns the position of where the match was found
### `group()`
Returns what pattern was found
- Useful for patterns with lots of "ors"
## `re.search(pattern, string)`
`pattern`: the pattern
`string`: the string to be searched
Returns a match object that evaluates to true of false
## `re.finditer(pattern, string)`
`pattern`: the pattern
`string`: the string to be searched
Returns a match object that evaluates to true of false

To get all the strings, you recurse the match object with a for loop
## `re.findall(pattern, string)`
`pattern`: the pattern
`string`: the string to be searched
Returns a `list` object of all the substrings that match the pattern
## `re.split(pattern, string)`
`pattern`: the pattern
`string`: the string to be searched
Returns a `list` objects of all the substrings that is split by the pattern