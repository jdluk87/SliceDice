import java.awt.Color;

public class SliceDice{
    public static int N;

	/**
	 * The method draws the even levels
	 * @param node
	 * @param level
	 */
    public static void drawOddLevel(Node node, int level){
    	
    	/*
    	 * If it is a leaft or it is the last level, return
    	 */
        if (node.getChildren() == 0 || level == N)
            return;

        int numberOfChildren = node.getChildren();
		
        /*
    	 * Calculating the length of the parent node
    	 */
        double length = node.getX1() - node.getX0();
		
        /*
    	 * Calculating x0 of the first child
    	 */
        double childX0 = (length / numberOfChildren) + node.getX0();
		
        /*
    	 * Calculating length of children nodes
    	 */
        double k = childX0 - node.getX0();

		//Auxiliary indexes
        double auxX0;
        double auxX1;
        double auxY0;
        double auxY1;

		//Loop on childre
        for (int i = 1; i <= numberOfChildren; i++){
            StdDraw.line(childX0, node.getY1(), childX0, node.getY0());

			//Updating indexes
            auxX0 = childX0 - k;
            auxX1 = childX0;
            auxY0 = node.getY0();
            auxY1 = node.getY1();
            
            //i-th child
            Node child = new Node();

            /*
             * The function extract the random number of children for the i-th node, from 0 to 5
             */
            int r = (int)(Math.random() * 5);

            child.setChildren(r);
            child.setX0(auxX0);
            child.setY0(auxY0);
            child.setX1(auxX1);
            child.setY1(auxY1);

            System.out.println("X0, Y0, X1, Y1: "+ child.getX0() +", "+ child.getY0() +", "+ child.getX1() +", "+ child.getY1());

			//Incrementing the x0 value for next child node
            childX0 += k;

			//Printing the subtree for even levels
            drawEvenLevel(child , level + 1);
        }
    }
	
	/**
	 * The method draws the even levels
	 * @param node
	 * @param level
	 */
    public static void drawEvenLevel(Node node, int level){
        if (node.getChildren() == 0 || level == N)
            return;

        int children = node.getChildren();
		
        double height = node.getY1() - node.getY0();
        
		double k = (height / children) + node.getY0();
		double k2 = k - node.getY0();
		
        double auxX0;
        double auxX1;
        double auxY0;
        double auxY1;

        for (int i = 1; i <= children; i++){
            StdDraw.line(node.getX0(), k, node.getX1(), k);

            auxX0 = node.getX0();
            auxX1 = node.getX1();
            auxY0 = k - k2;
            auxY1 = k;

            Node child = new Node();

            int r = (int)(Math.random() * 5);

            child.setChildren(r);
            child.setX0(auxX0);
            child.setY0(auxY0);
            child.setX1(auxX1);
            child.setY1(auxY1);

            System.out.println("x0, y0, x1, y1: "+ child.getX0() +", "+ child.getY0() +", "+ child.getX1() +", "+ child.getY1());

            k += k2;

            drawOddLevel(child, level + 1);
        }
    }
    
    public static void main(String[] args){
        N = Integer.parseInt(args[0]);
		
        Node root = new Node();
        root.setX0(0);
        root.setY0(0);
        root.setX1(700);
        root.setY1(700);
        
        /*
         * Base case: number of level is zero. Print the root without children
         */
        if (N == 0){
            
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.filledSquare(root.getX0(), root.getY0(), 700);
        }
		
        /* 
		 * If n != 0 -->
		 *	1. Print root
		 *	2. Set number of children
		 *	3. Call drawOddLevel
		 */
        else{
            int r = (int)(Math.random() * 5);

            root.setChildren(r);

            StdDraw.square(root.getX0(), root.getY0(), 700);

            drawOddLevel(root, 0);
        }
    }
}
