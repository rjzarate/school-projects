{-
  Name: Froilan Zarate
  Class: CS 152
  Assigment: HW1
  Date: 02-15-2024
  Description: Allows operations for two BigNums, where BigNum is an array (A) of numbers (n_i) 0-999, where BigNum's number is (n_i) * 10^3i + (n_(i-1)) * 10^3(i-1) + ... + n_0 * 10^0 where i is the reversed index.
-}

module BigNum (
  BigNum,
  bigAdd,
  bigSubtract,
  bigMultiply,
  bigEq,
  bigDec,
  bigPowerOf,
  prettyPrint,
  stringToBigNum,
) where

type Block = Int -- An Int from 0-999

type BigNum = [Block]

maxblock = 1000

bigAdd :: BigNum -> BigNum -> BigNum
bigAdd x y = bigAdd' x y 0

bigAdd' :: BigNum -> BigNum -> Block -> BigNum
-- bigAdd' _ _ _ = error "Your code here"
-- Both lists are empty, just add the carry out
bigAdd' [] [] carryOut
 | carryOut > 0 = [carryOut]
 | otherwise = []
-- Left list empty but right list filled, swap lists
bigAdd' [] bigNum2 carryOut = bigAdd' bigNum2 [] carryOut
-- Left list is the only filled list, add carry out and check whether it goes over 1000. continue to the next value
bigAdd' (x:xs) [] carryOut 
 | x + carryOut >= 1000 = x + carryOut - 1000 : bigAdd' xs [] 1
 | otherwise            = x + carryOut        : bigAdd' xs [] 0
-- both lists are filled, add nums together & carry out together, check whether it goes over 1000. continue to the next value
bigAdd' (x:xs) (y:ys) carryOut 
 | x + y + carryOut >= 1000 = x + y + carryOut - 1000 : bigAdd' xs ys 1
 | otherwise                = x + y + carryOut        : bigAdd' xs ys 0


bigSubtract :: BigNum -> BigNum -> BigNum
bigSubtract x y =
  if length x < length y
    then error "Negative numbers not supported"
    else reverse $ stripLeadingZeroes $ reverse result
      where result = bigSubtract' x y 0


stripLeadingZeroes :: BigNum -> BigNum
stripLeadingZeroes (0:[]) = [0]
stripLeadingZeroes (0:xs) = stripLeadingZeroes xs
stripLeadingZeroes xs = xs

-- Negative numbers are not supported, so you may throw an error in these cases
bigSubtract' :: BigNum -> BigNum -> Block -> BigNum
-- Case where subtraction is 100 - 101, as it carries an invisible number later
bigSubtract' [] [] negCarryIn
 | negCarryIn > 0 = error "Negative numbers not supported"
 | otherwise = []
-- Only minuend left, just return the minuend but make sure to subtract with the negCarryIn
bigSubtract' (x:xs) [] negCarryIn
 | x - negCarryIn < 0 = x - negCarryIn + 1000 : bigSubtract' xs [] 1
 | otherwise = (x - negCarryIn) : bigSubtract' xs [] 0
-- Minuend and subtrahend exist. Subtract values and carry from the next Block if needed.
bigSubtract' (x:xs) (y:ys) negCarryIn
 | x - y - negCarryIn < 0 = x - y - negCarryIn + 1000 : bigSubtract' xs ys 1
 | otherwise = x - y - negCarryIn : bigSubtract' xs ys 0



bigEq :: BigNum -> BigNum -> Bool
-- bigEq _ _ = error "Your code here"
-- Lists are both empty. Return true
bigEq [] [] = True;
-- Only left list has elements. Check for leading zeros and continue or is false.
bigEq (x:xs) []
 | x == 0 = bigEq xs []
 | otherwise = False
-- Only right list has elements. Check for leading zeros and continue or is false.
bigEq [] (x:xs)
 | x == 0 = bigEq xs []
 | otherwise = False
-- Both lists has elements. Check for equivalence and continue or is false.
bigEq (x:xs) (y:ys)
 | x == y = bigEq xs ys
 | otherwise = False

bigDec :: BigNum -> BigNum
bigDec x = bigSubtract x [1]

-- Handle multiplication following the same approach you learned in grade
-- school, except that a "block" is 0-999, instead of 0-9.
-- Consider creating a helper function that multiplies a big-number with an
-- integer in the range of 0-999. Once you have that working, you can use it in your
-- solution here.
bigMultiply :: BigNum -> BigNum -> BigNum
-- bigMultiply _ _ = error "Your code here"
bigMultiply list1 list2 = bigMultiply' list1 list2 0

-- Description: Function takes a multiplicand and multiplier. Uses blockMultiply for separating the multiplier, adding the BigAdds. Function also has a Power1000 to keep track of the Block position of the current multiplier block. Power1000 is used for blockMultiply.
-- Parameter 1: BigNum The multiplicand
-- Parameter 1: BigNum The multiplier
-- Parameter 1: BigNum The power1000 ^ n. For blockMultiply for shifting blocks.
-- Return: The multiplicand * multiplier * 1000^power1000 (power1000 is usually 0 in the initial call).
bigMultiply' :: BigNum -> BigNum -> Block -> BigNum
bigMultiply' list1 [] _ = []
bigMultiply' list1 (y:ys) power1000 = bigAdd (blockMultiply list1 y 0 power1000) (bigMultiply' list1 ys (power1000 + 1))
 
-- Description: Function multiplies BigNum with a Block. Function also has a carryOut for adding to the next Block and power1000 for shifting the multiplicand.
-- Parameter 1: BigNum The multiplicand
-- Parameter 2: Block  The multiplier
-- Parameter 3: Block  The carryIn number. When a block is over 999, the excess number will be sent to the next Block.
-- Parameter 4: Block  The power1000 ^ n. Shifts the multiplicand one block to the right.
-- Return:      BigNum The multiplicand * multiplier * 1000^power1000 + carryIn (carryIn is usually 0 in the initial call).
blockMultiply :: BigNum -> Block -> Block -> Block -> BigNum
-- No more in the list, just add to the carry out.
blockMultiply [] _ carryOut 0
 | carryOut >= 1000 = (carryOut `mod` 1000) : blockMultiply [] 0 (carryOut `div` 1000) 0
 | carryOut == 0 = []
 | otherwise = [carryOut]
-- Multiplier is 0, just return 0
blockMultiply _ 0 _ _ = [0]
-- Multiply current BigNum Block with the multiplier Block. Add the carry out over if needed for the next BigNum Block.
blockMultiply (x:xs) multiplier carryOut 0
 | x * multiplier + carryOut >= 1000 = ((x * multiplier + carryOut) `mod` 1000) : blockMultiply xs multiplier ((x * multiplier + carryOut) `div` 1000) 0
 | otherwise = (x * multiplier + carryOut) : blockMultiply xs multiplier 0 0
-- Power 1000 is not 0, add another block to the multiplicand
blockMultiply list multiplier carryOut power1000
 | power1000 > 0 = blockMultiply (0:list) multiplier carryOut (power1000 - 1)




bigPowerOf :: BigNum -> BigNum -> BigNum
bigPowerOf [] [] = []
bigPowerOf list [] = []
bigPowerOf list [0] = [1]
bigPowerOf list [1] = list
bigPowerOf list1 list2 = bigMultiply list1 (bigPowerOf list1 (bigSubtract list2 [1]))

prettyPrint :: BigNum -> String
prettyPrint [] = ""
prettyPrint xs = show first ++ prettyPrint' rest
  where (first:rest) = reverse xs

prettyPrint' :: BigNum -> String
prettyPrint' [] = ""
prettyPrint' (x:xs) = prettyPrintBlock x ++ prettyPrint' xs

prettyPrintBlock :: Int -> String
prettyPrintBlock x | x < 10     = ",00" ++ show x
                   | x < 100    = ",0" ++ show x
                   | otherwise  = "," ++ show x

stringToBigNum :: String -> BigNum
stringToBigNum "0" = [0]
stringToBigNum s = stringToBigNum' $ reverse s

stringToBigNum' :: String -> BigNum
stringToBigNum' [] = []
stringToBigNum' s | length s <= 3 = read (reverse s) : []
stringToBigNum' (a:b:c:rest) = block : stringToBigNum' rest
  where block = read $ c:b:a:[]

sig = "9102llaf"
