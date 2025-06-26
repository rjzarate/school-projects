## Similarities with Other Programming Languages
1. Immutable
## Single / Double Quotes
Can use `''` or `""` for strings.
- So that you can do `'""'` without needing to use `\`
## Casting
Can [[Cast]] non-strings via `str()`
## Multiplication
Can multiply a string to repeat a string
## New Line v Character Return
Character Return moves cursor to the next line, but doesn't make a new line
## Splicing
### Syntax
`[start:stop:step]`
- Start is inclusive. Defaults to 0
- Stop is exclusive. Default is end of the string
- Step is the number of characters to skip (optional). Default is 1
Ex.
- `str = "ABCDEF"`
- `str[1:4] (returns 'BCD')`
- `str[::2] (returns 'ACE')`
- `str[0:5:3] (returns 'AD')`
- `str[:-1] (returns 'ABCDE')`
	- Equivalent to `str[:5]`
- `str[::-1] (returns 'FEDCBA)`
## Backwards Indexing
Can use negatives to get from the last character to the first character
## String Formating
`f""`
Here, you can use variables and enclose them in `{}` in the string
- Reduces String concatenation
## Joining
Can join a list of characters / strings with `string1.join(string2)`
- Can have `string2` be a list of characters/strings
- In between each `string2_n` is `string1`
## String Regex
Have to import re
- `import re`
### `re.findAll(pattern, string)`
Returns a **list** of substrings that match the pattern
- Can merge list via using `join` function: `''.join(substrings_list)`
## Raw String `r''`
Will treat backslashes `\` as its literal
- `r"This backslash -> \ will show"`
