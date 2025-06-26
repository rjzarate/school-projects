## Group 4: Froilan Zarate & Fidel Rodriguez

import re
string = 'aEMo4S2e5W!a%S4I7s!2N2m0S7C7u'
string = string[2::3]
string = ''.join(re.findall('([a-z]|[A-Z])', string))
string = string[::-1]
print(string.upper())
