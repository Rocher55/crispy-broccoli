
public class ListeDoublementLiée <Type> {
	private int size;
	private cellule head;
	
	ListeDoublementLiée(){
		this.size=0;
		head=new cellule(null,head,head);
		
	}
	
	public void add (Type t) {
		if(size==0) {
			head.data=t;
		}else {
		cellule c;
		c= new cellule(t,head,head.next);
		head.next.prev=c;
		head.next=c;
		head=c;
		}
		size++;
	}
	public void IterateForward() {
		head=head.next;
	}
	public void IterateBackward() {
		head=head.prev;
	}
	public Type getHead() {
		return head.data;
	}
	public int getSize(){
		return this.size;
	}
	
	
	private class cellule{
		cellule next;
		cellule prev;
		Type data;
		
		public cellule(Type data,cellule prev,cellule next){
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
		
		
	}
}
