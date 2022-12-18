--Signum'
signum' x = if x < 0 then -1 else
    if x == 0 then 0 else 1

max' x y = if x > y then x else y