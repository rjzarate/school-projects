try:
  # check for valid filename
  # KeyboardInterupt
  input_file = input('enter filename:\n')

  # FileNotFound
  f = open(input_file)
  dna = f.read().rstrip("\n")

  # check for valid number
  pieces = input('enter number of pieces:\n')

  # check that number is not zero or negative
  # ValueError
  pieces = int(pieces)

  # Must be Postive
  assert pieces > 0, 'number of pieces must be greater than zero'

  # chopping the sequence in to pieces
  piece_length = int(len(dna) / pieces)
  print('piece length is ' + str(piece_length))
  for start in range(0, len(dna)-piece_length+1, piece_length):
      print(dna[start:start+piece_length])


except KeyboardInterrupt as e:
  print(e.args[0])

except FileNotFoundError as e:
  print(e.strerror)

except ValueError as e:
  print(e.args[0])

except AssertionError as e:
  print (e)