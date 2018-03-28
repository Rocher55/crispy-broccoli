
public class testLnikedlift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeDoublementLiée<String> l= new ListeDoublementLiée<>();
		System.out.println(l.getHead()+l.getSize());
		
		l.add("10 ");
		System.out.println(l.getHead()+l.getSize());
		l.IterateBackward();
		System.out.println(l.getHead()+l.getSize());
		/*
		l.add("2");
		l.add("3");
		l.add("4");
		System.out.println(l.getHead());
		l.IterateBackward();
		System.out.println(l.getHead());
		l.IterateBackward();
		System.out.println(l.getHead());
		l.IterateBackward();
		System.out.println(l.getHead());
		l.IterateBackward();
		System.out.println(l.getHead());
		l.IterateBackward();
		
		System.out.println(l.getHead());*/
	}

}
