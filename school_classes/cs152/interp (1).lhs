In this lab, we will define a small language and its operational semantics.
We'll first describe the language:

e ::= true
    | false
    | if e then e else e

The "::=" symbol above should be read as "can be", and "|" should be read as "or".
The metavariable "e" represents an expression.
Where needed, we will use "e1", "e2", "e'", etc. as additional metavariables
for expressions.

Representing this language in Haskell is fairly straightforward.

> data Exp = ETrue
>          | EFalse
>          | Eif Exp Exp Exp
>  deriving Show

Notice how the Eif contructor takes 3 parameters which can be any
of the three Exp values. An expression like (Eif ETrue ETrue EFalse) is valid
as well as more recursive ones like
Eif (Eif ETrue EFalse ETrue) ETrue (Eif ETrue EFalse ETrue)


We also need to decide what are the valid values in our language.
The metavariable "v" stands for a value; again, we will use "v1", "v2", "v'", etc.
as needed for clarity.
For our initial language, only "true" and "false" will be valid values.
Note that these are **also** valid expresisons in our language.

v ::= true
    | false

As with our expressions, representing our values in Haskell is straightforward:

> data Val = VTrue
>          | VFalse
>  deriving Show

The next part is to define our "evaluate" function.
We use a downarrow in the slides.
Here we'll use a "->*".

The first 2 rules define the evaluation of boolean expressions.
The value "true" evaluates to itself, and the value "false"
evaluates to itself.

------------- [B-True]
true ->* true

--------------- [B-False]
false ->* false


The next two rules define the behavior of our if expressions.
Both rules specify that e1 should be evaluated first.
Note that we say "evaluated to" and not "is".
Saying "is" would imply "=", which might not be the case.

If e1 evaluates to true, then e2 should be evaluated to get our result.
The statements above the line are the "premises" or "preconditions"
that must be true for this rule to apply.

   e1 ->* true    e2 ->* v
--------------------------------    [B-IfTrue]
  if e1 then e2 else e3 ->* v

If e1 evalates to false, then e3 should be evaluated to get our result.

   e1 ->* false    e3 ->* v
--------------------------------    [B-IfFalse]
  if e1 then e2 else e3 ->* v


With these rules defined, we can convert them to code.
We represent "->*" with an "evaluate" function.
Note that a "->*" in the premises should translate to a recursive call to evaluate.

[B-True] and [B-IfTrue] rules are completed below.
You must complete the other rules.


> evaluate :: Exp -> Val
> evaluate ETrue = VTrue --  [B-True]
> evaluate EFalse = error "Your Code Here"
> evaluate (Eif e1 e2 e3) = case evaluate e1 of
>       VTrue -> evaluate e2 --  [B-IfTrue]
>       _ -> error "Your Code Here"

And here we have a couple of programs to test.
prog1 should evaluate to VTrue and prog2 should evaluate to VFalse

> prog1 = Eif ETrue ETrue EFalse --VTrue
> prog2 = Eif (Eif ETrue EFalse ETrue) ETrue (Eif ETrue EFalse ETrue) --VFalse

The following lines evaluate the test expressions and display the results.
Note the type of main.  'IO ()' indicates that the function performs IO and returns nothing.
The word 'do' begins a block of code, were you can effectively do sequential statements.
(This is a crude generalization, but we'll talk more about what is going on in this function
when we deal with the great and terrible subject of _monads_.)

> main :: IO ()
> main = do
>   putStrLn $ "Evaluating '" ++ (show prog1) ++ "' results in " ++ (show $ evaluate prog1)
>   putStrLn $ "Evaluating '" ++ (show prog2) ++ "' results in " ++ (show $ evaluate prog2)


Once you have the evaluate function working, as discussed in class,
add support for the expressions 'succ e', 'pred e', and integers.

Sample programs for these cases are:
Pred (EInt 5) Answer: VInt 4
Succ (Pred (Succ (Succ (EInt 5)))) Answer: VInt 7
Succ (Eif ETrue (EInt 2) (EInt 10)) Answer: VInt 3

