Unfortunately, I cannot access the Stuyvesant machines from home today.
When I try to SSH in, the cursor just blinks at me, and no text appears.
Eventually there's a pop-up reading "Network Error: Connection timed out."

I also cannot recall my partner's name.  Hopefully he knows mine.

Here's the basic gist of my changes to the original:

public void insert(E d){
Node<E> n = new Node<E>(d);
if(current == null)current = n;
else{
n.next = current;
n.prev = current.prev;
if(current.prev!=null)current.prev.next = n;
current.prev = n;
current = n;
}
}

AND

in toString(): make a temporary node to run backwards instead of current

BETTER: use 2 temporary nodes to run forward and backwards from current,
instead of going all the way back and then all the way forward.
