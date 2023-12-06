public class Node {

    private String vocaboloIng;
    private String vocaboloIta;
    private Node left;
    private Node right;

    public Node() {
        this.vocaboloIng = "";
        this.vocaboloIta = "";
        left = null;
        right = null;
    }

    public String getVocaboloIng() {
        return vocaboloIng;
    }

    public String getVocaboloIta() {
        return vocaboloIta;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setVocaboloIng(String vocaboloIng) {
        this.vocaboloIng = vocaboloIng;
    }

    public void setVocaboloIta(String vocaboloIta) {
        this.vocaboloIta = vocaboloIta;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}