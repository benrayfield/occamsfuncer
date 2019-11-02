/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

public final class ImmutableLinkedListNode<T>{
	
	public final T data;
	
	public final ImmutableLinkedListNode<T> nextOrNull;
	
	public ImmutableLinkedListNode(T data, ImmutableLinkedListNode<T> nextOrNull){
		this.data = data;
		this.nextOrNull = nextOrNull;
	}

}
