public class PrintQueue{
    private FileTesto file;
    private Node head;

    public static class Node{
        private char value;
        private Node next;

        Node(char value){
            this.value = value;
            next = null;
        }
    }

    PrintQueue(FileTesto file){
        this.file = file;
    }

    public void push(char value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void pop(){
        if (head != null) {
            head = head.next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void verifica(){
        Pila stack = new Pila("");
        for (int i = 0; i < espressione.length(); i++) {
            char carattere = espressione.charAt(i);
            if (carattere == '{' || carattere == '[' || carattere == '(') {
                stack.push(carattere);
            } else if (carattere == '}' || carattere == ']' || carattere == ')') {
                if (stack.isEmpty()) {
                    System.out.println("Parentesi non bilanciate");
                    return;
                }
                char parentesiAperta = stack.head.value;
                if ((carattere == '}' && parentesiAperta == '{') ||
                        (carattere == ']' && parentesiAperta == '[') ||
                        (carattere == ')' && parentesiAperta == '(')) {
                    stack.pop();
                } else {
                    System.out.println("Parentesi non bilanciate");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Parentesi bilanciate");
        } else {
            System.out.println("Parentesi non bilanciate");
        }
    }
}