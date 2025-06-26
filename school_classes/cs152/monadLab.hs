-- Below we have some mathematical binary arguments that you may recognize from homework 2.


data Binop =
    Plus     -- +  :: Int  -> Int  -> Int
  | Minus    -- -  :: Int  -> Int  -> Int
  | Times    -- *  :: Int  -> Int  -> Int
  | Divide   -- /  :: Int  -> Int  -> Int
  deriving (Show)

-- applyOp performs these operations, but unlike in the homework,
-- you now must consider errors (represented by 'Nothing').

applyOp :: Binop -> Maybe Int -> Maybe Int -> Maybe Int

-- Plus is done for you.  Notice how code must check for 'Nothing'
-- for each operand.

applyOp Plus mi mj =
  case mi of
    Nothing -> Nothing
    Just i ->
      case mj of
        Nothing -> Nothing
        Just j -> Just $ i + j

-- Minus is also done for you.  This case **does** use monads,
-- but without the do syntax.

applyOp Minus mi mj =
  mi >>= (\i -> mj >>= (\j -> Just $ i - j))

-- Implement Times and Divide.  Try the Times case without monads (as we did with
-- the Plus case).

-- applyOp Times mi mj = error "TBD"
applyOp Times mi mj =
  case mi of
    Nothing -> Nothing
    Just i ->
      case mj of
        Nothing -> Nothing
        Just j -> return $ i * j


-- For the Divide case, use bind (>>=) as we did for Minus.
-- On an attempt to divide by 0, return Nothing as the answer.

-- applyOp Divide mi mj = error "TBD"
applyOp Divide mi mj = 
  mi >>= (\i -> 
  mj >>= (\j ->
    case j of
      0 -> Nothing
      _ -> return $ i `div` j))


-- The following test cases will help you verify your changes.

testapp1 = applyOp Minus (applyOp Times (Just 3) (Just 4)) $ applyOp Divide (Just 8) (Just 2)
testapp2 = applyOp Minus (applyOp Times (Just 3) (Just 4)) $ applyOp Divide (Just 8) (applyOp Plus (Just 3) (Just (-3)))

-- Now implement applyOp', which implements all methods using the do syntax.
-- The Plus case is done for you once again.  Be sure to check for zero with Divide.

applyOp' :: Binop -> Maybe Int -> Maybe Int -> Maybe Int
applyOp' Plus mi mj = do
  i <- mi
  j <- mj
  return $ i + j
applyOp' Minus mi mj = do
  i <- mi
  j <- mj
  return $ i - j
applyOp' Times mi mj = do
  i <- mi
  j <- mj
  return $ i * j
applyOp' Divide mi mj = do
  i <- mi
  j <- mj
  if j == 0 then
    Nothing
    else return $ i `div` j

-- More test cases:

testapp1' = applyOp' Minus (applyOp' Times (Just 3) (Just 4)) $ applyOp' Divide (Just 8) (Just 2)
testapp2' = applyOp' Minus (applyOp' Times (Just 3) (Just 4)) $ applyOp' Divide (Just 8) (applyOp' Plus (Just 3) (Just (-3)))

-- Finally, note the following function for incrementing and decrementing ints.

mincr :: Int -> Maybe Int
mincr i = Just $ i + 1

mdecr :: Int -> Maybe Int
mdecr i = Just $ i - 1

-- Experiment with these functions and the >>= syntax.
-- Here is one example:

testIncDec = Just 7 >>= mincr >>= mincr >>= mincr >>= mdecr
-- Equivalent to: testIncDec = Just 7 >>= (\x -> Just $ x + 1) >>= (\x -> Just $ x + 1) >>= (\x -> Just $ x + 1) >>= (\x -> Just $ x - 1)
testIncDec' = Just 10 >>= mdecr >>= mdecr >>= mdecr >>= mdecr >>= mdecr
testIncDecNothing = Nothing >>= mdecr >>= mdecr >>= mincr

-- Does bind seem more natural in this case than using do?  Why or why not?
-- I feel like doing 'do' feels a lot more natural, as when you have multiple parameters, you would have to make a lot of nested case statements to unwrap the parameter when doing certain operations. However, with 'do', you can basically unwrap all of the parameters and then compare.

