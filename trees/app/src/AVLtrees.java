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

    private AVLnode root;
    public void insert(int value) {
        root = insert(value, root);
    }
    private AVLnode insert(int value, AVLnode root) {
        AVLnode node = new AVLnode(value);
        if(root == null){
            return node;
        }
        System.out.println(root.value + " height " + root.height);
        if(value < root.value){
            root.leftChild = insert(value, root.leftChild);
        }
        if(value > root.value){
            root.rightChild = insert(value, root.rightChild);
        }
        setHeight(root);
        return root;
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
