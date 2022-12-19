
data Tree a = Branch a (Tree a) (Tree a) | Void deriving Show

countProperty :: (a -> Bool) -> (Tree a) -> Int
countProperty function Void = 0
countProperty function (Branch variable Void Void)  
  | function variable == True = 1
  | function variable == False = 0
countProperty function (Branch variable ramaIzq ramaDer) 
  | function variable == True = 1 + (countProperty function ramaIzq) + (countProperty function ramaDer)
  | function variable == False = 0 + (countProperty function ramaIzq) + (countProperty function ramaDer)

