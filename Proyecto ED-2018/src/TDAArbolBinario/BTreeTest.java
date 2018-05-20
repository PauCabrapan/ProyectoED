package TDAArbolBinario;

public class BTreeTest {
	public static void main(String args[]) {
		BinaryTree<Integer> a=new ArbolBinario<Integer>();
		try {
			System.out.println(a.size());
			a.createRoot(1);
			System.out.println(a.size());
			Position<Integer> dos=a.addLeft(a.root(),2);
			System.out.println(a.size());
			Position<Integer> tres=a.addRight(a.root(),3);
			System.out.println(a.size());
			Position<Integer> cuatro=a.addLeft(dos, 4);
			System.out.println(a.size());
			Position<Integer> cinco=a.addLeft(tres, 5);
			System.out.println(a.size()+"=¿5?");
			for(Position<Integer> p: a.positions())
				System.out.println(p.element());
			System.out.println("Fin");
			a.remove(tres);
			for(Position<Integer> p: a.positions())
				System.out.println(p.element());
		}catch(InvalidOperationException |InvalidPositionException |EmptyTreeException e) {System.out.println(e.getMessage());}
		
	}

}
