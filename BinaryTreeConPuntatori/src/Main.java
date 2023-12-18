public class Main {
    public static void main(String[] args) {
        BinaryTree AB = new BinaryTree();

        // ((( 30 ) 20 ) 10 (( 50 ) 40 ( 60 ( 70 ))))
        System.out.println(AB.print(AB.getRoot()));
        // esiste 20 = true
        System.out.println("esiste 20 = " + AB.search(20, AB.getRoot()));
        // esiste 25 = false
        System.out.println("esiste 25 = " + AB.search(25, AB.getRoot()));
        // numero foglie = 3
        System.out.println("numero foglie = " + AB.contaFoglie(AB.getRoot()));
    }
}
