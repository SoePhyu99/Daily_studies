public class AVLtrees {
    
    private class AVLnode{
        private int value;
        private int height;
        private AVLnode leftChild;
        private AVLnode rightChild;

        public AVLnode(int value) {
            this.value = value;
        }
    }

    private AVLnode check(AVLnode root) {
        if(leftHeavy(root)){
            System.out.println("Left Heavy");
            if(balanceFactor(root.leftChild) < 0){
                System.out.println("root.leftchild is right heavy");
                root.leftChild = rotateLeft(root.leftChild);
            }
            return rotateRight(root);
        }
        if(rightHeavy(root)){
            System.out.println("Right Heavy");
            if(balanceFactor(root.rightChild) > 0){
                System.out.println("rightchild is left heavy");
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root);
        }
        return root;
    }

    private AVLnode root;
    public void insert(int value) {
        root = insert(value, root);
    }
    private AVLnode insert(int value, AVLnode root) {
        AVLnode node = new AVLnode(value);
        if(root == null){
            return node;
        }
        if(value < root.value){
            root.leftChild = insert(value, root.leftChild);
        }
        if(value > root.value){
            root.rightChild = insert(value, root.rightChild);
        }
        setHeight(root);
        return check(root);
    }
    private AVLnode rotateLeft(AVLnode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }
    private AVLnode rotateRight(AVLnode root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLnode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }
    private int height(AVLnode node) {
        return (node == null) ? -1 : node.height;
    }
    private int balanceFactor(AVLnode node){
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }
    private boolean leftHeavy(AVLnode node) {
        return balanceFactor(node) > 1;
    }
    private boolean rightHeavy(AVLnode node) {
        return balanceFactor(node) < -1;
    }
}
