## `scanf(%type, &variable)`
- `%type` is the format specifier (`%s` is string, `%d` in integer)
- `&variable` is the variable of where the input will be put in

Problems:
1. Won't skip leading whitespaces
2. Characters like ‘ABC’ invalid with `%d` format specifier (for ints) and don’t get discarded
	- Can cause infinite loops cause it would just read the same input no matter what the user inputs since it doesn't clear the buffer
3. Won't discard `\n`, leaving it in stdin buffer
	- When doing `fgets` after `fscan`, will just read the same line
### `fgets(variable, sizeof variable, stdin)`
Grabs the input line
- `variable` is the variable of where the input will be put in
Will also **grab/add new line to the string variable!**
### `strtok(string, separator)`
Basically separates a string into multiple substrings with the given separator
- `string` is the string input
- `separator` is what will separate the string into substrings
	- Also known as **tokenizer**
- returns a `token` of `char*`, which can be iterated with:
	- `token = strtok(NULL, separator)` where `token` was the first token

