-- Problem 1: Complete the following function `selectiveMap` which takes a predicate, p,
-- a function f, and a list lst, and returns a list that is just like lst, but in
-- which every element x that satisfies p is replaced by f applied to x.
-- (An element x satisfies p if (p x) == True.). Do not use any functions from the Haskell prelude.
-- **You may use a helper function.**
--     selectiveMap odd (\x -> x*x) [] => []
--     selectiveMap odd (\x -> 6000) [2,4,6,8,10] => [2,4,6,8,10]
--     selectiveMap odd (\x -> 6000) [3,1,-5] => [6000,6000,6000]
--     selectiveMap even (\x -> x*x) [1,2,3,4,5] => [1,4,3,16,5]
--     selectiveMap (\c -> c == 'q') (\x -> 'u') "quip" => "uuip"
--     selectiveMap (== True) not [True,False,True] => [False,False,False]

selectiveMap :: (a -> Bool) -> (a -> a) -> [a] -> [a]
selectiveMap p f [] = []
selectiveMap p f (x:[]) 
    | p x == True = [f x]
    | otherwise = [x]
selectiveMap p f (x:xs)
    | p x == True = f x : selectiveMap p f xs
    | otherwise = x : selectiveMap p f xs

-- Problem 2: Complete the following function `partition` that takes a predicate, p,
-- and a list lst, and returns a pair of lists (yes,no) such that yes contains the
-- elements of lst that satisfy p and no contains the elements of lst that do not
-- satisfy p. In both yes and no the order of elements is the same as that in lst
-- Do not use any functions from the Haskell prelude nor list comprehension
-- **You may use a helper function.**
-- Sample Usage:
--     partition odd [] => ([],[])
--     partition odd [1..10] => ([1,3,5,7,9],[2,4,6,8,10]
--     partition even [1..10] => ([2,4,6,8,10],[1,3,5,7,9])
--     partition (== 3) [1..5] => ([3],[1,2,4,5])
--     partition (== 3) [5,7,2] => ([],[5,7,2])
--     partition (== 3) [3,3,3] => ([3,3,3],[])
--     partition (== 3) [3,3,4,3] => ([3,3,3],[4])

partition :: (a -> Bool) -> [a] -> ([a],[a])
partition p [] = ([],[])
partition p xs = partition' p xs ([],[])

partition' p (x:[]) (a, b)
    | p x == True = (a ++ [x], b)
    | otherwise = (a, b ++ [x])
partition' p (x:xs) (a, b)
    | p x == True = partition' p xs (a ++ [x], b)
    | otherwise = partition' p xs (a, b ++ [x])

-- Problem 3: Make `LinkedList` a part of Functor and Applicative typeclass. Do not use
-- deriving Functor and Applicative (although doing `deriving Applicative` won't work).
-- Sample Usage:
--     fmap (odd) $ Node 9 (Node 10 None) => Node True (Node False None)
--     fmap (+1) None => None
--     pure 'a' :: LinkedList Char => Node 'a' None
--     pure 1 :: LinkedList Int => Node 1 None
--     (Node (*3) (Node (+2) None)) <*> (Node (6) (Node (9) None)) => Node 18 (Node 11 None)
--     (Node (*3) (Node (+2) None)) <*> (Node (6) None) => Node 18 None
--     (Node (*) (Node (+) None)) <*> (Node (3) (Node (2) None)) <*> (Node (6) (Node (9) None)) => Node 18 (Node 11 None)
--     (*) <$> (Node (3) (Node (2) None)) <*> (Node (6) (Node (9) None)) => Node 18 (Node 18 None)

data LinkedList k = None | Node k (LinkedList k) deriving Show

instance Functor LinkedList where
    fmap f None = None
    fmap f (Node k l) = Node (f k) $ fmap f l

instance Applicative LinkedList where
    pure x = Node x None
    None <*> _ = None
    (Node f fl) <*> (Node x l) = Node (f x) $ fl <*> l


