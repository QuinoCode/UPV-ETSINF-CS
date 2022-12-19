module Queue where
data Queue a = Queue [a] [a]
empty = Queue [] []
enqueue y (Queue xs ys) = Queue xs (y:ys)
dequeue (Queue (x:xs) ys) = Queue xs ys
dequeue (Queue [] ys) = dequeue (Queue (reverse ys) [])
first (Queue (x:xs) ys) = x
first (Queue [] ys) = head (reverse ys)
isEmpty (Queue [] []) = True
isEmpty _ = False
size (Queue a b) = length a + length b

instance (Show a) => Show (Queue a) where
  show :: (Show a) => (Queue a) -> String
  show (Queue [] []) = " <- "
  show (Queue (x:xs) ys) = " <- " ++ show x ++ show (Queue xs ys)
  show (Queue [] [y]) = " <- " ++ show y --Esta línea realmente es para mejorar la velocidad de ejecución en 
                                         -- el caso en el que haya un solo elemento en la segunda lista
                                         -- y la primera esté vacía. Funcionaria sin él pero menos eficientemente.
  show (Queue [] (y:ys)) = show (Queue (reverse (y:ys)) [])
  
