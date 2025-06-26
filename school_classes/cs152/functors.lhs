> data Tree v =
>     Empty
>   | Node v (Tree v) (Tree v)
>   deriving (Show)

You can ignore the below function, but the idea was to show you how
you can do a search on a binary search tree.

> findT :: Ord v => v -> Tree v -> Maybe v
> findT _ Empty = Nothing
> findT v (Node val left right) =
>   if val == v then
>     Just val
>   else if v < val then
>     findT v left
>   else
>     findT v right

Your job is to add support for fmap to this tree, so that the following call works:

> instance Functor Tree where
>  fmap f (Node val left right) = (Node (f val) (fmap f left) (fmap f right))
>  fmap f Empty = Empty

fmap (+1) (Node 3 (Node 1 Empty Empty) (Node 7 (Node 4 Empty Empty) Empty))

The result should be (Node 4 (Node 2 Empty Empty) (Node 8 (Node 5 Empty Empty) Empty))

You can achieve this by making Tree an instance of the Functor Typeclass.
Take a look at how Maybe and [] were made a part of functor.


