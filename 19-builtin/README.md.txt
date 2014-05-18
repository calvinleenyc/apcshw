A HashMap has keys and values, so it's good when you have auxillary data along with each key.

A HashSet has keys only, and it's implemented using HashMap with no values.
Good for when you have keys only that you want to order.

A HashMap is implemented using an open hash table, with the hash function provided by the Key itself
(.hashCode() method is inherited from Object) and a LinkedList which stores the key-value pairs.

A TreeMap is implemented using a red-black tree, which is self-balancing.

Findings on speed: for adding 1 million items, HashMap takes 740ms, while TreeMap takes 1362ms.
For 2M items, HashMap takes 1552, while TreeMap takes 2748.

The name is PriorityQueue.