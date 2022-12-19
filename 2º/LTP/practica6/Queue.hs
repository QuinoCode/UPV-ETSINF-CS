module Queue (Queue, empty, enqueue, dequeue, first, isEmpty, size) where
data Queue a = EmptyQueue | Item a (Queue a)
empty = EmptyQueue
enqueue x EmptyQueue = Item x EmptyQueue
enqueue x (Item a q) = Item a (enqueue x q)
dequeue (Item _ q) = q
first (Item a _) = a 
isEmpty EmptyQueue = True
isEmpty _ = False
size EmptyQueue = 0
size (Item _ q) = 1 + size q
-- Instanciar una clase de tipos es indicar como se definen unas funciones la clase Show define 'show' (toString en Java) 
instance (Show a) => Show (Queue a) where --quiero instanciar show para una cola de tipo 'a', siempre y cuando 'a' sea de tipo show
  show EmptyQueue = " <- "
  show (Item x y) = " <- " ++ (show x) ++ (show y)
--x es un elemento de la cola mientras que Y es el resto de la cola
instance (Eq a) => Eq (Queue a) where
  EmptyQueue == EmptyQueue = True 
  EmptyQueue == Item item cola = False
  Item item cola == EmptyQueue = False
  Item item cola == Item item2 cola2 = item == item2 && cola == cola2  
  -- Como son condiciones lógicas simplemente se evalua  

