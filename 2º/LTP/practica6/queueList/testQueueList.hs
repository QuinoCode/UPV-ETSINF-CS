import Queue
main = do
  -- Enséñame el resultado de desencolar el encolamiento de 1 en la cola vacía. No sé porque se complican tanto xd.
  putStrLn (show (dequeue (enqueue 1 empty)))
  -- Enséñame el resultado de encolar 10 en el encolamiento de 5 en la cola vacía.
  -- También puedes decir: Enséname el resultado de encolar 10 en una cola vacía a la que antes le habíamos encolado 5
  putStrLn (show (enqueue 10 (enqueue 5 empty)))

