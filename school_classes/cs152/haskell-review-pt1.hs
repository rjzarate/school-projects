-- Problem 1: Mulitply a list of numbers. Do *not* use the inbuilt function
-- `product` to solve the problem. Notice how the list items need to be part of
-- the Num typeclass.
product' :: Num p => [p] -> p
product' (p:[]) = p
product' (p:ps) = p * product' ps

-- Problem 2
-- For tuples of size 2, like (3, 'g'), (True, 'b'), we can use
-- functions `fst` or `snd` to get the first and second element
-- of the tuple respectively. fst and snd does not work for tuples
-- of size 3 or more. Complete the 3 functions: first, second, and
-- third to get the first, second, and third elements of a 3 item tuple.

first :: (a, b, c) -> a
-- first _ = error "Complete this function"
first (a, _, _) = a

second :: (a, b, c) -> b
-- second _ = error "Complete this function"
second (_, b, _) = b

third :: (a, b, c) -> c
-- third _ = error "Complete this function"
third (_, _, c) = c

-- Problem 3: Reverse a list but only keep odd positional elements.
-- Although you can solve this probelm without an additional function,
-- you can use a helper function to keep track of odd positions.
-- Sample Usage: reverseOddPos [2,4,6,8,10,12,14] => [14,10,6,2]
-- Sample Usage: reverseOddPos [1,2,3] => [3,1]
-- Sample Usage: reverseOddPos [] => []

reverseOddPos :: [a] -> [a]
-- reverseOddPos xs = error "Complete this function"
reverseOddPos [] = []
reverseOddPos (x:[]) = [x]
reverseOddPos (x:y:xs) = reverseOddPos xs ++ [x]

-- Problem 4 (a): Create a data type `LinkedList` that contains two values:
-- `None` and `Node`. Node will take two parameters, a generic type parameter `k`
-- and a LinkedList of the same type. Refer to how we do this with Trees in class.
data LinkedList k = None | Node k (LinkedList k) deriving (Show)

-- Problem 4 (b): Once you get that done, complete the below two functions:
-- 1. lengthLL: Takes a LinkedList and returns the length. You will need a helper function to
--              keep track of the length
--      Sample Usage: lengthLL (Node 'A' (Node 'B' (Node '*' None))) => 3
--      Sample Usage: lengthLL (None) => 0
-- 2. addLL: Takes two LinkedList and return the sum.
--      Sample Usage: addLL (Node 9 (Node 10 None)) (Node 3 (Node 1 None)) => (Node 12 (Node 11 None))
--      Sample Usage: addLL (Node 9 (Node 10 None)) (Node 3 None) => (Node 12 (Node 10 None))
--      Sample Usage: addLL (Node 3 None) (Node 9 (Node 10 None)) => (Node 12 (Node 10 None))

lengthLL :: LinkedList a -> Int
-- lengthLL _ = error "Complete this function"
lengthLL a = lengthLL' a 0
lengthLL' None x = x
lengthLL' (Node k a) x = lengthLL' a (x + 1)

-- Notice how I specify that the LinkedList type should be part of the Num typeclass
addLL :: (Num a) => LinkedList a -> LinkedList a -> LinkedList a
addLL (None) (None) = None
addLL (Node k a) (None) = Node k a
addLL (None) (Node k a) = Node k a
addLL (Node k1 a1) (Node k2 a2) = (Node (k1 + k2) (addLL a1 a2))

